package com.group.foctg.holidayMaker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Booking;
import com.group.foctg.holidayMaker.model.Customer;
import com.group.foctg.holidayMaker.repositories.CustomerRepo;

public class CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	public boolean saveCustomer(Customer customer) {
		return true;
	}
	
	public boolean removeCustomer(Customer customer) {
		return true;
	}
	
	public Customer findOne(Long ID) {
		return null;
	}
	
	public Customer findCustomerByEmail(String email) {
		return null;
	}
	
	public List<Booking> findCustomersBookingsByCustomerID(Long ID){
		return null;
	}
	
	public List<Accommodation> findCustomersAccommodationsByCustomerID(Long ID){
		return null;
	}
}
