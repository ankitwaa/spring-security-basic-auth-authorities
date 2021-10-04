package com.example.springsecuritybasicauthauthorities.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class CustomWebSecurityConfigurerAdaptor extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests().mvcMatchers("**/post/**").hasAuthority("write").and()
                .authorizeRequests().mvcMatchers(HttpMethod.POST, "**/post/**").hasAuthority("write").and()
                .authorizeRequests().mvcMatchers("**/get/**").hasAuthority("read").and()
                .authorizeRequests().mvcMatchers(HttpMethod.GET, "**/get/**").hasAuthority("read").and()
                .authorizeRequests().mvcMatchers("**/delete/**").access("hasAuthority('delete')");
    }

}
