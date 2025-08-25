package com.realestate.realestate.service;

import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PaystackService {

    private static final Logger logger = LoggerFactory.getLogger(PaystackService.class);
    
    @Value("${paystack.secret.key}")
    private String secretKey;

    @Value("${app.base.url:http://localhost:8080}")
    private String baseUrl;

    private final WebClient webClient;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public PaystackService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://api.paystack.co").build();
    }

    /**
     * Initialize payment with callback URLs and metadata
     */
    public String initializePayment(String email, float amount, String userEmail, Long roomId) {
        try {
            logger.info("Initializing payment for email: {}, amount: {}, roomId: {}", email, amount, roomId);

            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("email", email);
            requestBody.put("amount", Math.round(amount * 100)); // Convert to kobo and ensure integer
            requestBody.put("currency", "NGN");
            
            // Set callback URLs
            requestBody.put("callback_url", baseUrl + "/payments/callback");
            requestBody.put("cancel_action", baseUrl + "/payments/cancel");
            
            // Add metadata for tracking
            Map<String, Object> metadata = new HashMap<>();
            metadata.put("user_email", userEmail);
            metadata.put("room_id", roomId.toString());
            metadata.put("payment_type", "room_application");
            requestBody.put("metadata", metadata);

            // Add custom fields for better tracking
            Map<String, Object> customFields = new HashMap<>();
            customFields.put("room_id", roomId.toString());
            requestBody.put("custom_fields", customFields);

            String response = webClient.post()
                    .uri("/transaction/initialize")
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + secretKey)
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(String.class)
                    .doOnError(error -> {
                        logger.error("Paystack API error during initialization: {}", error.getMessage());
                    })
                    .block();

            logger.info("Paystack initialization response received");
            return response;
        } catch (Exception e) {
            logger.error("Error initializing payment with Paystack", e);
            return null;
        }
    }

    /**
     * Backward compatibility method
     */
    public String initializePayment(String email, float amount) {
        return initializePayment(email, amount, email, 0L);
    }

    public String verifyPayment(String reference) {
        try {
            logger.info("Verifying payment with reference: {}", reference);

            String response = webClient.get()
                    .uri("/transaction/verify/{reference}", reference)
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + secretKey)
                    .retrieve()
                    .bodyToMono(String.class)
                    .doOnError(error -> {
                        logger.error("Paystack verification error: {}", error.getMessage());
                    })
                    .block();

            logger.info("Payment verification response received for reference: {}", reference);
            return response;
        } catch (Exception e) {
            logger.error("Error verifying payment with Paystack for reference: {}", reference, e);
            return null;
        }
    }

    public String handleWebhook(String payload, String signature) {
        try {
            JsonNode node = objectMapper.readTree(payload);
            String event = node.path("event").asText();
            JsonNode data = node.path("data");
            
            logger.info("Processing webhook event: {}", event);

            if ("charge.success".equals(event)) {
                String reference = data.path("reference").asText();
                String status = data.path("status").asText();
                String email = data.path("customer").path("email").asText();
                double amount = data.path("amount").asDouble() / 100; // Convert from kobo
                
                logger.info("Successful charge webhook - reference: {}, status: {}, email: {}, amount: {}", 
                           reference, status, email, amount);
                
                // Extract metadata if available
                JsonNode metadata = data.path("metadata");
                if (!metadata.isMissingNode()) {
                    String userEmail = metadata.path("user_email").asText();
                    String roomId = metadata.path("room_id").asText();
                    logger.info("Webhook metadata - userEmail: {}, roomId: {}", userEmail, roomId);
                }
                
                return "Webhook processed successfully";
            } else if ("charge.failed".equals(event)) {
                String reference = data.path("reference").asText();
                String email = data.path("customer").path("email").asText();
                
                logger.warn("Failed charge webhook - reference: {}, email: {}", reference, email);
                return "Failed charge processed";
            }
            
            return "Event not processed: " + event;
        } catch (Exception e) {
            logger.error("Error processing webhook", e);
            return "Error processing webhook";
        }
    }

    public boolean verifySignature(String payload, String signature) {
        try {
            Mac sha512Hmac = Mac.getInstance("HmacSHA512");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA512");
            sha512Hmac.init(secretKeySpec);
            
            byte[] hmacBytes = sha512Hmac.doFinal(payload.getBytes());
            String computedSignature = bytesToHex(hmacBytes);
            
            boolean isValid = computedSignature.equals(signature);
            logger.info("Signature verification: {}", isValid ? "VALID" : "INVALID");
            
            return isValid;
        } catch (Exception e) {
            logger.error("Error verifying signature", e);
            return false;
        }
    }
    
    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte aByte : bytes) {
            result.append(String.format("%02x", aByte));
        }
        return result.toString();
    }

    public String extractAuthorizationUrl(String json) {
        try {
            if (json == null || json.trim().isEmpty()) {
                logger.error("Empty response from Paystack initialization");
                return null;
            }

            JsonNode node = objectMapper.readTree(json);
            boolean status = node.path("status").asBoolean();
            
            if (!status) {
                String message = node.path("message").asText();
                logger.error("Paystack initialization failed: {}", message);
                return null;
            }
            
            String authUrl = node.path("data").path("authorization_url").asText();
            logger.info("Authorization URL extracted successfully");
            return authUrl;
        } catch (Exception e) {
            logger.error("Failed to parse Paystack initialization response: {}", json, e);
            return null;
        }
    }

    public boolean isPaymentSuccessful(String json) {
        try {
            if (json == null || json.trim().isEmpty()) {
                logger.error("Empty verification response from Paystack");
                return false;
            }
            
            JsonNode node = objectMapper.readTree(json);
            boolean status = node.path("status").asBoolean();
            
            if (!status) {
                String message = node.path("message").asText();
                logger.error("Payment verification failed: {}", message);
                return false;
            }
            
            String paymentStatus = node.path("data").path("status").asText();
            boolean isSuccessful = "success".equals(paymentStatus);
            
            logger.info("Payment verification result: {}", isSuccessful ? "SUCCESSFUL" : "FAILED");
            return isSuccessful;
        } catch (Exception e) {
            logger.error("Failed to parse Paystack verification response: {}", json, e);
            return false;
        }
    }

    /**
     * Extract payment details from verification response
     */
    public Map<String, Object> extractPaymentDetails(String json) {
        Map<String, Object> details = new HashMap<>();
        try {
            JsonNode node = objectMapper.readTree(json);
            JsonNode data = node.path("data");
            
            details.put("reference", data.path("reference").asText());
            details.put("amount", data.path("amount").asDouble() / 100);
            details.put("status", data.path("status").asText());
            details.put("paid_at", data.path("paid_at").asText());
            details.put("customer_email", data.path("customer").path("email").asText());
            
            // Extract metadata
            JsonNode metadata = data.path("metadata");
            if (!metadata.isMissingNode()) {
                details.put("user_email", metadata.path("user_email").asText());
                details.put("room_id", metadata.path("room_id").asText());
            }
            
        } catch (Exception e) {
            logger.error("Error extracting payment details", e);
        }
        return details;
    }
}