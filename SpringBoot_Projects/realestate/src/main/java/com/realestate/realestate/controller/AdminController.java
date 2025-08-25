package com.realestate.realestate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.realestate.realestate.dto.AdminAllocationDTO;
import com.realestate.realestate.model.Person;
import com.realestate.realestate.repository.PersonRepository;
import com.realestate.realestate.service.AllocationService;


@Controller
public class AdminController {

    @Autowired
    private AllocationService allocationService;

    @Autowired
    private PersonRepository personRepository;
    
    @GetMapping("/adminDashboard")
    public String displayAdminDetails(Model model) {
        // The logged-in admin details (unwrap Optional)
        Person admin = personRepository.findById(2)
            .orElseThrow(() -> new RuntimeException("Admin not found"));

        // All requests (list of people/allocations)
        List<AdminAllocationDTO> people = allocationService.getAllNonAdminAllocations();
        System.out.println("this is list of people" + people);
        model.addAttribute("admin", admin);   // 👈 single admin (not Optional)
        model.addAttribute("people", people); // 👈 list of requests

        return "adminDashboard";
    }

}


