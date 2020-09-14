/*
 * Copyright 2020-2030 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.group.foctg.holidayMaker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.foctg.holidayMaker.model.Booking;
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
