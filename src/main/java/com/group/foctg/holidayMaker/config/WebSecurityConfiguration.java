package com.group.foctg.holidayMaker.config;

import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
	
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
			.withUser("olle")
			.password("{noop}123")
			.roles("USER");
		
	}*/
	
	@Bean
    public UserDetailsService userDetailsService() {

        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("user").password("aa").roles("USER").build());
        return manager;

    }
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // ...
            .csrf().disable();
        
    	/*http.authorizeRequests()
    		.antMatchers("/").permitAll()
			.antMatchers("/**").hasRole("USER")
    		.and().formLogin();*/
		
    }
}