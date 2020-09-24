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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 * The {@link com.group.foctg.holidayMaker.model.ReservedDates} entity class.
 * Holds the various fields that are required for the functionality of the
 * program. These fields are also turned into columns in the SQLite3 database.
 * There is also one ManyToOne and one OneToOne relation with other entity
 * classes.
 *
 * This entities sole purpose is for holding all the booked dates that a room
 * might have. It is the link between, booking, rooms and dates.
 *
 * @author Christoffer Hansen &lt;chris.hansen.ch@outlook.com&gt;
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ReservedDates implements Serializable {

    public ReservedDates() {
    }

    public ReservedDates(Date dateFrom, Date dateTo, Room room, Booking booking) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.room = room;
        this.booking = booking;
    }

    @Column(name = "reservedDates_id")
    @Id
    @GeneratedValue
    private Long id;

    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateFrom;

    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateTo;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Room room;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Booking booking;

    /**
     * Method that makes a check if the two ranges overlap or not
     *
     * @param dateRangeFrom
     * @param dateRangeTo
     * @return a boolean value on whether ranges overlap
     */
    public boolean isOverlapping(Date dateRangeFrom, Date dateRangeTo) {
        return (dateFrom.getTime() <= dateRangeTo.getTime()
                && dateRangeFrom.getTime() <= dateTo.getTime());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

}
