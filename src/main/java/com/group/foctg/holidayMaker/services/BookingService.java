package com.group.foctg.holidayMaker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.foctg.holidayMaker.model.Booking;
import com.group.foctg.holidayMaker.model.Customer;
import com.group.foctg.holidayMaker.repositories.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	
	public boolean saveBooking(Booking booking) {
		return bookingRepository.saveAndFlush(booking).equals(booking);
	}
	
	public boolean removeBooking(Long ID) {
		if (bookingRepository.existsById(ID)) {
			bookingRepository.deleteById(ID);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean updateBooking(Booking booking) {
		return bookingRepository.saveAndFlush(booking).equals(booking);
	}
	
	public List<Booking> findBookingsByCustomerId(Long ID) {
		return bookingRepository.findBookingsByCustomerID(ID);
	}
}
