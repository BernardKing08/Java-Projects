//package com.ExpenseTracker.Configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class ProjectSecurityConfig {
//	
//	@Bean
//	SecurityFilterChain DSFC(HttpSecurity http) throws Exception {
//	    
//		http
//			// Disables CSRF in Spring Security
//			.csrf(csrf -> csrf.disable())
//			// Sets permissions for various sites
//	        .authorizeHttpRequests(auth -> auth
//	        	.requestMatchers("/login").permitAll() // Allow access to login
//	        	.requestMatchers("/dashboard").authenticated() // Authenticated users only
//	        	.requestMatchers("/assets/**").permitAll() // Allow assets
//	        )
//	        // Configure form-based login
//	        .formLogin(form -> form
//	        	.loginPage("/login").permitAll()
//	        	.defaultSuccessUrl("/index")
//	        	.failureUrl("/login?error=true").permitAll()
//	        )
//	        // Configure logout
//	        .logout(logout -> logout
//	        	.logoutSuccessUrl("/login?logout=true")
//	        	.invalidateHttpSession(true)
//	        	.permitAll()
//	        )
//	        // Default HTTP Basic authentication (optional)
//	        .httpBasic(Customizer.withDefaults());
//	    
//	    return http.build();
//	}
//}
