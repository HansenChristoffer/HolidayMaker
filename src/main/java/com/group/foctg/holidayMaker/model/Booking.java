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

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

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
public class Booking implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column
    private Long ID;

    @ManyToOne
    private Customer customer;

    @OneToMany
    private List<Room> rooms;

    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFrom;

    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
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
    private Short extraBeds;

    public Long getID() {
        return ID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer user) {
        this.customer = user;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Short getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(Short numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public Short getNumberOfKids() {
        return numberOfKids;
    }

    public void setNumberOfKids(Short numberOfKids) {
        this.numberOfKids = numberOfKids;
    }

    public Boolean getAllInclusive() {
        return allInclusive;
    }

    public void setAllInclusive(Boolean allInclusive) {
        this.allInclusive = allInclusive;
    }

    public Boolean getFullBoard() {
        return fullBoard;
    }

    public void setFullBoard(Boolean fullBoard) {
        this.fullBoard = fullBoard;
    }

    public Boolean getHalfBoard() {
        return halfBoard;
    }

    public void setHalfBoard(Boolean halfBoard) {
        this.halfBoard = halfBoard;
    }

    public Short getExtraBeds() {
        return extraBeds;
    }

    public void setExtraBeds(Short extraBeds) {
        this.extraBeds = extraBeds;
    }

}
