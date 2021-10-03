package com.example.springsecuritybasicauthauthorities.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class CustomSpringSecurityConfig {

    /**
     * To Test this example
     * Please used password  - ankitr
     *
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userDetails = User.withUsername("ankit").password("{bcrypt}$2a$12$aK98IYK9Uaw1gAOZRZA2xunckjCf57hZkt3uarrbT/bONVUXMbgJW").
                authorities("read", "write", "delete").build();

        UserDetails userDetails1 = User.withUsername("ankitr").password("{bcrypt}$2a$12$aK98IYK9Uaw1gAOZRZA2xunckjCf57hZkt3uarrbT/bONVUXMbgJW").
                authorities("read").build();

        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        inMemoryUserDetailsManager.createUser(userDetails);
        inMemoryUserDetailsManager.createUser(userDetails1);
        return inMemoryUserDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
