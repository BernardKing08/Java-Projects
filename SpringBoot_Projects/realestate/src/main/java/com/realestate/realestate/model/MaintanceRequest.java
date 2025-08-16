package com.realestate.realestate.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MaintanceRequest {
    private int id; 
    private int houseId; 
    private LocalDate requesDate; 
    private String description; 
    private String status; 
}
