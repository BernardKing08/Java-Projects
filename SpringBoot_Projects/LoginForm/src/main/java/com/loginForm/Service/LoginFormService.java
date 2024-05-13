package com.loginForm.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.loginForm.Model.LoginForm;

@Component
public class LoginFormService {

	private LoginForm loginForm; 
	private static Logger log = LoggerFactory.getLogger(LoginFormService.class);
	
	public boolean saveInfo(LoginForm loginForm) {
		log.info(loginForm.toString());
		return true;
	}

}
