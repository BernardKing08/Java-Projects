package com.ExpenseTracker.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
public class WebConfig {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("index.html");
		registry.addViewController("/login").setViewName("login");
	}
}
