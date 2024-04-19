package com.example.Assesment2.Beans;

import org.springframework.stereotype.Component;

import com.example.Assesment2.Interface.Speakers;

@Component
public class SonySpeakers implements Speakers {

	@Override
	public void play() {
		System.out.println("SonySpeakers playing");

	}

}
