package com.epam.spring.hometask.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("andrew").password("123456").roles("REGISTERED_USER");
        auth.inMemoryAuthentication().withUser("ivan").password("123456").roles("BOOKING_MANAGER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
               .antMatchers("/**").access("hasRole('ROLE_REGISTERED_USER') or hasRole('ROLE_BOOKING_MANAGER')")
                .antMatchers("/events/**").access("hasRole('ROLE_BOOKING_MANAGER')")
                .and().formLogin();
    }
}