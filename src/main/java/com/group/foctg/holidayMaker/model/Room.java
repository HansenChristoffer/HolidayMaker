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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * The {@link com.group.foctg.holidayMaker.model.Room} entity class. Holds the
 * various fields that are required for the functionality of the program. These
 * fields are also turned into columns in the SQLite3 database. There is also
 * one ManyToMany and one ManyToOne relationships with other entity classes.
 *
 * @author Olle Johansson
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Room implements Serializable {

    public Room() {
    }

    /**
     * Constructor to initialize a
     * {@link com.group.foctg.holidayMaker.model.Room} object.
     *
     * @param numberOfBeds Short value to be added to field
     * <code>numberOfBeds</code>
     * @param accommodation
     * {@link com.group.foctg.holidayMaker.model.Accommodation} object to be
     * added to field <code>accommodation</code>
     * @param price Float value to be added to field <code>price</code>
     */
    public Room(Short numberOfBeds, Accommodation accommodation, Float price) {
        this.numberOfBeds = numberOfBeds;
        this.bookings = new ArrayList<>();
        this.accommodation = accommodation;
        this.price = price + (numberOfBeds * 20);
//        this.reservedDates = new ArrayList<>();
    }

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    @NotNull
    private Short numberOfBeds;

    @ManyToMany(mappedBy = "rooms", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JsonBackReference(value = "bookings_rooms")
    private List<Booking> bookings;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference(value = "accommodation_rooms")
    @NotNull
    private Accommodation accommodation;

    @Column
    @NotNull
    private Float price;

//    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
//    //@JsonBackReference(value = "rooms_reserveddates")
//    private List<ReservedDates> reservedDates;

    /**
     * Method that returns the <code>id</code> of the
     * {@link com.group.foctg.holidayMaker.model.Room} object
     *
     * @return Long value {@link com.group.foctg.holidayMaker.model.Room}
     * objects field <code>id</code>
     */
    public Long getId() {
        return id;
    }

    /**
     * Method that will set the value of the field <code>id</code> by the value
     * sent as parameter.
     *
     * @param id Long value to be added to field <code>id</code>
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Method that returns the field <code>numberOfBeds</code> of the
     * {@link com.group.foctg.holidayMaker.model.Room} object
     *
     * @return Short of {@link com.group.foctg.holidayMaker.model.Room} objects
     * field <code>numberOfBeds</code>
     */
    public Short getNumberOfBeds() {
        return numberOfBeds;
    }

    /**
     * Method that will set the value of the field <code>numberOfBeds</code> by
     * the value sent as parameter.
     *
     * @param numberOfBeds Short value to be added to field
     * <code>numberOfBeds</code>
     */
    public void setNumberOfBeds(Short numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    /**
     * Method that returns the field <code>accommodation</code> of the
     * {@link com.group.foctg.holidayMaker.model.Room} object
     *
     * @return {@link com.group.foctg.holidayMaker.model.Accommodation} object
     * of {@link com.group.foctg.holidayMaker.model.Room} objects field
     * <code>accommodation</code>
     */
    public Accommodation getAccommodation() {
        return accommodation;
    }

    /**
     * Method that will set the value of the field <code>accommodation</code> by
     * the value sent as parameter.
     *
     * @param accommodation
     * {@link com.group.foctg.holidayMaker.model.Accommodation} value to be
     * added to field <code>accommodation</code>
     */
    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    /**
     * Method that returns the field <code>price</code> of the
     * {@link com.group.foctg.holidayMaker.model.Room} object
     *
     * @return Float of {@link com.group.foctg.holidayMaker.model.Room} objects
     * field <code>price</code>
     */
    public Float getPrice() {
        return price;
    }

    /**
     * Method that will set the value of the field <code>price</code> by the
     * value sent as parameter.
     *
     * @param price Float value to be added to field <code>price</code>
     */
    public void setPrice(Float price) {
        this.price = price + (numberOfBeds * 20);
    }

    /**
     * Method that returns the field <code>bookings</code> of the
     * {@link com.group.foctg.holidayMaker.model.Room} object
     *
     * @return List&lt;{@link com.group.foctg.holidayMaker.model.Booking}&gt; of
     * the {@link com.group.foctg.holidayMaker.model.Room} objects field
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

//    public List<ReservedDates> getReservedDates() {
//        return reservedDates;
//    }
//
//    public void setReservedDates(List<ReservedDates> reservedDates) {
//        this.reservedDates = reservedDates;
//    }

}
