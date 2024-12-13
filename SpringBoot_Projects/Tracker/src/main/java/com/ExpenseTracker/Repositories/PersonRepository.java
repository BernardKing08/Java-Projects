package com.ExpenseTracker.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ExpenseTracker.Model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

	Person readByEmail(String email);

	Optional<Person> findByEmail(String email);
	
	Optional<Person> findByName(String name);
}
