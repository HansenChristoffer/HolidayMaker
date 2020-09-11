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
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * The {@link com.group.foctg.holidayMaker.model.Customer} entity class. Holds
 * the various fields that are required for the functionality of the program.
 * These fields are also turned into columns in the SQLite3 database. There is
 * also two OneToMany relationships with other entity classes.
 *
 * Uses the SEQUENCE type for auto gen id values because of the restrictions
 * that SQLite3 holds.
 *
 * @author Olle Johansson
 * @author Christoffer Hansen &lt;chris.hansen.ch@outlook.com&gt;
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column
    private Long ID;

    @Column
    private String email;

    @OneToMany
    private List<Accommodation> accommodations;

    @OneToMany
    private List<Booking> bookings;

    /**
     * Method that returns the <code>ID</code> of the
     * {@link com.group.foctg.holidayMaker.model.Customer} object
     *
     * @return Long value {@link com.group.foctg.holidayMaker.model.Customer}
     * objects field <code>ID</code>
     */
    public Long getID() {
        return ID;
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
     * the {@link com.group.foctg.holidayMaker.model.Customer} objects field accommodations
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
     * the {@link com.group.foctg.holidayMaker.model.Customer} objects field bookings
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

}
