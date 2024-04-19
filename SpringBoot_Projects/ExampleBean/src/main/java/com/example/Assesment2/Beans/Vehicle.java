package com.example.Assesment2.Beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Assesment2.Interface.Tyres;

@Component
public class Vehicle {
	private String name;
	 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
	
	
}
