package com.example.QuickStart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class helloWorldController {
    
    @GetMapping(path = "/hello")
    public String hello() {
        return "Hello World"; 
    }
    
}
