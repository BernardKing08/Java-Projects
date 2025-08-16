package com.realestate.realestate.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.realestate.realestate.model.Allocation;
import com.realestate.realestate.model.Person;
import com.realestate.realestate.model.Room;

public interface AllocationRepository extends JpaRepository<Allocation, Integer> {

    // Custom query methods can be added here if needed
    // For example, to find allocations by person or room
    List<Allocation> findByPerson(Person person);
    
    List<Allocation> findByRoom(Room room);
    
    // Additional methods can be defined as per requirements
    @Query("SELECT a FROM Allocation a WHERE a.person = :person AND a.status IN ('Active', 'Pending')")
    Optional<Allocation> findCurrentActiveOrPendingByPerson(@Param("person") Person person);
    
}
