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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Length;

/**
 * The {@link com.group.foctg.holidayMaker.model.Booking} entity class. Holds
 * the various fields that are required for the functionality of the program.
 * These fields are also turned into columns in the SQLite3 database. There is
 * also one OneToMany and one ManyToOne relationships with other entity classes.
 *
 * Uses the SEQUENCE type for auto gen id values because of the restrictions
 * that SQLite3 holds.
 *
 * @author Olle Johansson
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Booking implements Serializable {

    public Booking() {
    }

    public Booking(Customer customer, List<Room> rooms, String dateFrom,
            String dateTo, Short numberOfAdults, Short numberOfKids,
            Boolean allInclusive, Boolean fullBoard, Boolean halfBoard,
            Short extraBeds) {
        this.customer = customer;
        this.rooms = rooms;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.numberOfAdults = numberOfAdults;
        this.numberOfKids = numberOfKids;
        this.allInclusive = allInclusive;
        this.fullBoard = fullBoard;
        this.halfBoard = halfBoard;
        this.extraBeds = extraBeds;
    }

    @Id
    @GeneratedValue
    @Column(name = "booking_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference(value = "customers_bookings")
    private Customer customer;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Room> rooms;

    @Length(min = 10, max = 10)
    @Column
    private String dateFrom;

    @Length(min = 10, max = 10)
    @Column
    private String dateTo;

    @Column
    private Short numberOfAdults;

    @Column
    private Short numberOfKids;

    @Column
    private Boolean allInclusive;

    @Column
    private Boolean fullBoard;

    @Column
    private Boolean halfBoard;

    @Column
    private Short extraBeds;

    /**
     * Method that returns the <code>id</code> of the
     * {@link com.group.foctg.holidayMaker.model.Booking} object
     *
     * @return Long value {@link com.group.foctg.holidayMaker.model.Booking}
     * objects field <code>id</code>
     */
    public Long getId() {
        return id;
    }

    /**
     * Method that returns the field <code>customer</code> of the
     * {@link com.group.foctg.holidayMaker.model.Booking} object
     *
     * @return {@link com.group.foctg.holidayMaker.model.Customer} object of
     * {@link com.group.foctg.holidayMaker.model.Booking} objects field
     * <code>customer</code>
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Method that will set the value of the field <code>customer</code> by the
     * value sent as parameter.
     *
     * @param customer {@link com.group.foctg.holidayMaker.model.Customer} value
     * to be added to field <code>customer</code>
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Method that returns the field <code>rooms</code> of the
     * {@link com.group.foctg.holidayMaker.model.Booking} object.
     *
     * @return List&lt;{@link com.group.foctg.holidayMaker.model.Room}&gt; of
     * {@link com.group.foctg.holidayMaker.model.Booking} objects field
     * <code>rooms</code>
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * Method that will set the value of the field <code>rooms</code> by the
     * value sent as parameter.
     *
     * @param rooms List that will become the new <code>rooms</code>
     */
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    /**
     * Method that returns the field <code>dateFrom</code> of the
     * {@link com.group.foctg.holidayMaker.model.Booking} object.
     *
     * @return Date of {@link com.group.foctg.holidayMaker.model.Booking}
     * objects field <code>dateFrom</code>
     */
    public String getDateFrom() {
        return dateFrom;
    }

    /**
     * Method that will set the value of the field <code>dateFrom</code> by the
     * value sent as parameter.
     *
     * @param dateFrom <code>Date</code> value to be added to field
     * <code>dateFrom</code>
     */
    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    /**
     * Method that returns the field <code>dateTo</code> of the
     * {@link com.group.foctg.holidayMaker.model.Booking} object.
     *
     * @return Date of {@link com.group.foctg.holidayMaker.model.Booking}
     * objects field <code>dateTo</code>
     */
    public String getDateTo() {
        return dateTo;
    }

    /**
     * Method that will set the value of the field <code>dateTo</code> by the
     * value sent as parameter.
     *
     * @param dateTo <code>Date</code> value to be added to field
     * <code>dateTo</code>
     */
    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    /**
     * Method that returns the field <code>numberOfAdults</code> of the
     * {@link com.group.foctg.holidayMaker.model.Booking} object
     *
     * @return Short of {@link com.group.foctg.holidayMaker.model.Booking}
     * objects field <code>numberOfAdults</code>
     */
    public Short getNumberOfAdults() {
        return numberOfAdults;
    }

    /**
     * Method that will set the value of the field <code>numberOfAdults</code>
     * by the value sent as parameter.
     *
     * @param numberOfAdults <code>Short</code> value to be added to field
     * <code>numberOfAdults</code>
     */
    public void setNumberOfAdults(Short numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    /**
     * Method that returns the field <code>numberOfKids</code> of the
     * {@link com.group.foctg.holidayMaker.model.Booking} object.
     *
     * @return Short of {@link com.group.foctg.holidayMaker.model.Booking}
     * objects field <code>numberOfKids</code>
     */
    public Short getNumberOfKids() {
        return numberOfKids;
    }

    /**
     * Method that will set the value of the field <code>numberOfKids</code> by
     * the value sent as parameter.
     *
     * @param numberOfKids <code>Short</code> value to be added to field
     * <code>numberOfKids</code>
     */
    public void setNumberOfKids(Short numberOfKids) {
        this.numberOfKids = numberOfKids;
    }

    /**
     * Method that returns the field <code>allInclusive</code> of the
     * {@link com.group.foctg.holidayMaker.model.Booking} object.
     *
     * @return Boolean of {@link com.group.foctg.holidayMaker.model.Booking}
     * objects field <code>allInclusive</code>
     */
    public Boolean getAllInclusive() {
        return allInclusive;
    }

    /**
     * Method that will set the value of the field <code>allInclusive</code> by
     * the value sent as parameter.
     *
     * @param allInclusive <code>Boolean</code> value to be added to field
     * <code>allInclusive</code>
     */
    public void setAllInclusive(Boolean allInclusive) {
        this.allInclusive = allInclusive;
    }

    /**
     * Method that returns the field <code>fullBoard</code> of the
     * {@link com.group.foctg.holidayMaker.model.Booking} object.
     *
     * @return Boolean of {@link com.group.foctg.holidayMaker.model.Booking}
     * objects field <code>fullBoard</code>
     */
    public Boolean getFullBoard() {
        return fullBoard;
    }

    /**
     * Method that will set the value of the field <code>fullBoard</code> by the
     * value sent as parameter.
     *
     * @param fullBoard <code>Boolean</code> value to be added to field
     * <code>fullBoard</code>
     */
    public void setFullBoard(Boolean fullBoard) {
        this.fullBoard = fullBoard;
    }

    /**
     * Method that returns the field <code>halfBoard</code> of the
     * {@link com.group.foctg.holidayMaker.model.Booking} object.
     *
     * @return Boolean of {@link com.group.foctg.holidayMaker.model.Booking}
     * objects field <code>halfBoard</code>
     */
    public Boolean getHalfBoard() {
        return halfBoard;
    }

    /**
     * Method that will set the value of the field <code>halfBoard</code> by the
     * value sent as parameter.
     *
     * @param halfBoard <code>Boolean</code> value to be added to field
     * <code>halfBoard</code>
     */
    public void setHalfBoard(Boolean halfBoard) {
        this.halfBoard = halfBoard;
    }

    /**
     * Method that returns the field <code>extraBeds</code> of the
     * {@link com.group.foctg.holidayMaker.model.Booking} object.
     *
     * @return Short of {@link com.group.foctg.holidayMaker.model.Booking}
     * objects field <code>halfBoard</code>
     */
    public Short getExtraBeds() {
        return extraBeds;
    }

    /**
     * Method that will set the value of the field <code>extraBeds</code> by the
     * value sent as parameter.
     *
     * @param extraBeds <code>Boolean</code> value to be added to field
     * <code>extraBeds</code>
     */
    public void setExtraBeds(Short extraBeds) {
        this.extraBeds = extraBeds;
    }
}
