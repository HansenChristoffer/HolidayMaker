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
import com.group.foctg.holidayMaker.model.Booking;
import com.group.foctg.holidayMaker.model.Customer;
import com.group.foctg.holidayMaker.repositories.CustomerRepository;
import java.util.Optional;

/**
 * Service class for the {@link com.group.foctg.holidayMaker.model.Customer}
 * column and entity. Autowires the repository.
 *
 * @author Frida Ek
 * @author Christoffer Hansen &lt;chris.hansen.ch@outlook.com&gt;
 *
 * @see com.group.foctg.holidayMaker.repositories.CustomerRepository
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    /**
     * Saves the {@link com.group.foctg.holidayMaker.model.Customer} object from
     * parameter in the database.
     *
     * @param customer {@link com.group.foctg.holidayMaker.model.Customer}
     * object that shall be saved
     * @return A boolean value representing whether the saving was successful or
     * not
     */
    public boolean saveCustomer(Customer customer) {
        return customerRepository.saveAndFlush(customer).equals(customer);
    }

    /**
     * Removes the {@link com.group.foctg.holidayMaker.model.Customer} object
     * with the same <code>id</code> as the parameter from the database.
     *
     * @param id Long value used for finding and removing
     * {@link com.group.foctg.holidayMaker.model.Customer} with that
     * <code>id</code>
     * @return A boolean value representing whether the removing was successful
     * or not
     */
    public boolean removeCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Goes through the database, checks and returns a
     * {@link com.group.foctg.holidayMaker.model.Customer} object if a customer
     * with given <code>id</code> exists.
     *
     * @param id Long value to use for finding the
     * {@link com.group.foctg.holidayMaker.model.Customer}
     * @return Optional list of type
     * {@link com.group.foctg.holidayMaker.model.Customer} object with the given
     * <code>id</code>, if it exists
     */
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    /**
     * Goes through the database, checks and returns a
     * {@link com.group.foctg.holidayMaker.model.Customer} object if a customer
     * with given <code>email</code> exists.
     *
     * @param email String value to use for finding the
     * {@link com.group.foctg.holidayMaker.model.Customer}
     * @return {@link com.group.foctg.holidayMaker.model.Customer} object with
     * the given <code>email</code>, if it exists
     */
    public Customer findCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }

    /**
     * Goes through the database, checks and returns all
     * {@link com.group.foctg.holidayMaker.model.Booking} objects in the
     * List&lt;{@link com.group.foctg.holidayMaker.model.Booking}&gt; if a
     * customer with given <code>id</code> exists.
     *
     * @param id Long value to use for finding the
     * {@link com.group.foctg.holidayMaker.model.Customer}
     * @return List&lt;{@link com.group.foctg.holidayMaker.model.Booking}&gt;
     * from the {@link com.group.foctg.holidayMaker.model.Customer} with the
     * given <code>id</code>, if it exists
     */
    public List<Booking> findCustomersBookingsByCustomerID(Long id) {
        return customerRepository.findBookingsByID(id);
    }

    /**
     * Goes through the database, checks and returns all
     * {@link com.group.foctg.holidayMaker.model.Accommodation} objects in the
     * List&lt;{@link com.group.foctg.holidayMaker.model.Accommodation}&gt; if a
     * customer with given <code>id</code> exists.
     *
     * @param id Long value to use for finding the
     * {@link com.group.foctg.holidayMaker.model.Customer}
     * @return
     * List&lt;{@link com.group.foctg.holidayMaker.model.Accommodation}&gt; from
     * the {@link com.group.foctg.holidayMaker.model.Customer} with the given
     * <code>id</code>, if it exists
     */
    public List<Accommodation> findCustomersAccommodationsByCustomerID(Long id) {
        return customerRepository.findAccommodationsByID(id);
    }
}
