package com.group.foctg.holidayMaker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * The {@link com.group.foctg.holidayMaker.config.WebSecurityConfiguration} Configuration class.
 * 
 * Holds the process for handling the security through-out the system
 *
 * @author Olle Johansson
 */


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	UserDetailsService userDetailsService;

	/**
	 *  Used to configure the authentication process
	 *  @Override {@link org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter}
	 *  @param {@link org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder}
	 *  @throws {@link java.lang.Exception}
	 */
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

	
	/**
	 *  Used to configure end-point restrictions
	 *  @Override {@link org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter}
	 *  @param {@link org.springframework.security.config.annotation.web.builders.HttpSecurity}
	 *  @throws {@link java.lang.Exception}
	 */
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
//                .authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/**").hasRole("USER")
//                .and()
//                .formLogin().disable();//.loginPage("/login").permitAll();

	}

	@Bean
	public BCryptPasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder();
	}
}
