package com.OnlineBookStore.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain sfc(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf
            		.ignoringRequestMatchers("/addToCart")
            		.ignoringRequestMatchers("/removeItem")
            ) // Ignore CSRF protection for /addToCart /removeItem
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/addToCart").authenticated()
                .requestMatchers("/removeItem").authenticated()
                .requestMatchers("/book-details/**").permitAll()
                .requestMatchers("/getAllBooks").authenticated()
                .requestMatchers("/books").permitAll()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/assets/**").permitAll()
                .requestMatchers("/order/history").authenticated()
                .requestMatchers("/cart").authenticated()
                .requestMatchers("/order").authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/books", true)
                .failureUrl("/login?error=true")
                .permitAll()
            )
            .logout(logoutConfigurer -> logoutConfigurer
                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .permitAll()
                .deleteCookies("JSESSIONID")
                .permitAll()
            )
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.builder()
            .username("User")
            .password(passwordEncoder().encode("1"))
            .roles("USER")
            .build();

        UserDetails admin = User.builder()
            .username("Admin")
            .password(passwordEncoder().encode("11111"))
            .roles("ADMIN")
            .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
