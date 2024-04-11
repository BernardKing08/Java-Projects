package com.example.CourseApp2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Topic {
	@Id
	private String id; 
	private String description; 
	private String unit; 
	
	//creating a no arg constructor
	Topic(){
		
	}
	
	//creating a arg constructor
	Topic(String id, String des, String unit){
		this.id = id; 
		this.description = des; 
		this.unit = unit; 
	}
	
	//generating setter and getter methods
	public String getId() {
		return this.id; 
	}
	public void setId(String id) {
		this.id = id; 
	}
	public String getDescription() {
		return this.description; 
	}
	public void setDesription(String description) {
		this.description = description;
	}
	public String getUnit() {
		return this.unit; 
	}
	public void setUnit(String unit) {
		this.unit = unit; 
	}
}
