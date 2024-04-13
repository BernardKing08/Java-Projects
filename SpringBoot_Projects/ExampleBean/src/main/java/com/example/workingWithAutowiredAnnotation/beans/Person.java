package com.example.workingWithAutowiredAnnotation.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
	//autowiring using annotation autowired
	//@Autowired(required = false)
	private Vehicle vehicle; 
	private String name;

	
	//autowiring using the constructor method
	@Autowired
	Person(Vehicle vehicle1){
		this.vehicle = vehicle1;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	//autowiring using setter method
	//@Autowired
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public String getVehicle() {
		return vehicle.getName();
	}
	
	
	
}
