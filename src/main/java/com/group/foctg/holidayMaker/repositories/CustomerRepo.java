package com.group.foctg.holidayMaker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Booking;
import com.group.foctg.holidayMaker.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>{

	Customer findCustomerByEmail(String email);
	
	List<Booking> findBookingsByID(Long ID);
	
	List<Accommodation> findAccommodationsByID(Long ID);
}
