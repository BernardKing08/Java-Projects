package com.ExpenseTracker.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ExpenseTracker.Model.Expense;
import com.ExpenseTracker.Model.Person;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Integer> {

	List<Expense> findTop5ByPersonOrderByIdDesc(Person person);

}
