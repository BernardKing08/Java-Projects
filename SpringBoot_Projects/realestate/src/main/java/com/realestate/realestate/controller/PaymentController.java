package com.realestate.realestate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.realestate.realestate.constants.HomeBaseConstants;
import com.realestate.realestate.model.Allocation;
import com.realestate.realestate.model.Payment;
import com.realestate.realestate.model.Person;
import com.realestate.realestate.model.Room;
import com.realestate.realestate.service.AllocationService;
import com.realestate.realestate.service.PaymentService;
import com.realestate.realestate.service.PaystackService;
import com.realestate.realestate.service.PersonService;
import com.realestate.realestate.service.RoomService;

import jakarta.servlet.http.HttpSession;

import java.time.LocalDate;
import java.util.Map;

@Controller
@RequestMapping("/payments")
public class PaymentController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
    
    @Autowired
    private PaystackService paystackService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private PersonService personService;

    @Autowired
    private AllocationService allocationService;

    @Autowired
    private PaymentService paymentService;

    /**
     * Initialize a payment for a specific room.
     */
    @PostMapping("/init/{roomId}")
    public String initPayment(@PathVariable Long roomId,
                              @RequestParam String userEmail,
                              HttpSession session,
                              RedirectAttributes redirectAttributes) {
        try {
            logger.info("Initiating payment for room {} by user {}", roomId, userEmail);

            // Find user by email
            Person user = personService.findByEmail(userEmail);
            if (user == null) {
                logger.error("User not found: {}", userEmail);
                redirectAttributes.addAttribute("error", "User not found.");
                return "redirect:/rooms";
            }

            // Fetch room
            Room room = roomService.findById(roomId);
            if (room == null) {
                logger.error("Room not found: {}", roomId);
                redirectAttributes.addAttribute("error", "Room not found.");
                return "redirect:/rooms";
            }

            // Log current accommodation status for debugging
            logger.info("User {} accommodation status: '{}'", userEmail, user.getAccommodationStatus());
            
            // Only proceed if user has no accommodation (status is null, empty, or "None")
            String currentStatus = user.getAccommodationStatus();
            if (currentStatus != null && 
                !currentStatus.trim().isEmpty() && 
                !currentStatus.equals(HomeBaseConstants.NONE)) {
                logger.warn("User {} already has accommodation status: '{}'", userEmail, currentStatus);
                redirectAttributes.addAttribute("error", "You already applied for accommodation. Current status: " + currentStatus);
                return "redirect:/rooms";
            }

            // Store payment context in session
            session.setAttribute("paymentUserEmail", userEmail);
            session.setAttribute("paymentRoomId", roomId);
            session.setAttribute("paymentAmount", room.getRent());

            // Call Paystack init with callback URL
            String responseJson = paystackService.initializePayment(
                user.getEmail(), 
                room.getRent(),
                userEmail, // Pass userEmail as metadata
                roomId     // Pass roomId as metadata
            );
            
            // Check if initialization was successful
            if (responseJson == null || responseJson.contains("\"status\":false")) {
                logger.error("Payment initialization failed for user {} and room {}", userEmail, roomId);
                redirectAttributes.addAttribute("error", "Payment initialization failed. Please try again.");
                return "redirect:/rooms";
            }

            // Parse out the authorization_url from JSON
            String authUrl = paystackService.extractAuthorizationUrl(responseJson);
            
            if (authUrl == null || authUrl.isEmpty()) {
                logger.error("Could not retrieve payment URL from response: {}", responseJson);
                redirectAttributes.addAttribute("error", "Could not retrieve payment URL.");
                return "redirect:/rooms";
            }

            logger.info("Redirecting user {} to payment URL for room {}", userEmail, roomId);
            return "redirect:" + authUrl; // Send user to Paystack checkout
            
        } catch (Exception e) {
            logger.error("Error initializing payment for room {} by user {}", roomId, userEmail, e);
            redirectAttributes.addAttribute("error", "An error occurred while initializing payment.");
            return "redirect:/rooms";
        }
    }

    /**
     * Callback URL from Paystack after payment.
     */
    @GetMapping("/callback")
    public String handleCallback(@RequestParam(required = false) String reference,
                                 @RequestParam(required = false) String trxref,
                                 @RequestParam(required = false) String status,
                                 HttpSession session,
                                 RedirectAttributes redirectAttributes) {
        try {
            logger.info("Payment callback received - reference: {}, trxref: {}, status: {}", reference, trxref, status);

            // Use trxref if reference is null (Paystack sometimes uses trxref)
            String actualReference = reference != null ? reference : trxref;
            
            if (actualReference == null) {
                logger.error("Payment reference missing in callback");
                redirectAttributes.addAttribute("error", "Payment reference missing.");
                return "redirect:/rooms";
            }

            // Get payment context from session
            String userEmail = (String) session.getAttribute("paymentUserEmail");
            Long roomId = (Long) session.getAttribute("paymentRoomId");
            Float amount = (Float) session.getAttribute("paymentAmount");

            if (userEmail == null || roomId == null) {
                logger.error("Payment context missing from session");
                redirectAttributes.addAttribute("error", "Payment session expired. Please try again.");
                return "redirect:/rooms";
            }

            // Verify payment with Paystack
            String verificationResponse = paystackService.verifyPayment(actualReference);
            boolean paymentSuccessful = paystackService.isPaymentSuccessful(verificationResponse);

            if (paymentSuccessful) {
                logger.info("Payment successful for user {} and room {}", userEmail, roomId);

                // Get payment details for record keeping
                Map<String, Object> paymentDetails = paystackService.extractPaymentDetails(verificationResponse);

                // Find user and room
                Person user = personService.findByEmail(userEmail);
                Room room = roomService.findById(roomId);

                if (user != null && room != null) {
                    // Create payment record
                    Payment payment = new Payment();
                    payment.setPerson(user);
                    payment.setAmount(amount);
                    payment.setPaymentDate(LocalDate.now());
                    payment.setPaymentMethod("Paystack");
                    payment.setStatus("Paid");
                    payment.setReference(actualReference);
                    paymentService.save(payment);
                    logger.info("Payment record created for user {} with reference {}", userEmail, actualReference);

                    // Create allocation record
                    Allocation allocation = new Allocation();
                    allocation.setPerson(user);
                    allocation.setRoom(room);
                    allocation.setStartDate(LocalDate.now());
                    allocation.setEndDate(LocalDate.now().plusYears(1)); // 1 year lease
                    allocation.setStatus("Pending"); // Admin will approve/reject
                    allocationService.save(allocation);
                    logger.info("Allocation created for user {} and room {}", userEmail, roomId);

                    // Update user accommodation status
                    user.setAccommodationStatus(HomeBaseConstants.PENDING);
                    personService.save(user);
                    logger.info("Updated accommodation status to '{}' for user {}", HomeBaseConstants.PENDING, userEmail);
                }

                // Clear payment context from session
                session.removeAttribute("paymentUserEmail");
                session.removeAttribute("paymentRoomId");
                session.removeAttribute("paymentAmount");

                redirectAttributes.addAttribute("success", "Payment successful! Your application is pending approval.");
                return "redirect:/rooms?success=true";
            } else {
                logger.warn("Payment failed for user {} and room {} - reference: {}", userEmail, roomId, actualReference);
                redirectAttributes.addAttribute("error", "Payment failed. Please try again.");
                return "redirect:/rooms?error=Payment failed";
            }
        } catch (Exception e) {
            logger.error("Error handling payment callback", e);
            redirectAttributes.addAttribute("error", "An error occurred while processing your payment.");
            return "redirect:/rooms";
        }
    }

    /**
     * Cancel URL - user cancelled payment
     */
    @GetMapping("/cancel")
    public String handleCancel(HttpSession session, RedirectAttributes redirectAttributes) {
        logger.info("Payment cancelled by user");
        
        // Clear payment context from session
        session.removeAttribute("paymentUserEmail");
        session.removeAttribute("paymentRoomId");
        session.removeAttribute("paymentAmount");
        
        redirectAttributes.addAttribute("error", "Payment was cancelled.");
        return "redirect:/rooms";
    }

    /**
     * Webhook: Paystack will notify here automatically.
     */
    @PostMapping("/webhook")
    @ResponseBody
    public String handleWebhook(@RequestBody String payload,
                                @RequestHeader(value = "x-paystack-signature", required = false) String signature) {
        try {
            logger.info("Webhook received with signature: {}", signature);
            
            if (signature == null) {
                logger.error("Webhook signature missing");
                return "Missing signature";
            }

            // Verify the signature first
            if (!paystackService.verifySignature(payload, signature)) {
                logger.error("Webhook signature verification failed");
                return "Invalid signature";
            }
            
            // Process the webhook
            String result = paystackService.handleWebhook(payload, signature);
            logger.info("Webhook processed: {}", result);
            return result;
        } catch (Exception e) {
            logger.error("Error processing webhook", e);
            return "Error processing webhook";
        }
    }
}