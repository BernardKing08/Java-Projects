package com.realestate.realestate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.realestate.model.Person;
import com.realestate.realestate.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person findByEmail(String userEmail) {
        return personRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + userEmail));
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }
}
