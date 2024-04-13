package com.example.Assesment.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import com.example.Assesment.Interface.Speaker;

@Component
@Primary
public class SonicSpeaker implements Speaker{
	private final String name = "Sonic";  

	public String getName() {
		return name;
	}

	@Override
	public String play() {
		return "Sonic speakers Playing sound";
		
	}

}
