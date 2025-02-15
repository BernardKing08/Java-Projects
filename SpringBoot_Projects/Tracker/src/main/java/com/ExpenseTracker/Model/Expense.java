package com.ExpenseTracker.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "expense")
public class Expense extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message="Subject must not be blank")
    @Size(min=5, message="Subject must be at least 5 characters long")
	@Column(name = "name")
	private String name; 
	
	@NotNull(message = "Date is required.")
	@Column(name = "date")
	private LocalDate date;
	
	@NotBlank(message="Subject must not be blank")
    @Size(min=5, message="Subject must be at least 5 characters long")
	@Column(name = "description")
    private String description;
	
	@Column(name = "amount")
	private double amount;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "person_id", referencedColumnName = "personId", nullable = true)
	private Person person;
}




