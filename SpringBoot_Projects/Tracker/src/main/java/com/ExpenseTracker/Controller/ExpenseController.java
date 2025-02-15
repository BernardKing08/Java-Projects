package com.ExpenseTracker.Controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ExpenseTracker.Model.Expense;
import com.ExpenseTracker.Model.Person;
import com.ExpenseTracker.Repositories.PersonRepository;
import com.ExpenseTracker.Service.ExpenseService;
import com.ExpenseTracker.Service.PersonService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;
    
    @Autowired
    private PersonRepository personRepository;
    
    @Autowired
    private PersonService personService;

    @GetMapping("/home")
    public String displayTracker(Model model, Principal principal) {
    	String email = principal.getName();
    	Optional<Person> personOptional = personRepository.findByEmail(email);
    	
    	if (personOptional.isEmpty()) {
    		log.error("person is not found");
            return "redirect:/login"; // Redirect if person not found
        }

        Person person = personOptional.get(); // Extract person safely

        // Add form object and list of expenses to the model
        model.addAttribute("loggedInPerson", person); // Safe to send the person object
        model.addAttribute("expenseObject", new Expense()); // New expense form object
        model.addAttribute("expenseList", person.getExpense()); // List of person's expenses
        model.addAttribute("recentExpenses", expenseService.getRecentExpenses(person)); // Fetch recent expenses

        return "index";
    }

    @PostMapping("/addExpense")
    public String addExpense(@Valid Expense expense, @RequestParam("personId") int personId, 
                             Errors errors, Model model) {
        if (errors.hasErrors()) {
            log.error("Validation failed: " + errors.toString());
            model.addAttribute("expenseList", expenseService.getExpenseList());
            return "index";
        }
        // Retrieve the person from the database
        Person person = personRepository.findById(personId).orElse(null);
        if (person == null) {
            log.error("Person not found with ID: " + personId);
            return "redirect:/home";
        }

        expense.setPerson(person);// map the expense with the person
        expenseService.saveExpenseDetails(expense);

        return "redirect:/home";
    }

    
    @GetMapping("/deleteExpense")
    public String deleteExpense(@RequestParam int id) {
    	expenseService.deleteExpense(id);
    	
    	return "redirect:/home";
    }
}
