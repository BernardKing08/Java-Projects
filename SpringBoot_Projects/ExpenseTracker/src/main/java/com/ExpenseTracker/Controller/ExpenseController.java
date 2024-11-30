package com.ExpenseTracker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExpenseController {

    @RequestMapping("/home")
    public String displayHome() {
    	return "index.html";
    }

}
