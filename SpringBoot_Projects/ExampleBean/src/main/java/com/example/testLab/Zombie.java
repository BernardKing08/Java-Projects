package com.example.testLab;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


public class Zombie {
    private String type;
    private int hp;
    
    
    // defining a post initialization values
    @PostConstruct
    public void start() {
        System.out.println("You loaded the zombie-creator machine");
    }
    
    
    public Zombie() {
    	System.out.println("Creates a new Zombie"); 
    }

    public Zombie(String type, int hp) {
        this.hp = hp;
        this.type = type;
        
        System.out.println(this.getType());
    }

    // generating getter and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    
    // destroying all created beans
    @PreDestroy
    public void end() {
        System.out.println("You destroyed all zombies before you were caught");
    }
}
