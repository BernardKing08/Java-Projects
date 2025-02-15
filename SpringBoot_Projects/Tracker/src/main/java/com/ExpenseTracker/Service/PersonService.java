package com.ExpenseTracker.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ExpenseTracker.Model.Expense;
import com.ExpenseTracker.Model.Person;
import com.ExpenseTracker.Repositories.PersonRepository;


@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String createNewPerson(Person person) {
        // Check if email or name already exists
        String existingPerson = checkEmailAndName(person);
        if (existingPerson != null) {
            return existingPerson;  // Return "Email" or "Name" if duplicate exists
        }
        // Encode password before saving
        person.setPwd(passwordEncoder.encode(person.getPwd()));
        // Save the person object
        Person savedPerson = personRepository.save(person);
        // Ensure the person is properly saved
        if (savedPerson != null && savedPerson.getPersonId() >= 0) {
            return "Success";  // Return success to indicate successful registration
        }
        return "Failure";  // Indicate failure if not saved
    }

    public String checkEmailAndName(Person person) {
        if (personRepository.findByEmail(person.getEmail()).isPresent()) {
            return "Email";
        }
        if (personRepository.findByName(person.getName()).isPresent()) {
            return "Name";
        }
        return null;
    }

	
}
