package com.ExpenseTracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ExpenseTracker.Model.Person;
import com.ExpenseTracker.Repositories.PersonRepository;


@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public String createNewPerson(Person person) {
		String isSaved = checkEmailAndName(person);
		
		//implementing email and name check
		if(isSaved != null) {
			return isSaved;
		}
		
		//encodes the password
		person.setPwd(passwordEncoder.encode(person.getPwd()));
		
		//saves the person object - returns the saved object
		person = personRepository.save(person);
		
        if (null != person && person.getPersonId() > 0)
        {
            return isSaved;
        }
        return isSaved;
	}
	
	public String checkEmailAndName(Person person) {
		
		if(personRepository.findByEmail(person.getEmail()).isPresent()) {
			return "Email";
		}
		if(personRepository.findByName(person.getName()).isPresent()) {
			return "Name";
		}
		
		return null;
	}
}
