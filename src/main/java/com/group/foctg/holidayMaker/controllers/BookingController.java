package com.group.foctg.holidayMaker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group.foctg.holidayMaker.model.Booking;
import com.group.foctg.holidayMaker.services.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/api/booking")
	public boolean saveBooking(@RequestBody Booking booking) {
		return bookingService.saveBooking(booking);
	}
	
	@DeleteMapping("/api/booking")
	public boolean removeBooking(@RequestParam Long bookingId) {
		return bookingService.removeBooking(bookingId);
	}
	
	@PutMapping("/api/booking")
	public boolean updateBooking(@RequestBody Booking booking) {
		return bookingService.updateBooking(booking);
	}
	
	@GetMapping("/api/booking")
	public List<Booking> findBookingsByCustomerId(@RequestParam Long customerId) {
		return bookingService.findBookingsByCustomerId(customerId);
	}
}
