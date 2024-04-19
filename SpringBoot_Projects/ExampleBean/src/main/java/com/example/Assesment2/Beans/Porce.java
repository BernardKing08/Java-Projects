package com.example.Assesment2.Beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.example.Assesment2.Interface.Tyres;

@Component(value = "Porce")
public class Porce implements Tyres {

	@Override
	public void move() {
		System.out.println("Porce tyres are moving"); 

	}

}
