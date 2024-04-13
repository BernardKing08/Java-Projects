package com.example.workingWithComponents;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.workingWithComponents.beans.Vehicle;

@SpringBootApplication
public class Main{
	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(configFile.class); 
		
		var veh = context.getBean(Vehicle.class); 
		veh.setName("Hi");
		System.out.print(veh.getName());
	}
}
