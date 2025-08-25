package com.realestate.realestate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.realestate.dto.AdminAllocationDTO;
import com.realestate.realestate.dto.AllocationDTO;
import com.realestate.realestate.mapper.AllocationMapper;
import com.realestate.realestate.model.Allocation;
import com.realestate.realestate.model.Person;
import com.realestate.realestate.model.Room;
import com.realestate.realestate.repository.AllocationRepository;

@Service
public class AllocationService {

    @Autowired
    private AllocationRepository allocationRepository;

    @Autowired
    private AllocationMapper allocationMapper;

    public List<AdminAllocationDTO> getAllNonAdminAllocations() {
        List<Allocation> allocations = allocationRepository.findAllNonAdminAllocations();

        // Debug print the raw allocations from DB
        allocations.forEach(a -> {
            System.out.println("Allocation ID: " + a.getId()
                    + ", Person: " + a.getPerson().getName()
                    + ", Role ID: " + a.getPerson().getRole().getId()
                    + ", Room ID: " + (a.getRoom() != null ? a.getRoom().getId() : "No Room")
                    + ", Status: " + a.getStatus());
        });

        return allocations.stream()
                .map(allocationMapper::toDTO)
                .toList();
    }

    public AllocationDTO getAllocationInfo(Person person) {
        AllocationDTO none = new AllocationDTO("None", "None", "None", "None", "None", "None");
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
                String houseImage = (room.getHouse() != null && room.getHouse().getImageUrl() != null)
                                    ? room.getHouse().getImageUrl()
                                    : "/images/sample-house.jpg"; // fallback
                String houseDescription = (room.getHouse() != null && room.getHouse().getDescription() != null)
                                    ? room.getHouse().getDescription()
                                    : "No description available";
                return new AllocationDTO(uiStatus, roomNo, houseAddress, rent, houseImage, houseDescription);
            })
            .orElse(new AllocationDTO(uiStatus, "None", "None", "None", "/images/sample-house.jpg", "None"));

    }


    private String normalizeAccStatus(String s) {
        if (s == null) return "None";
        if (s.equalsIgnoreCase("Active"))  return "Active";
        if (s.equalsIgnoreCase("Pending")) return "Pending";
        return "None";
    }

        /**
     * Save an allocation
     */
    public Allocation save(Allocation allocation) {
        return allocationRepository.save(allocation);
    }

    /**
     * Find allocation by person
     */
    public Allocation findByPerson(Person person) {
        return allocationRepository.findCurrentActiveOrPendingByPerson(person).orElse(null);
    }
}
