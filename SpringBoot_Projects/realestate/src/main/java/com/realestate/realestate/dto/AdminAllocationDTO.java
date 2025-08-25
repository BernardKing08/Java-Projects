package com.realestate.realestate.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminAllocationDTO {
    private Long personId;
    private String name;
    private String roomNo;
    private String houseAddress;
    private LocalDate dateApplied;
    private String accommodationStatus;

    // getters & setters
}
