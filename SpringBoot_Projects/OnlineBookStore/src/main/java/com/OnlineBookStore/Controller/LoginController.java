package com.OnlineBookStore.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(@RequestParam(value = "logout", required = false) String logout,
    					@RequestParam(value = "error", required = false) String error, Model model) {
		
		String errorMessage = null;
		
		if (error != null) {
		    errorMessage = "Username or password is incorrect";
		}
		if(logout != null) {
			errorMessage = "You have successfully logged out";
			
		}
		
		model.addAttribute("errorMessage", errorMessage);
				
        return "login";
    }
}
