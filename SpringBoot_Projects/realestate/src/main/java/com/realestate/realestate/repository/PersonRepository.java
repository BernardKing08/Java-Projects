package com.realestate.realestate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realestate.realestate.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    
}
