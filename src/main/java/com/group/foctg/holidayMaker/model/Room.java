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
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * The {@link com.group.foctg.holidayMaker.model.Room} entity class. Holds the
 * various fields that are required for the functionality of the program. These
 * fields are also turned into columns in the SQLite3 database. There is also
 * one ManyToMany and one ManyToOne relationships with other entity classes.
 *
 * @author Olle Johansson
 */
@Entity
public class Room implements Serializable {

    public Room() {
    }

    public Room(Short numberOfBeds, List<Booking> bookings,Accommodation accommodation, Float price, Short size) {
        this.numberOfBeds = numberOfBeds;
        this.bookings = bookings;
        this.accommodation = accommodation;
        this.size = size;
        this.price = price + (numberOfBeds * 20);
    }

    @Id
    @GeneratedValue
    @Column(name = "room_id")
    private Long id;

    @Column
    private Short numberOfBeds;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Booking> bookings;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Accommodation accommodation;

    @Column
    private Float price;
    
    @Column 
    private Short size;

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
     * @param accommodation {@link com.group.foctg.holidayMaker.model.Accommodation}
     * value to be added to field <code>accommodation</code>
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
     * @param price Float value to be added to field
     * <code>price</code>
     */
    public void setPrice(Float price) {
        this.price = price + (numberOfBeds * 20);
    }
    
    /**
     * Method that returns the field <code>bookings</code> of the
     * {@link com.group.foctg.holidayMaker.model.Room} object
     *
     * @return
     * List&lt;{@link com.group.foctg.holidayMaker.model.Booking}&gt; of
     * the {@link com.group.foctg.holidayMaker.model.Room} objects field
     * bookings
     */
    public List<Booking> getBookings() {
        return bookings;
    }
    
    /**
     * Method that will set the value of the field <code>bookings</code> by the
     * value sent as parameter.
     *
     * @param bookings List that will become the new
     * <code>bookings</code>
     */
    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
    
    /**
     * Method that returns the field <code>size</code> of the
     * {@link com.group.foctg.holidayMaker.model.Room} object
     *
     * @return Short of {@link com.group.foctg.holidayMaker.model.Room} objects
     * field <code>size</code>
     */
    public Short getSize() {
    	return size;
    }
    
    /**
     * Method that will set the value of the field <code>size</code> by the
     * value sent as parameter.
     *
     * @param size Short value to be added to field
     * <code>size</code>
     */
    public void setSize(Short size) {
    	this.size = size;
    }
}
