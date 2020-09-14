package com.group.foctg.holidayMaker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.group.foctg.holidayMaker.model.*;

import com.group.foctg.holidayMaker.repositories.CustomerRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
				
		Customer customer = customerRepository.findCustomerByEmail(email);

		return User.builder().username(customer.getEmail()).password(bCryptPasswordEncoder.encode(customer.getPassword())).roles("USER").build();

	}
}