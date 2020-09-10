package com.group.foctg.holidayMaker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Booking;
import com.group.foctg.holidayMaker.model.Customer;
import com.group.foctg.holidayMaker.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public boolean saveCustomer(Customer customer) {
            return customerRepository.saveAndFlush(customer).equals(customer);
	}
	
	public boolean removeCustomer(Long id) {
		if (customerRepository.existsById(id)) {
			customerRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	
	public Customer getOne(Long ID) {
		return customerRepository.getOne(ID);
	}
	
	public Customer findCustomerByEmail(String email) {
		return customerRepository.findCustomerByEmail(email);
	}
	
	public List<Booking> findCustomersBookingsByCustomerID(Long ID) {
		return customerRepository.findBookingsByID(ID);
	}
	
	public List<Accommodation> findCustomersAccommodationsByCustomerID(Long ID) {
		return customerRepository.findAccommodationsByID(ID);
	}
}
