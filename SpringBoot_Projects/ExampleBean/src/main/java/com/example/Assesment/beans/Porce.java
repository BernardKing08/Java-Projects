package com.example.Assesment.beans;

import com.example.Assesment.Interface.Tyre;
import org.springframework.stereotype.Component;

@Component
public class Porce implements Tyre {

	private final String name = "Porce";  
	
	public String getName() {
		return name;
	}

	@Override
	public void move() {
		System.out.println("Porce tyre is moving"); 

	}

}
