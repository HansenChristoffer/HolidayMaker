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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import lombok.extern.slf4j.Slf4j;

/**
 * The {@link com.group.foctg.holidayMaker.model.Booking} entity class. Holds
 * the various fields that are required for the functionality of the program.
 * These fields are also turned into columns in the SQLite3 database. There is
 * also one ManyToOne and one ManyToMany relationships with other entity
 * classes.
 *
 * @author Olle Johansson
 * @author Christoffer Hansen &lt;chris.hansen.ch@outlook.com&gt;
 *
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Booking implements Serializable {
    
    public Booking() {
    }

    /**
     * Constructor to initialize a
     * {@link com.group.foctg.holidayMaker.model.Booking} object.
     *
     * @param customer {@link com.group.foctg.holidayMaker.model.Customer}
     * object to be added to field <code>customer</code>
     * @param rooms List that will become the field <code>rooms</code>
     * @param dateFrom Date value to be added to field <code>dateFrom</code>
     * @param dateTo Date value to be added to field <code>dateTo</code>
     * @param numberOfAdults Short value to be added to field
     * <code>numberOfAdults</code>
     * @param numberOfKids Short value to be added to field
     * <code>numberOfKids</code>
     * @param allInclusive boolean value to be added to field
     * <code>allInclusive</code>
     * @param fullBoard boolean value to be added to field
     * <code>fullBoard</code>
     * @param halfBoard boolean value to be added to field
     * <code>halfBoard</code>
     * @param extraBeds boolean value to be added to field <code>extraBed</code>
     */
    public Booking(Customer customer, List<Room> rooms, Date dateFrom,
            Date dateTo, Short numberOfAdults, Short numberOfKids,
            Boolean allInclusive, Boolean fullBoard, Boolean halfBoard,
            Boolean extraBeds) {
        this.customer = customer;
        this.rooms = rooms;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.numberOfAdults = numberOfAdults;
        this.numberOfKids = numberOfKids;
        this.allInclusive = allInclusive;
        this.fullBoard = fullBoard;
        this.halfBoard = halfBoard;
        this.extraBed = extraBeds;
        this.cost += 0f + (extraBed ? 200f : 0f);

    }

    @Id
    @GeneratedValue
    @Column(name = "booking_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany(mappedBy = "bookings", cascade = CascadeType.MERGE)
    private List<Room> rooms;

    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateFrom;

    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateTo;

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
    private Boolean extraBed;

    @Column(columnDefinition = "float default 1")
    private float cost;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private ReservedDates reservedDates;

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
     * Method that will set the value of the field <code>id</code> by the value
     * sent as parameter.
     *
     * @param id Long value to be added to field <code>id</code>
     */
    public void setId(Long id) {
        this.id = id;
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
    public Date getDateFrom() {
        return dateFrom;
    }

    /**
     * Method that will set the value of the field <code>dateFrom</code> by the
     * value sent as parameter.
     *
     * @param dateFrom <code>Date</code> value to be added to field
     * <code>dateFrom</code>
     */
    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    /**
     * Method that returns the field <code>dateTo</code> of the
     * {@link com.group.foctg.holidayMaker.model.Booking} object.
     *
     * @return Date of {@link com.group.foctg.holidayMaker.model.Booking}
     * objects field <code>dateTo</code>
     */
    public Date getDateTo() {
        return dateTo;
    }

    /**
     * Method that will set the value of the field <code>dateTo</code> by the
     * value sent as parameter.
     *
     * @param dateTo <code>Date</code> value to be added to field
     * <code>dateTo</code>
     */
    public void setDateTo(Date dateTo) {
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
     * Method that returns the field <code>extraBed</code> of the
     * {@link com.group.foctg.holidayMaker.model.Booking} object.
     *
     * @return Short of {@link com.group.foctg.holidayMaker.model.Booking}
     * objects field <code>extraBed</code> objects field <code>halfBoard</code>
     */
    public Boolean getExtraBed() {
        return extraBed;
    }

    /**
     * Method that will set the value of the field <code>extraBed</code> by the
     * value sent as parameter.
     *
     * @param extraBed <code>Boolean</code> value to be added to field
     * <code>extraBed</code>
     */
    public void setExtraBed(Boolean extraBed) {
        this.extraBed = extraBed;
    }

    /**
     * Method that returns the <code>reservedDates</code> of the
     * {@link com.group.foctg.holidayMaker.model.Booking} object
     *
     * @return {@link com.group.foctg.holidayMaker.model.Booking} object field
     */
    public ReservedDates getReservedDates() {
        return reservedDates;
    }

    /**
     * Method that will set the value of the field <code>reservedDates</code> by
     * the value sent as parameter.
     *
     * @param reservedDates
     * {@link com.group.foctg.holidayMaker.model.ReservedDates} value to be
     * added to field <code>reservedDates</code>
     */
    public void setReservedDates(ReservedDates reservedDates) {
        this.reservedDates = reservedDates;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

}
