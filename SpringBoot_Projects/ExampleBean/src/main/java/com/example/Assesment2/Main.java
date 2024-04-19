package com.example.Assesment2;

import java.util.Random;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Assesment2.Beans.*;
import com.example.Assesment2.Interface.Speakers;
import com.example.Assesment2.Interface.Tyres; 

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        // Create a Spring application context based on the configuration in Config.java
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // Retrieve the VehicleService bean from the context
        VehicleService vec = context.getBean(VehicleService.class);
        
        // Configure the speakers and tyres for the vehicle service
        Speakers speaker = configureSpeakers(context);
        Tyres tyre = configureTyres(context);

        // Set the configured speakers and tyres in the VehicleService bean
        vec.setSpeakers(speaker);
        vec.setTyres(tyre);

        // Move the vehicle and play music using the configured components
        vec.move();
        vec.playMusic();
        
        //getting name of vehicle
        System.out.println(vec.getVehicle());

        // Close the application context
        context.close();
    }

    // Method to configure the tyres for the vehicle
    private static Tyres configureTyres(AnnotationConfigApplicationContext context) {
        Random rand = new Random(); 
        
        // Randomly choose between Mac and Porce tyres
        if(rand.nextBoolean()) {
            return context.getBean("Mac", Mac.class);
        } else {
            return context.getBean(Porce.class);
        }
    }

    // Method to configure the speakers for the vehicle
    public static Speakers configureSpeakers(AnnotationConfigApplicationContext context) {
        Random rand = new Random(); 
        
        // Randomly choose between SonySpeakers and BoseSpeakers
        if(rand.nextBoolean()) {
            return context.getBean(SonySpeakers.class);
        } else {
            return context.getBean(BoseSpeakers.class);
        }
    }
}
