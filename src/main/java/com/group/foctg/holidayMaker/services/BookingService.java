package com.group.foctg.holidayMaker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.group.foctg.holidayMaker.model.Booking;
import com.group.foctg.holidayMaker.model.Customer;
import com.group.foctg.holidayMaker.repositories.BookingRepository;

public class BookingService {
	
	@Autowired
	private BookingRepository repository;
	
	
	public boolean saveBooking(Booking booking) {
		return false;
	}
	
	public boolean removeBooking(Booking booking) {
		return false;
	}
	
	public boolean updateBooking(Booking booking) {
		return false;
	}
	
	public List<Booking> findBookingsByUser(Customer customer){
		return null;
	}
}
