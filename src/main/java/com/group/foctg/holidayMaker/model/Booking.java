package com.group.foctg.holidayMaker.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

@Entity
public class Booking {

	@Id
	@GeneratedValue
	@Column
	private Long ID;
	
	@Column
	private User user;
	
	@Column
	private List<Room> rooms;
	
	@Column
	private Date dateFrom;
	
	@Column
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
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
