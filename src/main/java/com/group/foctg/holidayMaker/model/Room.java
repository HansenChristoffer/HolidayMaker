package com.group.foctg.holidayMaker.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column
    private Long ID;

    @Column
    private Short numberOfBeds;

    @ManyToOne
    private Accommodation accommodation;

    //@Column
    //private Boolean isVacant;
    @Column
    private Float price;

    //@Column
    //private List<List<Date>> datesAvailable;
    public Long getID() {
        return ID;
    }

    public Short getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(Short numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    //public List<List<Date>> getDatesAvailable() {
    //    return datesAvailable;
    //}
    //public void setDatesAvailable(List<List<Date>> datesAvailable) {
    //    this.datesAvailable = datesAvailable;
    //}
}
