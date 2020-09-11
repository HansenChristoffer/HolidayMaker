package com.group.foctg.holidayMaker.config;

import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration
    extends WebSecurityConfigurerAdapter implements ApplicationContextAware {
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http
            // ...
            .csrf().disable();*/
        
    	http
		.authorizeRequests()
			.antMatchers("/").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/")
			.permitAll()
			.and()
		.logout()
			.permitAll();
    }
}