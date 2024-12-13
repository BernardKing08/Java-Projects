package com.ExpenseTracker.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
	public String displayLoginPage(@RequestParam(value = "logout", required = false) String logout,
									@RequestParam(value = "error", required = false) String error,
									@RequestParam(value = "register", required = false) String register, Model model) {
		String errorMessage = null;
		
		if(error != null) 
			errorMessage = "Username or password is incorrect";
		if(logout != null)
			errorMessage = "You have successfully logged out";
		if(register != null)
			errorMessage = "New User successfully Registered";
		
		model.addAttribute("errorMessage", errorMessage);
		
		return "login";
	}
	
	@GetMapping(value = "/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		return "redirect:/login?logout=true";
	}
}
