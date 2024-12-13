package com.ExpenseTracker.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ExpenseTracker.Model.Person;
import com.ExpenseTracker.Service.PersonService;

import jakarta.validation.Valid;

@Controller
public class PublicController {

	@Autowired
	private PersonService personService;
	
	@GetMapping("/register")
	public String displayRegisterPage(Model model) {
		model.addAttribute("person", new Person());
		return "register";
	}
	
	@PostMapping("/createUser")
	public String createUser(@Valid @ModelAttribute("person") Person person, Errors errors) {
		if(errors.hasErrors()) {
			return "register";
		}
		String isSaved = personService.createNewPerson(person);
		
		if(isSaved != null) {
			return "redirect:/login?register=true";
        }
		else {
            return "register.html";
        }
	}
}
