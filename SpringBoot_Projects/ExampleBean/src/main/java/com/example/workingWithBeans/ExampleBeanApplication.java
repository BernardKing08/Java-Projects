package com.example.workingWithBeans;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.workingWithBeans.beans.Human;

@SpringBootApplication
public class ExampleBeanApplication {
	
	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(PropertyConfig.class); 
		
		context.getBean("Ivor", Human.class).printDetails();
		
		context.getBean(Human.class).printDetails();
	}

	

}
