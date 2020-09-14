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

import java.util.Date;

/**
 * The {@link com.group.foctg.holidayMaker.model.Filter} entity class.
 *
 * Used to store database values for filtering out database items in
 * the {@link com.group.foctg.holidayMaker.services.AccommodationService} class
 *
 * @author Olle Johansson
 */


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
	private short adults;
	private short kids;

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

	public boolean hasPool() {
		return pool;
	}

	public void setPool(boolean pool) {
		this.pool = pool;
	}

	public boolean hasChildrenClub() {
		return childrenClub;
	}

	public void setChildrenClub(boolean childrenClub) {
		this.childrenClub = childrenClub;
	}

	public boolean hasRestaurant() {
		return restaurant;
	}

	public void setRestaurant(boolean restaurant) {
		this.restaurant = restaurant;
	}

	public boolean hasNightEntertainment() {
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
