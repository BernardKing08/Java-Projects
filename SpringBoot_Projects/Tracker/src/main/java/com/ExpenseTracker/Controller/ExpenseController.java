package com.ExpenseTracker.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ExpenseTracker.Model.Expense;
import com.ExpenseTracker.Service.ExpenseService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/home")
    public String displayTracker(Model model) {
        // Add form object and list of expenses to the model
        model.addAttribute("expenseObject", new Expense());
        model.addAttribute("expenseList", expenseService.getExpenseList());
        model.addAttribute("recentExpenses", expenseService.getRecentExpenses());
        return "index";
    }

    @PostMapping("/addExpense")
    public String addExpense(@Valid Expense expense, Errors errors, Model model) {
        if (errors.hasErrors()) {
            log.error("Validation failed: " + errors.toString());
            model.addAttribute("expenseList", expenseService.getExpenseList());
            return "index";
        }
        expenseService.saveExpenseDetails(expense);
        return "redirect:/home";
    }
}
