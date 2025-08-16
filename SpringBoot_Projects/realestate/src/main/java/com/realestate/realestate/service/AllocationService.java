package com.realestate.realestate.service;


import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.realestate.dto.AllocationDTO;
import com.realestate.realestate.model.Allocation;
import com.realestate.realestate.model.Person;
import com.realestate.realestate.model.Room;
import com.realestate.realestate.repository.AllocationRepository;

@Service
public class AllocationService {

    @Autowired
    private AllocationRepository allocationRepository;

    public AllocationDTO getAllocationInfo(Person person) {
        AllocationDTO none = new AllocationDTO("None", "None", "None", "None");
        if (person == null) return none;

        String acc = person.getAccommodationStatus();
        if (acc == null || acc.equalsIgnoreCase("None")) {
            return none; // no allocation
        }

        // Normalize UI status strictly from Person.accommodationStatus
        String uiStatus = normalizeAccStatus(acc); // "Active" or "Pending" (or "None")

        // Try to load an allocation to populate details; don't fail if missing
        return allocationRepository.findCurrentActiveOrPendingByPerson(person)
            .map(a -> {
                Room room = a.getRoom();
                String rent = room.getRent() != null ? room.getRent().toString() : "None";
                String roomNo = room.getRoomNo() != null ? room.getRoomNo() : "None";
                String houseAddress = (room.getHouse() != null && room.getHouse().getLocation() != null)
                                      ? room.getHouse().getLocation()
                                      : "None";
                return new AllocationDTO(rent, roomNo, houseAddress, uiStatus);
            })
            // If no allocation record yet, still return UI status with blanks for the rest
            .orElse(new AllocationDTO("None", "None", "None", uiStatus));
    }

    private String normalizeAccStatus(String s) {
        if (s == null) return "None";
        if (s.equalsIgnoreCase("Active"))  return "Active";
        if (s.equalsIgnoreCase("Pending")) return "Pending";
        return "None";
    }
}
