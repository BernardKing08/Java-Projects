package com.example.Assesment2.Beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.example.Assesment2.Interface.Tyres;

@Component(value = "Mac")
public class Mac implements Tyres {

	public void move() {
		System.out.println("Mac tyres are moving"); 
	}

}
