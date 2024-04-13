package com.example.Assesment.beans;

import org.springframework.stereotype.Component;
import com.example.Assesment.Interface.Speaker;

@Component
public class Boose implements Speaker {

	private final String name = "Boose";  
	
	public String getName() {
		return name;
	}

	@Override
	public String play() {
		return "Boose speakers playing";

	}

}
