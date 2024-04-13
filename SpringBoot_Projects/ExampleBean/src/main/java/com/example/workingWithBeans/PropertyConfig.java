package com.example.workingWithBeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.workingWithBeans.beans.Human;

/*
 * Experimenting with the different types of Bean declaration 
 * i.e through the use of value, name, or simply using quotation marks
 */
@Configuration
public class PropertyConfig{

	//Bean declaration using the 'name' feature 
	@Bean(name="sandra")
	Human sandra() {
		var sandra = new Human("Sandra", "32", "Farmer");
		return sandra; 
	}
	
	//Bean declaration using the value annotation
	@Bean(value="Paul")
	Human Paul() {
		var paul = new Human("Paul", "40", "Bee-Keeper");
		return paul;
	}
	
	//Bean declaration using ""
	@Bean("Ivor")
	Human Ivor() {
		Human ivor = new Human("Ivor", "23", "Viking"); 
		return ivor; 
	}
	
	//a default bean using the @primary annotation
	@Primary
	@Bean
	Human basic() {
		Human basic = new Human("noName", "0", "Unknown");
		return basic;
	}
}
