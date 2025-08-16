package com.realestate.realestate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.realestate.realestate.service.HouseInfoService;
import com.realestate.realestate.service.RoomService;


@Controller
public class HouseController {

    @Autowired
    private HouseInfoService houseInfoService;

    @Autowired
    private RoomService roomService;

    // Display all houses (products)
    @GetMapping("/rooms")
    public String showRooms(Model model) {
        model.addAttribute("rooms", roomService.getAllRoomsWithHouse());
        return "rooms.html"; // Thymeleaf template name (rooms.html)
    }

    // Display details for a specific house
    @GetMapping("/room/{id}")
    public String showHouseDetails(@PathVariable Integer id, Model model) {
        model.addAttribute("house", houseInfoService.getHouseById(id));
        return "product-details"; // product-details.html
    }
    
}


