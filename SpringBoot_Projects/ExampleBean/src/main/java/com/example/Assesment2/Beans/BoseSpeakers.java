package com.example.Assesment2.Beans;

import org.springframework.stereotype.Component;

import com.example.Assesment2.Interface.Speakers;

@Component
public class BoseSpeakers implements Speakers {

	@Override
	public void play() {
		System.out.println("Bose Speakers playing");

	}

}
