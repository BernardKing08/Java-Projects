package com.ExpenseTracker.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.Errors;
import com.ExpenseTracker.Model.Person;
import com.ExpenseTracker.Model.Profile;
import com.ExpenseTracker.Repositories.PersonRepository;
import com.ExpenseTracker.Model.Address;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProfileController {
	
	@Autowired
	PersonRepository personRepository;

	/*use authentication.getName which will return the email
	 * use the email to get the person details 
	 * and populate the profile details from it
	 * 
	 * and potentially create an instance of it using the httpsession 
	 * to enable using it across multiple classes
	 */
	
	@GetMapping("/displayProfile")
	public ModelAndView displayProfilePage(Authentication authentication) {
	    Person person = personRepository.readByEmail(authentication.getName());
	    System.out.println(person.toString()); // Debugging

	    Profile profile = new Profile();

	    profile.setName(person.getName());
	    profile.setMobileNumber(person.getMobileNumber());
	    profile.setEmail(person.getEmail());

	    if (person.getAddress() != null && person.getAddress().getAddressId() > 0) {
	        profile.setAddress1(person.getAddress().getAddress1());
	        profile.setAddress2(person.getAddress().getAddress2());
	        profile.setCity(person.getAddress().getCity());
	        profile.setState(person.getAddress().getState());
	        profile.setZipCode(person.getAddress().getZipCode());
	    }

	    ModelAndView modelAndView = new ModelAndView("profile.html");
	    modelAndView.addObject("profile", profile);
	    return modelAndView;
	}

	@PostMapping("/updateProfile")
	public String updateProfile(@Valid @ModelAttribute("profile") Profile profile, Errors errors, Authentication authentication) {
	    if (errors.hasErrors()) {
	        return "profile.html";
	    }

	    // Retrieve the logged-in person using email
	    Person person = personRepository.readByEmail(authentication.getName());

	    // Update the person's details
	    person.setName(profile.getName());
	    person.setEmail(profile.getEmail());
	    person.setMobileNumber(profile.getMobileNumber());

	    // Ensure Address exists
	    if (person.getAddress() == null || person.getAddress().getAddressId() == 0) {
	        person.setAddress(new Address());
	    }

	    // Update Address details
	    person.getAddress().setAddress1(profile.getAddress1());
	    person.getAddress().setAddress2(profile.getAddress2());
	    person.getAddress().setCity(profile.getCity());
	    person.getAddress().setState(profile.getState());
	    person.getAddress().setZipCode(profile.getZipCode());

	    // Set transient fields
	    person.setConfirmEmail(person.getEmail());
	    person.setConfirmPwd(person.getPwd());

	    // Save updated person
	    personRepository.save(person);

	    return "redirect:/displayProfile";
	}


}
