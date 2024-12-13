package com.ExpenseTracker.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ExpenseTracker.Model.Person;
import com.ExpenseTracker.Repositories.PersonRepository;

@Component
public class ExpenseTrackerNamePwdAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String email = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		Person person = personRepository.readByEmail(email);
		
		if(person != null && person.getPersonId() > 0) {
			if(passwordEncoder.matches(pwd, person.getPwd())) { 
				//if password equals entered password return the user details
				return new UsernamePasswordAuthenticationToken(person.getName(), null);
			}
			else {
				System.out.println("Password Mismatch");
				throw new BadCredentialsException("Invalid credentials");
			}
		}
		else {
			System.out.println("User not found" + email + "jjjjj");
			throw new BadCredentialsException("Invalid Credentials");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
