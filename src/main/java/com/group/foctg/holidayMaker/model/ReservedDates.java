package com.group.foctg.holidayMaker.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Chris
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//@JsonIdentityReference(alwaysAsId = true)
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
    @JoinColumn(name = "room_id")
    //@JsonBackReference(value = "rooms_reserveddates")
    private Room room;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    //@JsonBackReference(value = "booking_reserveddates")
    private Booking booking;

    /**
     * Method that makes a check if the two ranges overlap or not
     *
     * @param dateFrom
     * @param dateTo
     * @param dateRangeFrom2
     * @param dateRangeTo2
     * @return a boolean value on whether ranges overlap
     */
    public boolean isOverlapping(Date dateRangeFrom2, Date dateRangeTo2) {
        return (dateFrom.getTime() <= dateRangeTo2.getTime()
                && dateRangeFrom2.getTime() <= dateTo.getTime());
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
