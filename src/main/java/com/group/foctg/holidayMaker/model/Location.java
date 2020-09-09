package com.group.foctg.holidayMaker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location {

    @Id
    @GeneratedValue
    @Column
    private Long ID;

    @Column
    private String name;

    //Uncomment when accommodation exists
    //@Column
    //@OneToMany
    //private List<Accommodation> accommodations;
    public Long getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public List<Accommodation> getAccommodation() {
		return this.accommodations;
	}

	public void setAccommodation(List<Accommodation> accommodations) {
		this.accommodations = accommodations;
	}*/
}
