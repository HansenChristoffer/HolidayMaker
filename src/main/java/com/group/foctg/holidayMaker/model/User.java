package com.group.foctg.holidayMaker.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	@Column
	private Long ID;
	
	@Column
	private String email;

	@Column
	private List<Accommodation> accommodations;

	@Column
	@ManyToOne
	private List<Booking> bookings;
	

	public Long getID() {
		return ID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Accommodation> getAccommodations() {
		return accommodations;
	}

	public void setAccommodations(List<Accommodation> accommodations) {
		this.accommodations = accommodations;
	}
	
	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	

}
