package com.example.workingWithAutowiredAnnotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.workingWithAutowiredAnnotation.beans.Person;
import com.example.workingWithAutowiredAnnotation.beans.Vehicle;

public class Main{
	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(Config.class);
		
		Person lucy = context.getBean(Person.class); 
		Vehicle vehicle1 = context.getBean(Vehicle.class); 
		
		System.out.println(lucy.getName()); 
		System.out.println(lucy.getVehicle());
	}
}