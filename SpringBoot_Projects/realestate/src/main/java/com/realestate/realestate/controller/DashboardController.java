package com.realestate.realestate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.realestate.realestate.dto.AllocationDTO;
import com.realestate.realestate.model.Person;
import com.realestate.realestate.repository.PersonRepository;
import com.realestate.realestate.service.AllocationService;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class DashboardController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AllocationService allocationService;

    @GetMapping("/home")
    public String home(Model model) {
        // Example: Fetch logged-in user (hardcoded for now)
        Person person = personRepository.findById(1).orElse(null);

        AllocationDTO allocationInfo = allocationService.getAllocationInfo(person);

        model.addAttribute("person", person);
        model.addAttribute("allocation", allocationInfo);

        return "index";
    }

    @GetMapping("/contact")
    public String showContactPage(Model model) {
        // You can pass any dynamic data to the UI here if needed
        model.addAttribute("pageTitle", "Contact Support");
        return "contact-us"; // this should match the name of your Thymeleaf HTML file (contact.html)
    }

    
}
