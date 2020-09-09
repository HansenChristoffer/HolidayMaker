package com.group.foctg.holidayMaker.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
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
