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
import com.group.foctg.holidayMaker.model.Booking;
import com.group.foctg.holidayMaker.model.Customer;
import org.springframework.data.jpa.repository.Query;

/**
 * Repository interface for the
 * {@link com.group.foctg.holidayMaker.model.Customer} and this extends
 * JpaRepository. This repository also has 3 custom functions with their own HQL
 * query associated with them.
 *
 * This repository is suppose to be autowired by a Service. See
 * {@link com.group.foctg.holidayMaker.services.CustomerService}.
 *
 * @author Frida Ek
 * @author Christoffer Hansen &lt;christoffer.hansen.hc@gmail.com&gt;
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE c.email = ?1")
    Customer findCustomerByEmail(String email);

    @Query("SELECT c.bookings FROM Customer c WHERE c.id = ?1")
    List<Booking> findBookingsByID(Long ID);

    @Query("SELECT c.accommodations FROM Customer c WHERE c.id = ?1")
    List<Accommodation> findAccommodationsByID(Long ID);
}
