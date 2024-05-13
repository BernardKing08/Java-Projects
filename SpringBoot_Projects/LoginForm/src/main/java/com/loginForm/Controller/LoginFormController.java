package com.loginForm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.loginForm.Model.LoginForm;
import com.loginForm.Service.LoginFormService;

@Controller
public class LoginFormController {
	@Autowired
	private LoginFormService loginFormService; 
	
	@RequestMapping("/form")
	public String form() {
		return "form.html";
	}
	
	@PostMapping(value = "/saveMessage")
	public ModelAndView info(LoginForm loginForm) {
		
		loginFormService.saveInfo(loginForm);
		return new ModelAndView("redirect:/form");
		
	}
	
}
