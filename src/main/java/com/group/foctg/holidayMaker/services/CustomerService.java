package com.group.foctg.holidayMaker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Booking;
import com.group.foctg.holidayMaker.model.Customer;
import com.group.foctg.holidayMaker.repositories.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	public boolean saveCustomer(Customer customer) {
            return customerRepo.saveAndFlush(customer).equals(customer);
	}
	
	public boolean removeCustomer(Long id) {
		if (customerRepo.existsById(id)) {
			customerRepo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	
	public Customer getOne(Long ID) {
		return customerRepo.getOne(ID);
	}
	
	public Customer findCustomerByEmail(String email) {
		return customerRepo.findCustomerByEmail(email);
	}
	
	public List<Booking> findCustomersBookingsByCustomerID(Long ID) {
		return customerRepo.findBookingsByID(ID);
	}
	
	public List<Accommodation> findCustomersAccommodationsByCustomerID(Long ID) {
		return customerRepo.findAccommodationsByID(ID);
	}
}
