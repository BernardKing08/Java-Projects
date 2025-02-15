package com.ExpenseTracker.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
	@Bean
	SecurityFilterChain sfc(HttpSecurity http) throws Exception {
        http
        //yet to add csrf protection in the following controllers 
            .csrf(csrf -> csrf.disable()
            )
            .authorizeHttpRequests(auth -> auth
	                .requestMatchers("/home").authenticated()
	                .requestMatchers("/addExpense").authenticated()
	                .requestMatchers("/register").permitAll()
	                .requestMatchers("/assets/**").permitAll()
                    .requestMatchers("/login").permitAll()
                    .requestMatchers("/createUser").permitAll()
                    .requestMatchers("/logout").permitAll()
                    .requestMatchers("/deleteExpense/**").permitAll()
                    .requestMatchers("/displayProfile").authenticated()
                    .requestMatchers("/updateProfile").authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/home", true)
                .failureUrl("/login?error=true")
                .permitAll()
            )
            //this would not work since the login controller is being controlled in the controller class
            .logout(logoutConfigurer -> logoutConfigurer
            		.logoutSuccessUrl("/login?logout=true")
                    .invalidateHttpSession(true).permitAll()
            )
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
