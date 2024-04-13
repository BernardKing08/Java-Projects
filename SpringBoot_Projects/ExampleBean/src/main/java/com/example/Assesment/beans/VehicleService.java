package com.example.Assesment.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Assesment.Interface.Speaker;
import com.example.Assesment.Interface.Tyre;

@Service
public class VehicleService {

	@Autowired
	private Vehicle vehicle;
	
	private Speaker speaker; 
	private Tyre tyre;
	
	
	@Autowired
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	

	@Autowired
	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
	}
	
	public void playsound() {
		System.out.println(speaker.play());
	}
	public void hi() {
		System.out.println("Hi");
	}
	
	
	
	
	
	
	
}
