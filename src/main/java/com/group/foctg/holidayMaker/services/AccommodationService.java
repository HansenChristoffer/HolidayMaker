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
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Customer;
import com.group.foctg.holidayMaker.model.Filter;
import com.group.foctg.holidayMaker.repositories.AccommodationRepository;

/**
 * Service class for the {@link com.group.foctg.holidayMaker.model.Accommodation}
 * column and entity. Autowires the repository.
 *
 * @author Olle Johansson
 *
 * @see com.group.foctg.holidayMaker.repositories.AccoommodationRepository
 */

@Service
@Transactional
public class AccommodationService {

	@Autowired
	private AccommodationRepository accommodationRepository;

	/**
     * Saves the {@link com.group.foctg.holidayMaker.model.Accommodation} object from
     * parameter in the database.
     *
     * @param accommodation {@link com.group.foctg.holidayMaker.model.Accommodation} object
     * that shall be saved
     * @return A boolean value representing whether the saving was successful or
     * not
     */
	
	public boolean saveAccommodation(Accommodation accommodation) {
		return accommodationRepository.saveAndFlush(accommodation).equals(accommodation);
	}
	
	/**
     * Removes the {@link com.group.foctg.holidayMaker.model.Accommodation} object
     * with the same <code>id</code> as the parameter from the database.
     *
     * @param id Long value used for finding and removing
     * {@link com.group.foctg.holidayMaker.model.Accommodation} with that
     * <code>id</code>
     * @return A boolean value representing whether the removing was successful
     * or not
     */

	public boolean removeAccommodationByID(Long ID) {
		if (accommodationRepository.existsById(ID)) {
			Accommodation found = accommodationRepository.getOne(ID);
			accommodationRepository.delete(found);
			return true;
		} else return false;
	}

	/**
     * If there is a Accommodation object already that has the same id as the
     * {@link com.group.foctg.holidayMaker.model.Accommodation} passed as parameter
     * then it'll update the existing object. Otherwise it will save the object.
     *
     * @param accommodation {@link com.group.foctg.holidayMaker.model.Accommodation} object
     * passed for updating or saving
     * @return A boolean value representing whether the updating or saving was
     * successful or not
     */
	
	public boolean updateAccommodation(Accommodation accommodation) {
		return accommodationRepository.saveAndFlush(accommodation).equals(accommodation);
	}
	
	/**
     * Goes through the database, checks and returns all
     * {@link com.group.foctg.holidayMaker.model.Accommodation} objects in the
     * List&lt;{@link com.group.foctg.holidayMaker.model.Accommodation}&gt;
     */

	public List<Accommodation> findAll() {
		return accommodationRepository.findAll();
	}

	/**
     * Goes through the database, checks and returns one
     * {@link com.group.foctg.holidayMaker.model.Accommodation} object in the
     * List&lt;{@link com.group.foctg.holidayMaker.model.Accommodation}&gt; that
     * matches the <code>ID</code>
     */
	
	public Accommodation getOne(Long ID) {
		return accommodationRepository.getOne(ID);
	}

	/**
     * Goes through the database, checks and returns all
     * {@link com.group.foctg.holidayMaker.model.Accommodation} objects in the
     * List&lt;{@link com.group.foctg.holidayMaker.model.Accommodation}&gt; that
     * matches the <code>ID</code> of a {@link com.group.foctg.holidayMaker.model.Customer}
     */
	
	public List<Accommodation> findAccommodationsByUser(Long id) {
            return accommodationRepository.findAccommodationsByCustomerID(id);
	}

	/**
     * Goes through the database, checks and returns all
     * {@link com.group.foctg.holidayMaker.model.Accommodation} objects in the
     * List&lt;{@link com.group.foctg.holidayMaker.model.Accommodation}&gt; that
     * matches the {@link com.group.foctg.holidayMaker.model.Filter} fields
     */
	
	public List<Accommodation> getFilteredAccommodations(Filter filter) {

		/**
	     * These anonymous functions returns true/false depending on the statement.
	     * If the statement is true, the filter() function will pass the object of
	     * {@link com.group.foctg.holidayMaker.model.Accommodation} and be appended to
	     * the List<Accommodation>
	     */
		
		List<Accommodation> filtered = findAll().stream()
			    .filter(a -> a.getDistanceToBeach() > filter.getMinDistBeach() && a.getDistanceToBeach() < filter.getMaxDistBeach())
			    .filter(a -> a.getDistanceToCenter() > filter.getMinDistCenter() && a.getDistanceToCenter() < filter.getMaxDistCenter())
			    .filter(a -> a.getLocation().getName().equals(filter.getLocation()))
			    .filter(a -> a.getPool() == true || filter.hasPool() == false)
			    .filter(a -> a.getChildEvents() == true || filter.hasChildrenClub() == false)
			    .filter(a -> a.getRestaurant() == true || filter.hasRestaurant() == false)
			    .filter(a -> a.getNightEntertainment() == true || filter.hasNightEntertainment() == false)
			    .filter(a -> a.getRooms().size() >= filter.getRooms())
			    .collect(Collectors.toList());
		
		
		return filtered;
	}

}
