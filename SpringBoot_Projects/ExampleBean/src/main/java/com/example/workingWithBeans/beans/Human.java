package com.example.workingWithBeans.beans;

public class Human {
	private String name; 
	private String age; 
	private String job;
	
	//constructor method for the class
	public Human(String name, String age, String job) {
		this.age = age; 
		this.name = name; 
		this.job = job; 
		
	}
	
	public void printDetails() {
		System.out.println(this.getName());
		System.out.println(this.getAge()); 
		System.out.println(this.getJob()); 
		
		System.out.println();
	}

	//getters and setters for the variables
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	} 
}
