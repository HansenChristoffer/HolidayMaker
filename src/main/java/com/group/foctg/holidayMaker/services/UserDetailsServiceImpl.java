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
	private CustomerService customerService;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		/*Customer test1 = new Customer();
		
		test1.setEmail("Olle");
		test1.setPassword("123");
		customerService.saveCustomer(test1);
		
		Customer test2 = new Customer();
		
		test2.setEmail("Frida");
		test2.setPassword("123");
		customerService.saveCustomer(test2);

		Customer test3 = new Customer();
		
		test3.setEmail("Stoffe");
		test3.setPassword("123");
		customerService.saveCustomer(test3);

		Customer test4 = new Customer();
		
		test4.setEmail("Tanvir");
		test4.setPassword("123");
		customerService.saveCustomer(test4);*/
		
		Customer customer = customerRepository.findCustomerByEmail(email);

		return User.builder().username(customer.getEmail()).password(bCryptPasswordEncoder.encode(customer.getPassword())).roles("USER").build();

	}
}