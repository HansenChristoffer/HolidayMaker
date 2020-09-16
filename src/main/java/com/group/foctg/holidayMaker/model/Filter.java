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
	
	private String dateFrom;
	private String dateTo;
	
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

    /**
     * Method that returns the field <code>location</code> of the
     * {@link com.group.foctg.holidayMaker.model.Filter} object
     *
     * @return String of {@link com.group.foctg.holidayMaker.model.Filter} objects
     * field <code>location</code>
     */
	public String getLocation() {
		return location;
	}
	
    /**
     * Method that will set the value of the field <code>location</code> by
     * the value sent as parameter.
     *
     * @param location String value to be added to field
     * <code>location</code>
     */
	public void setLocation(String location) {
		this.location = location;
	}
	
    /**
     * Method that returns the field <code>dateFrom</code> of the
     * {@link com.group.foctg.holidayMaker.model.Filter} object
     *
     * @return String of {@link com.group.foctg.holidayMaker.model.Filter} objects
     * field <code>dateFrom</code>
     */
	public String getDateFrom() {
		return dateFrom;
	}
	
    /**
     * Method that will set the value of the field <code>dateFrom</code> by
     * the value sent as parameter.
     *
     * @param dateFrom String value to be added to field
     * <code>dateFrom</code>
     */
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	
    /**
     * Method that returns the field <code>dateTo</code> of the
     * {@link com.group.foctg.holidayMaker.model.Filter} object
     *
     * @return String of {@link com.group.foctg.holidayMaker.model.Filter} objects
     * field <code>dateTo</code>
     */
	public String getDateTo() {
		return dateTo;
	}
	
    /**
     * Method that will set the value of the field <code>dateTo</code> by
     * the value sent as parameter.
     *
     * @param dateTo String value to be added to field
     * <code>dateTo</code>
     */
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

    /**
     * Method that returns the field <code>adults</code> of the
     * {@link com.group.foctg.holidayMaker.model.Filter} object
     *
     * @return short of {@link com.group.foctg.holidayMaker.model.Filter} objects
     * field <code>adults</code>
     */
	public short getAdults() {
		return adults;
	}
	
    /**
     * Method that will set the value of the field <code>adults</code> by
     * the value sent as parameter.
     *
     * @param adults short value to be added to field
     * <code>adults</code>
     */
	public void setAdults(short adults) {
		this.adults = adults;
	}

    /**
     * Method that returns the field <code>kids</code> of the
     * {@link com.group.foctg.holidayMaker.model.Filter} object
     *
     * @return short of {@link com.group.foctg.holidayMaker.model.Filter} objects
     * field <code>kids</code>
     */
	public short getKids() {
		return kids;
	}
	
    /**
     * Method that will set the value of the field <code>kids</code> by
     * the value sent as parameter.
     *
     * @param kids short value to be added to field
     * <code>kids</code>
     */
	public void setKids(short kids) {
		this.kids = kids;
	}

    /**
     * Method that returns the field <code>pack</code> of the
     * {@link com.group.foctg.holidayMaker.model.Filter} object
     *
     * @return String of {@link com.group.foctg.holidayMaker.model.Filter} objects
     * field <code>pack</code>
     */
	public String getPack() {
		return pack;
	}
	
    /**
     * Method that will set the value of the field <code>pack</code> by
     * the value sent as parameter.
     *
     * @param pack String value to be added to field
     * <code>pack</code>
     */
	public void setPack(String pack) {
		this.pack = pack;
	}

    /**
     * Method that returns the field <code>pool</code> of the
     * {@link com.group.foctg.holidayMaker.model.Filter} object
     *
     * @return boolean of {@link com.group.foctg.holidayMaker.model.Filter} objects
     * field <code>pool</code>
     */
	public boolean hasPool() {
		return pool;
	}
	
    /**
     * Method that will set the value of the field <code>pool</code> by
     * the value sent as parameter.
     *
     * @param pool boolean value to be added to field
     * <code>pool</code>
     */
	public void setPool(boolean pool) {
		this.pool = pool;
	}

    /**
     * Method that returns the field <code>ChildrenClub</code> of the
     * {@link com.group.foctg.holidayMaker.model.Filter} object
     *
     * @return boolean of {@link com.group.foctg.holidayMaker.model.Filter} objects
     * field <code>childrenClub</code>
     */
	public boolean hasChildrenClub() {
		return childrenClub;
	}
	
    /**
     * Method that will set the value of the field <code>childrenClub</code> by
     * the value sent as parameter.
     *
     * @param childrenClub boolean value to be added to field
     * <code>childrenClub</code>
     */
	public void setChildrenClub(boolean childrenClub) {
		this.childrenClub = childrenClub;
	}

    /**
     * Method that returns the field <code>restaurant</code> of the
     * {@link com.group.foctg.holidayMaker.model.Filter} object
     *
     * @return boolean of {@link com.group.foctg.holidayMaker.model.Filter} objects
     * field <code>restaurant</code>
     */
	public boolean hasRestaurant() {
		return restaurant;
	}
	
    /**
     * Method that will set the value of the field <code>restaurant</code> by
     * the value sent as parameter.
     *
     * @param restaurant boolean value to be added to field
     * <code>restaurant</code>
     */
	public void setRestaurant(boolean restaurant) {
		this.restaurant = restaurant;
	}

    /**
     * Method that returns the field <code>nightEntertainment</code> of the
     * {@link com.group.foctg.holidayMaker.model.Filter} object
     *
     * @return boolean of {@link com.group.foctg.holidayMaker.model.Filter} objects
     * field <code>nightEntertainment</code>
     */
	public boolean hasNightEntertainment() {
		return nightEntertainment;
	}
	
    /**
     * Method that will set the value of the field <code>nightEntertainment</code> by
     * the value sent as parameter.
     *
     * @param nightEntertainment boolean value to be added to field
     * <code>nightEntertainment</code>
     */
	public void setNightEntertainment(boolean nightEntertainment) {
		this.nightEntertainment = nightEntertainment;
	}

    /**
     * Method that returns the field <code>rooms</code> of the
     * {@link com.group.foctg.holidayMaker.model.Filter} object
     *
     * @return short of {@link com.group.foctg.holidayMaker.model.Filter} objects
     * field <code>rooms</code>
     */
	public short getRooms() {
		return rooms;
	}
	
    /**
     * Method that will set the value of the field <code>rooms</code> by
     * the value sent as parameter.
     *
     * @param rooms short value to be added to field
     * <code>rooms</code>
     */
	public void setRooms(short rooms) {
		this.rooms = rooms;
	}

    /**
     * Method that returns the field <code>minDistBeach</code> of the
     * {@link com.group.foctg.holidayMaker.model.Filter} object
     *
     * @return int of {@link com.group.foctg.holidayMaker.model.Filter} objects
     * field <code>minDistBeach</code>
     */
	public int getMinDistBeach() {
		return minDistBeach;
	}
	
    /**
     * Method that will set the value of the field <code>minDistBeach</code> by
     * the value sent as parameter.
     *
     * @param minDistBeach int value to be added to field
     * <code>minDistBeach</code>
     */
	public void setMinDistBeach(int minDistBeach) {
		this.minDistBeach = minDistBeach;
	}

    /**
     * Method that returns the field <code>maxDistBeach</code> of the
     * {@link com.group.foctg.holidayMaker.model.Filter} object
     *
     * @return int of {@link com.group.foctg.holidayMaker.model.Filter} objects
     * field <code>maxDistBeach</code>
     */
	public int getMaxDistBeach() {
		return maxDistBeach;
	}
	
    /**
     * Method that will set the value of the field <code>maxDistBeach</code> by
     * the value sent as parameter.
     *
     * @param maxDistBeach int value to be added to field
     * <code>maxDistBeach</code>
     */
	public void setMaxDistBeach(int maxDistBeach) {
		this.maxDistBeach = maxDistBeach;
	}

    /**
     * Method that returns the field <code>minDistCenter</code> of the
     * {@link com.group.foctg.holidayMaker.model.Filter} object
     *
     * @return int of {@link com.group.foctg.holidayMaker.model.Filter} objects
     * field <code>minDistCenter</code>
     */
	public int getMinDistCenter() {
		return minDistCenter;
	}
	
    /**
     * Method that will set the value of the field <code>minDistCenter</code> by
     * the value sent as parameter.
     *
     * @param minDistCenter int value to be added to field
     * <code>minDistCenter</code>
     */
	public void setMinDistCenter(int minDistCenter) {
		this.minDistCenter = minDistCenter;
	}

    /**
     * Method that returns the field <code>maxDistCenter</code> of the
     * {@link com.group.foctg.holidayMaker.model.Filter} object
     *
     * @return int of {@link com.group.foctg.holidayMaker.model.Filter} objects
     * field <code>maxDistCenter</code>
     */
	public int getMaxDistCenter() {
		return maxDistCenter;
	}
	
    /**
     * Method that will set the value of the field <code>maxDistCenter</code> by
     * the value sent as parameter.
     *
     * @param maxDistCenter int value to be added to field
     * <code>maxDistCenter</code>
     */
	public void setMaxDistCenter(int maxDistCenter) {
		this.maxDistCenter = maxDistCenter;
	}

}
