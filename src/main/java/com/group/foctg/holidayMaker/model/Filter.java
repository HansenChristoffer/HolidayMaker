package com.group.foctg.holidayMaker.model;

import java.util.Date;

import javax.persistence.Entity;

public class Filter {

	private String location;
	private String pack;
	
	private Date dateFrom;
	private Date dateTo;
	
	private boolean pool;
	private boolean childrenClub;
	private boolean restaurant;
	private boolean nightEntertainment;
	
	private short rooms;
	private short beds;
	private short adults;
	private short kids;

	private int minPrice;
	private int maxPrice;

	private int minDistBeach;
	private int maxDistBeach;

	private int minDistCenter;
	private int maxDistCenter;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public short getAdults() {
		return adults;
	}

	public void setAdults(short adults) {
		this.adults = adults;
	}

	public short getKids() {
		return kids;
	}

	public void setKids(short kids) {
		this.kids = kids;
	}

	public String getPack() {
		return pack;
	}

	public void setPack(String pack) {
		this.pack = pack;
	}

	public boolean isPool() {
		return pool;
	}

	public void setPool(boolean pool) {
		this.pool = pool;
	}

	public boolean isChildrenClub() {
		return childrenClub;
	}

	public void setChildrenClub(boolean childrenClub) {
		this.childrenClub = childrenClub;
	}

	public boolean isRestaurant() {
		return restaurant;
	}

	public void setRestaurant(boolean restaurant) {
		this.restaurant = restaurant;
	}

	public boolean isNightEntertainment() {
		return nightEntertainment;
	}

	public void setNightEntertainment(boolean nightEntertainment) {
		this.nightEntertainment = nightEntertainment;
	}

	public short getRooms() {
		return rooms;
	}

	public void setRooms(short rooms) {
		this.rooms = rooms;
	}

	public short getBeds() {
		return beds;
	}

	public void setBeds(short beds) {
		this.beds = beds;
	}

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public int getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}

	public int getMinDistBeach() {
		return minDistBeach;
	}

	public void setMinDistBeach(int minDistBeach) {
		this.minDistBeach = minDistBeach;
	}

	public int getMaxDistBeach() {
		return maxDistBeach;
	}

	public void setMaxDistBeach(int maxDistBeach) {
		this.maxDistBeach = maxDistBeach;
	}

	public int getMinDistCenter() {
		return minDistCenter;
	}

	public void setMinDistCenter(int minDistCenter) {
		this.minDistCenter = minDistCenter;
	}

	public int getMaxDistCenter() {
		return maxDistCenter;
	}

	public void setMaxDistCenter(int maxDistCenter) {
		this.maxDistCenter = maxDistCenter;
	}

}
