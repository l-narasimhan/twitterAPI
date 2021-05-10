package com.example.TwitterApi.config;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {

            //Bypasses spring security authentication and authorization.
        http.csrf().disable().authorizeRequests().antMatchers("/**").permitAll();

            //Disable Spring logout handler
        http.logout().disable();
    }
}
