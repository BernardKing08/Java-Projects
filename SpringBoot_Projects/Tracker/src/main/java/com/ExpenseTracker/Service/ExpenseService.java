package com.ExpenseTracker.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExpenseTracker.Model.Expense;
import com.ExpenseTracker.Model.Person;
import com.ExpenseTracker.Repositories.ExpenseRepository;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    // Fetch all expenses
    public List<Expense> getExpenseList() {
        return (List<Expense>) expenseRepository.findAll();
    }

    // Save a new expense
    public void saveExpenseDetails(Expense expense) {
        expenseRepository.save(expense);
    }
    
    public List<Expense> getRecentExpenses(Person person) {
        // Fetch the 5 most recent expenses based on the id field
        return expenseRepository.findTop5ByPersonOrderByIdDesc(person);
    }
    
    public void deleteExpense(int id) {
    	expenseRepository.deleteById((Integer) id);
    }

}
