package com.example.Assesment.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
	private String name;
	@Autowired
	private VehicleService vehicleService; 
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
}
