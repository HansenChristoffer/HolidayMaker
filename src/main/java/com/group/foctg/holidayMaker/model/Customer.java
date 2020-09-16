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
package com.group.foctg.holidayMaker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * The {@link com.group.foctg.holidayMaker.model.Customer} entity class. Holds
 * the various fields that are required for the functionality of the program.
 * These fields are also turned into columns in the SQLite3 database. There is
 * also two OneToMany relationships with other entity classes.
 *
 * @author Olle Johansson
 * @author Christoffer Hansen &lt;chris.hansen.ch@outlook.com&gt;
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer implements Serializable {

    public Customer() {
    }
    
    /**
     * Constructor to initialize a {@link com.group.foctg.holidayMaker.model.Customer} object.
     * 
     * @param email String value to be added to field <code>email</code>
     * @param password String value to be added to field <code>password</code>
     * @param accommodations List that will become the field <code>accommodations</code>
     * @param bookings List that will become the field <code>bookings</code>
     */
    public Customer(String email, String password, List<Accommodation> accommodations, List<Booking> bookings) {
        this.email = email;
        this.password = password;
        this.accommodations = accommodations;
        this.bookings = bookings;
    }

    @Id
    @GeneratedValue
    @Column(name = "customer_id")
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Accommodation> accommodations;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Booking> bookings;

    /**
     * Method that returns the <code>id</code> of the
     * {@link com.group.foctg.holidayMaker.model.Customer} object
     *
     * @return Long value {@link com.group.foctg.holidayMaker.model.Customer}
     * objects field <code>id</code>
     */
    public Long getId() {
        return id;
    }

    /**
     * Method that returns the field <code>email</code> of the
     * {@link com.group.foctg.holidayMaker.model.Customer} object
     *
     * @return String of {@link com.group.foctg.holidayMaker.model.Customer}
     * objects field <code>email</code>
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method that will set the value of the field <code>email</code> by the
     * value sent as parameter.
     *
     * @param email String value to be added to field <code>email</code>
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Method that returns the field <code>accommodation</code> of the
     * {@link com.group.foctg.holidayMaker.model.Customer} object.
     *
     * @return
     * List&lt;{@link com.group.foctg.holidayMaker.model.Accommodation}&gt; of
     * the {@link com.group.foctg.holidayMaker.model.Customer} objects field
     * <code>accommodations</code>
     */
    public List<Accommodation> getAccommodations() {
        return accommodations;
    }

    /**
     * Method that will set the value of the field <code>accommodation</code> by
     * the value sent as parameter.
     *
     * @param accommodations List that will become the new
     * <code>accommodations</code>
     */
    public void setAccommodations(List<Accommodation> accommodations) {
        this.accommodations = accommodations;
    }

    /**
     * Method that returns the field <code>bookings</code> of the
     * {@link com.group.foctg.holidayMaker.model.Customer} object.
     *
     * @return List&lt;{@link com.group.foctg.holidayMaker.model.Booking}&gt; of
     * the {@link com.group.foctg.holidayMaker.model.Customer} objects field
     * <code>bookings</code>
     */
    public List<Booking> getBookings() {
        return bookings;
    }

    /**
     * Method that will set the value of the field <code>bookings</code> by the
     * value sent as parameter.
     *
     * @param bookings List that will become the new <code>bookings</code>
     */
    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    /**
     * Method that returns the field <code>password</code> of the
     * {@link com.group.foctg.holidayMaker.model.Customer} object.
     *
     * @return String of the {@link com.group.foctg.holidayMaker.model.Customer}
     * objects field <code>password</code>
     */
    public String getPassword() {
        return password;
    }

    /**
     * Method that will set the value of the field <code>password</code> by the
     * value sent as parameter.
     *
     * @param password String that will become the <code>password</code>
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
