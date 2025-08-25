package com.realestate.realestate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.realestate.realestate.model.Person;
import com.realestate.realestate.repository.PersonRepository;
import com.realestate.realestate.service.HouseInfoService;
import com.realestate.realestate.service.RoomService;

@Controller
public class HouseController {

    @Autowired
    private HouseInfoService houseInfoService;

    @Autowired
    private RoomService roomService;
    
    @Autowired
    private PersonRepository personRepository;

    // Display all houses (products)
    @GetMapping("/rooms")
    public String showRooms(Model model,
                           @RequestParam(required = false) String success,
                           @RequestParam(required = false) String error) {
        
        // Get the current user (same logic as dashboard)
        Person person = personRepository.findById(1).orElse(null);
        
        model.addAttribute("rooms", roomService.getAllRoomsWithHouse());
        model.addAttribute("currentUser", person); // Add user to model
        
        // Handle success/error messages from payment redirect
        if (success != null) {
            model.addAttribute("successMessage", "Payment successful! Your application is pending approval.");
        }
        
        if (error != null && !error.equals("null") && !error.trim().isEmpty()) {
            model.addAttribute("errorMessage", error);
        }
        
        return "rooms.html"; // Thymeleaf template name (rooms.html)
    }

    // Display details for a specific house
    @GetMapping("/room/{id}")
    public String showHouseDetails(@PathVariable Integer id, Model model) {
        model.addAttribute("house", houseInfoService.getHouseById(id));
        return "product-details"; // product-details.html
    }
}