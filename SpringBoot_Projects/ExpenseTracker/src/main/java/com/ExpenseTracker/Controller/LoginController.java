package com.ExpenseTracker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String displayLoginPage() {
		return "login";
	}
	
	
	
//	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
//	public String displayLoginPage(@RequestParam(value = "error", required = false) String error,
//									@RequestParam(value = "logout", required = false) String logout,
//									@RequestParam(value = "register", required = false) String register,
//									Model model){
//		String errorMessage = null;
//		if(error != null) {
//			errorMessage = "Email or Password is Incorrect";
//		}
//		else if(logout != null) {
//			errorMessage = "You have Successfully logged out";
//		}
//		else if(register != null) {
//			errorMessage = "Registeration Successful. Login with registered Credentials";
//		}
//		
//		//add errorMessage to the html page
//		model.addAttribute("errorMessage", errorMessage);
//		
//		return "login";
//	}
}
