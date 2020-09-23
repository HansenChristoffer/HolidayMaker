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
package com.group.foctg.holidayMaker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group.foctg.holidayMaker.model.Accommodation;
import org.springframework.data.jpa.repository.Query;

/**
 * Repository interface for the
 * {@link com.group.foctg.holidayMaker.model.Accommodation} and this extends
 * JpaRepository. This repository also has one custom function with its own HQL
 * query associated with it.
 *
 * This repository is suppose to be autowired by a Service. See
 * {@link com.group.foctg.holidayMaker.services.AccommodationService}.
 *
 * @author Olle Johansson
 * @author Frida Ek
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

    @Query("SELECT a FROM Accommodation a WHERE a.customer.id = ?1")
    List<Accommodation> findAccommodationsByCustomerId(Long id);
    
    @Query("SELECT a FROM Accommodation a WHERE a.location.id = ?1")
    List<Accommodation> findAccommodationsByLocationId(Long id);
	
    @Query("SELECT b FROM Accommodation b WHERE b.distanceToBeach <= ?1")
    List<Accommodation> findAccommodationsByDistanceToBeach(Short distance);
    
    @Query("SELECT c FROM Accommodation c WHERE c.distanceToCenter <= ?1")
    List<Accommodation> findAccommodationsByDistanceToCenter(Short distance);
    
    @Query("SELECT d FROM Accommodation d WHERE d.rating = ?1")
    List<Accommodation> findAccommodationsByRating(Float rating);
}
