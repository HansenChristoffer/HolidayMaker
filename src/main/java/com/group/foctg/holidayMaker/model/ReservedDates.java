package com.group.foctg.holidayMaker.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
 *
 * @author Chris
 */
@Entity
public class ReservedDates implements Serializable {
    
    public ReservedDates(){
    }

    public ReservedDates(Date dateFrom, Date dateTo, Room room, Booking booking) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.room = room;
        this.booking = booking;
    }
    
    @Column
    @Id
    @GeneratedValue
    private Long id;
    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFrom;
    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateTo;
    
    @ManyToOne
    @JsonBackReference(value = "rooms_reserveddates")
    private Room room;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JsonBackReference(value = "booking_reserveddates")
    private Booking booking;
    
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
