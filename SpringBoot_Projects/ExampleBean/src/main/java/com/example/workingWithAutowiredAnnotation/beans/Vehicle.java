package com.example.workingWithAutowiredAnnotation.beans;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Vehicle {
	private String name;

	Vehicle(){
		
	}
	
	Vehicle(String name){
		this.name = name; 
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
	
	@PostConstruct
	public void myName() {
		this.name = "Audi"; 
	}

}
