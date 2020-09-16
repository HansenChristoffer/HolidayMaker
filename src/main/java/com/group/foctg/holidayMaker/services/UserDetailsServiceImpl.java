package com.group.foctg.holidayMaker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.group.foctg.holidayMaker.model.*;
import com.group.foctg.holidayMaker.repositories.CustomerRepository;
import java.util.Optional;

/**
 * Service class for the {@link com.group.foctg.holidayMaker.model.Customer}
 * email column. 
 * 
 * @author Olle Johansson
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * To find user by email to authenticate logged in user.
	 * 
	 * @Override loadByUsername from {@link org.springframework.security.core.userdetails.UserDetailsService}
	 * @throws {@link org.springframework.security.core.userdetails.UsernameNotFoundException}
	 * 
	 * @param email String to find {@link com.group.foctg.holidayMaker.model.Customer} object.
	 * @return {@link org.springframework.security.core.userdetails.UserDetails}
	 */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Customer> customer = customerRepository.findCustomerByEmail(email);

        return User.builder().username(customer.get().getEmail()).password(bCryptPasswordEncoder.encode(customer.get().getPassword())).roles("USER").build();
    }
}
