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
import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Location;
import com.group.foctg.holidayMaker.repositories.LocationRepository;
import java.util.Optional;

/**
 * Service class for the {@link com.group.foctg.holidayMaker.model.Location}
 * column and entity. Autowires the repository.
 *
 * @author Olle Johansson
 *
 * @see com.group.foctg.holidayMaker.repositories.LocationRepository
 */
@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    /**
     * Saves the {@link com.group.foctg.holidayMaker.model.Location} object from
     * parameter in the database.
     *
     * @param location {@link com.group.foctg.holidayMaker.model.Location}
     * object that shall be saved
     * @return A boolean value representing whether the saving was successful or
     * not
     */
    public boolean saveLocation(Location location) {
        return locationRepository.saveAndFlush(location).equals(location);
    }

    /**
     * Removes the {@link com.group.foctg.holidayMaker.model.Location} object
     * with the same <code>id</code> as the parameter from the database.
     *
     * @param id Long value used for finding and removing
     * {@link com.group.foctg.holidayMaker.model.Location} with that
     * <code>id</code>
     * @return A boolean value representing whether the removing was successful
     * or not
     */
    public boolean removeLocationById(Long id) {
        if (locationRepository.existsById(id)) {
            locationRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    /**
     * Goes through the database, checks and returns a
     * {@link com.group.foctg.holidayMaker.model.Location} object if a location
     * with given <code>id</code> exists.
     *
     * @param id Long value to use for finding the
     * {@link com.group.foctg.holidayMaker.model.Location}
     * @return Optional list of the type
     * {@link com.group.foctg.holidayMaker.model.Location} with the given
     * <code>id</code>, if it exists
     */
    public Optional<Location> findById(Long id) {
        return locationRepository.findById(id);
    }

    /**
     * Goes through the database, checks and returns all
     * {@link com.group.foctg.holidayMaker.model.Accommodation} objects in the
     * List&lt;{@link com.group.foctg.holidayMaker.model.Accommodation}&gt; if a
     * location with given <code>id</code> exists.
     *
     * @param id Long value to use for finding the
     * {@link com.group.foctg.holidayMaker.model.Location}
     * @return
     * List&lt;{@link com.group.foctg.holidayMaker.model.Accommodation}&gt; from
     * the {@link com.group.foctg.holidayMaker.model.Location} with the given
     * <code>id</code>, if it exists
     */
    public List<Accommodation> findAccommodationsByLocation(Long id) {
        return locationRepository.findAccommodationsByLocationID(id);
    }

}
