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
public class ExpenseTrackerNamePwdAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        Person person = personRepository.readByEmail(email);

        if (person != null && person.getPersonId() > 0) {
            if (passwordEncoder.matches(pwd, person.getPwd())) {
            	//using the email instead of the person.getName() of the user to prevent duplicate names
                return new UsernamePasswordAuthenticationToken(email, null, null);
            } else {
                throw new BadCredentialsException("Invalid credentials");
            }
        } else {
            throw new BadCredentialsException("Invalid credentials");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
