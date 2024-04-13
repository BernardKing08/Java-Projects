package com.example.Assesment.beans;

import com.example.Assesment.Interface.Tyre;

public class Mec implements Tyre {

	private final String name = "Sonic";  
	
	public String getName() {
		return name;
	}

	@Override
	public void move() {
		System.out.println("Mec tyre is moving"); 

	}

}
