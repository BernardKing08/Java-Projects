package com.example.Assesment.beans;

import org.springframework.stereotype.Component;

@Component
public class Vehicle {
	private String name = "AUDI";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
}
