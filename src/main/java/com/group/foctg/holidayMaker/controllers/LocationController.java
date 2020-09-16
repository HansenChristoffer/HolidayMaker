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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Location;
import com.group.foctg.holidayMaker.services.LocationService;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * RestController for the {@link com.group.foctg.holidayMaker.model.Location}
 * entity and column. This class holds all the endpoints for
 * {@link com.group.foctg.holidayMaker.model.Location}.
 *
 * Autowiring {@link com.group.foctg.holidayMaker.services.LocationService}.
 *
 * The default URL value is set to, "/api".
 *
 * @author Olle Johansson
 * @see com.group.foctg.holidayMaker.services.LocationService
 */
@RestController
@RequestMapping(value = "/api")
public class LocationController {

    @Autowired
    private LocationService locationService;

    /**
     * POST endpoint method that listens on <code>"/location"</code> URL and
     * will call the
     * {@link com.group.foctg.holidayMaker.services.LocationService#findAll()) }
     * method from the Service.
     *
     * @return a List object from the autowired Service
     */
    @GetMapping("/locations")
    public List<Location> allLocations() {
        return locationService.findAll();
    }

    /**
     * POST endpoint method that listens on <code>"/location"</code> URL and
     * will call the
     * {@link com.group.foctg.holidayMaker.services.LocationService#saveLocation(com.group.foctg.holidayMaker.model.Location) }
     * method from the Service.
     *
     * @param location {@link com.group.foctg.holidayMaker.model.Location}
     * object to pass to the Service class
     * @return a boolean value from the autowired Service
     */
    @PostMapping("/location")
    public boolean saveLocation(@RequestBody Location location) {
        return locationService.saveLocation(location);
    }

    /**
     * GET endpoint method that listens on <code>"/location"</code> URL and will
     * call the 
     * {@link com.group.foctg.holidayMaker.services.LocationService#getOne(java.lang.Long) }
     * method from the Service.
     *
     * @param id Long value to pass to the Service class
     * @return a {@link com.group.foctg.holidayMaker.model.Location} object from
     * the autowired Service
     */
    @GetMapping("/location")
    public Location getOne(@RequestParam Long id) {
        return locationService.getOne(id);
    }

    /**
     * DELETE endpoint method that listens on <code>"/location"</code> URL and
     * will call the
     * {@link com.group.foctg.holidayMaker.services.LocationService#removeLocationById(java.lang.Long) }
     * method from the autowired Service.
     *
     * @param id Long value to pass to the Service class
     * @return a boolean value from the autowired Service
     */
    @DeleteMapping("/location")
    public boolean removeLocation(@RequestParam Long id) {
        return locationService.removeLocationById(id);
    }

    /**
     * GET endpoint method that listens on
     * <code>"/location/accommodations"</code> URL and will call the
     * {@link com.group.foctg.holidayMaker.services.LocationService#findAccommodationsByLocation(java.lang.Long) }
     * method from the autowired Service.
     *
     * @param id Long value to pass to the Service class
     * @return a List object from the Service
     */
    @GetMapping("/location/accommodations")
    public List<Accommodation> getAccommodationsByLocationId(@RequestParam Long id) {
        return locationService.findAccommodationsByLocation(id);
    }
}
