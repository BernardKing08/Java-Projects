package com.example.Assesment2.Beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Assesment2.Interface.Speakers;
import com.example.Assesment2.Interface.Tyres;

import jakarta.annotation.PreDestroy;

@Component
public class VehicleService {

    private Vehicle vehicle; // The vehicle instance

    private Tyres tyres; // Instance of Tyres interface for vehicle's tires
    private Speakers speakers; // Instance of Speakers interface for vehicle's speakers

    // Constructor injection for Vehicle
    @Autowired
    VehicleService(Vehicle vehicle) {
        this.setVehicle(vehicle);
    }

    
    
    // Method to set the Tyres instance
    public void setTyres(Tyres tyres) {
        this.tyres = tyres;
    }
    // Method to move the vehicle using the Tyres instance
    public void move() {
        tyres.move();
    }

    // Method to set the Speakers instance
    public void setSpeakers(Speakers speakers) {
        this.speakers = speakers;
    }
    // Method to play music using the Speakers instance
    public void playMusic() {
        speakers.play();
    }

    // Method annotated with @PreDestroy to execute before bean destruction
    @PreDestroy
    public void close() {
        System.out.println("Destroying all beans");
    }


	public Vehicle getVehicle() {
		return vehicle;
	}


	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
