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
/**
 * RestController for the {@link com.group.foctg.holidayMaker.model.Accommodation}
 * entity and column. This class holds all the endpoints for
 * {@link com.group.foctg.holidayMaker.model.Accommodation}.
 *
 * Autowiring
 * {@link com.group.foctg.holidayMaker.services.AccommodationService}.
 *
 * The default URL value is set to, "/api".
 *
 * @author Olle Johansson
 * @see com.group.foctg.holidayMaker.services.AccommodationService
 */
package com.group.foctg.holidayMaker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Filter;
import com.group.foctg.holidayMaker.services.AccommodationService;

@RestController
@RequestMapping(value = "/api")
public class AccommodationController {

    @Autowired
    private AccommodationService accommodationService;

    /**
     * GET endpoint method that listens on <code>"/accommodations"</code> URL
     * and will call the
     * {@link com.group.foctg.holidayMaker.services.AccommodationService#findAll}
     * method from the autowired Service.
     *
     * @return a List object from the Service
     */
	@GetMapping("/accommodations")
	public List<Accommodation> allAccommodations() {
		return accommodationService.findAll();
	}

    /**
     * POST endpoint method that listens on <code>"/accommodation"</code> URL
     * and will call the {@link com.group.foctg.holidayMaker.services.AccommodationService#saveAccommodation(com.group.foctg.holidayMaker.model.Accommodation)}
     * method from the Service.
     *
     * @param accommodation
     * {@link com.group.foctg.holidayMaker.model.Accommodation} object to pass
     * to the Service class
     * @return a boolean value from the autowired Service
     */
    @PostMapping("/accommodation")
    public boolean saveAccommodation(@RequestBody Accommodation accommodation) {
        return accommodationService.saveAccommodation(accommodation);
    }

    /**
     * GET endpoint method that listens on <code>"/accommodation/filter"</code>
     * URL and will call the
     * {@link com.group.foctg.holidayMaker.services.AccommodationService#getFilteredAccommodations(com.group.foctg.holidayMaker.model.Filter)}
     * method from the autowired Service.
     *
     * @param filter Filter object to pass to the Service class
     * @return a List of the filtered accommodations
     */
	@GetMapping("/accommodation/filter")
	public List<Accommodation> filterAccommodations(@RequestBody Filter filter) {
		return accommodationService.getFilteredAccommodations(filter);
	}
	
    /**
     * GET endpoint method that listens on <code>"/accommodation"</code> URL and
     * will call the
     * {@link com.group.foctg.holidayMaker.services.BookingService#getOne(java.lang.Long)}
     * method from the autowired Service.
     *
     * @param id Long value to pass to the Service class
     * @return a {@link com.group.foctg.holidayMaker.model.Accommodation} object from
     * the Service
     */
    @GetMapping("/accommodation")
    public Accommodation findAccommodationById(@RequestParam Long id) {
        return accommodationService.getOne(id);
    }

    /**
     * PUT endpoint method that listens on <code>"/accommodation"</code> URL and
     * will call the
     * {@link com.group.foctg.holidayMaker.services.AccommodationService#updateAccommodation(com.group.foctg.holidayMaker.model.Accommodation)}
     * method from the autowired Service.
     *
     * @param accommodation {@link com.group.foctg.holidayMaker.model.Accommodation value to pass to the Service class
     * @return a boolean value from the Service
     */
    @PutMapping("/accommodation")
    public boolean updateAccommodation(@RequestBody Accommodation accommodation) {
        return accommodationService.updateAccommodation(accommodation);
    }

    /**
     * DELETE endpoint method that listens on <code>"/accommodation"</code> URL
     * and will call the
     * {@link com.group.foctg.holidayMaker.services.AccommodationService#removeAccommodationByID(java.lang.Long)}
     * method from the autowired Service.
     *
     * @param id Long value to pass to the Service class
     * @return a boolean value from the Service
     */
    @DeleteMapping("/api/accommodation")
    public boolean removeAccommodation(@RequestParam Long id) {
        return accommodationService.removeAccommodationByID(id);
    }
	
	/**
     * GET endpoint method that listens on <code>"/accommodation/customer"</code> URL and will
     * call the
     * {@link com.group.foctg.holidayMaker.services.BookingService#findAccommodationsByUser(java.lang.Long)}
     * method from the autowired Service.
     *
     * @param id Long value to pass to the Service class
     * @return a List of accommodations
     */
	@GetMapping("/accommodation/customer")
	public List<Accommodation> findAccommodationsByCustomerId(@RequestParam Long id) {
		return accommodationService.findAccommodationsByUser(id);
	}
	
	/**
     * GET endpoint method that listens on <code>"/accommodation/tobeach"</code> URL and will
     * call the
     * {@link com.group.foctg.holidayMaker.services.BookingService#findAccommodationsWithinDistanceToBeach(java.lang.Short)}
     * method from the autowired Service.
     *
     * @param distance Short value to pass to the Service class
     * @return a List of accommodations
     */
	@GetMapping("/accommodation/tobeach")
	public List<Accommodation> findAccommodationsWithinDistanceToBeach(@RequestParam Short distance) {
		return accommodationService.findAccommodationsWithinDistanceToBeach(distance);
	}
	
	/**
     * GET endpoint method that listens on <code>"/accommodation/tocenter"</code> URL and will
     * call the
     * {@link com.group.foctg.holidayMaker.services.BookingService#findAccommodationsWithinDistanceToCenter(java.lang.Short)}
     * method from the autowired Service.
     *
     * @param distance Short value to pass to the Service class
     * @return a List of accommodations
     */
	@GetMapping("/accommodation/tocenter")
	public List<Accommodation> findAccommodationsWithinDistanceToCenter(@RequestParam Short distance) {
		return accommodationService.findAccommodationsWithinDistanceToCenter(distance);
	}
	
	/**
     * GET endpoint method that listens on <code>"/accommodation/rating"</code> URL and will
     * call the
     * {@link com.group.foctg.holidayMaker.services.BookingService#findAccommodationsByRatings(java.lang.Float)}
     * method from the autowired Service.
     *
     * @param distance Float value to pass to the Service class
     * @return a List of accommodations
     */
	@GetMapping("/accommodation/rating")
	public List<Accommodation> findAccommodationsByRating(@RequestParam Float rating) {
		return accommodationService.findAccommodationsByRating(rating);
	}
}
