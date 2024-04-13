package com.example.Assesment;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Assesment.beans.Boose;
import com.example.Assesment.beans.Person;
import com.example.Assesment.beans.VehicleService;

public class Main {
	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(Config.class);
		
		Boose spea = context.getBean(Boose.class);
		
		
		Person lucy = context.getBean(Person.class); 
		
		VehicleService vs = context.getBean(VehicleService.class);
		vs.setSpeaker(spea);
		vs.playsound();
		vs.hi();
		
		context.close();
	}
}
