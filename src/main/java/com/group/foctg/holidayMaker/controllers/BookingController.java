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

import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Booking;
import com.group.foctg.holidayMaker.services.BookingService;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * RestController for the {@link com.group.foctg.holidayMaker.model.Booking}
 * entity and column. This class holds all the endpoints for
 * {@link com.group.foctg.holidayMaker.model.Booking}.
 *
 * Autowiring {@link com.group.foctg.holidayMaker.services.BookingService}.
 *
 * The default URL value is set to, "/api".
 *
 * @author Frida Ek
 * @see com.group.foctg.holidayMaker.services.BookingService
 */
@RestController
@RequestMapping(value = "/api")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    /**
     * POST endpoint method that listens on <code>"/booking"</code> URL and will
     * call the {@link com.group.foctg.holidayMaker.services.BookingService#saveBooking}
     * method from the Service.
     *
     * @param booking {@link com.group.foctg.holidayMaker.model.Booking} object
     * to pass to the Service class.
     * @return a boolean value from the autowired Service.
     */
    @PostMapping("/booking")
    public boolean saveBooking(@RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }

    /**
     * DELETE endpoint method that listens on <code>"/booking"</code> URL and
     * will call the
     * {@link com.group.foctg.holidayMaker.services.BookingService#removeBooking}
     * method from the autowired Service.
     *
     * @param id Long value to pass to the Service class.
     * @return a boolean value from the Service.
     */
    @DeleteMapping("/booking")
    public boolean removeBooking(@RequestParam Long id) {
        return bookingService.removeBooking(id);
    }

    /**
     * PUT endpoint method that listens on <code>"/booking"</code> URL and will
     * call the
     * {@link com.group.foctg.holidayMaker.services.BookingService#updateBooking}
     * method from the autowired Service.
     *
     * @param booking {@link com.group.foctg.holidayMaker.model.Booking} value to pass to the Service class.
     * @return {@link com.group.foctg.holidayMaker.model.Booking} object from the service
     */
    
    
    @PutMapping("/booking")
    public Booking updateBooking(@RequestBody Booking booking, @RequestParam Long id) {
        return bookingService.updateBooking(booking, id);
    }

    /**
     * GET endpoint method that listens on <code>"/booking"</code> URL and will
     * call the
     * {@link com.group.foctg.holidayMaker.services.BookingService#findBookingsByCustomerId}
     * method from the autowired Service.
     *
     * @param id Long value to pass to the Service class.
     * @return a List object from the Service.
     */
    @GetMapping("/booking")
    public List<Booking> findBookingsByCustomerId(@RequestParam Long id) {
        return bookingService.findBookingsByCustomerId(id);
    }
}
