package com.realestate.realestate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllocationDTO {
    private String rent;
    private String roomNo;
    private String houseAddress;
    private String status;
}
