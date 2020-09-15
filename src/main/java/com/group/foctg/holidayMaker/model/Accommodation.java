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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * The {@link com.group.foctg.holidayMaker.model.Accommodation} entity class.
 * Holds the various fields that are required for the functionality of the
 * program. These fields are also turned into columns in the SQLite3 database.
 * There is also one OneToMany and one ManyToOne relationships with other entity
 * classes.
 *
 * Uses the SEQUENCE type for auto gen id values because of the restrictions
 * that SQLite3 holds.
 *
 * @author Olle Johansson
 */

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Accommodation implements Serializable {


	public Accommodation() {
	}

	public Accommodation(String name, Boolean pool, Boolean nightEntertainment, Boolean childEvents, Boolean restaurant,
			Short distanceToBeach, Short distanceToCenter, Location location, String imageURL, String description,
			List<Room> rooms, Customer customer) {
		this.name = name;
		this.pool = pool;
		this.nightEntertainment = nightEntertainment;
		this.childEvents = childEvents;
		this.restaurant = restaurant;
		this.distanceToBeach = distanceToBeach;
		this.distanceToCenter = distanceToCenter;
		this.location = location;
		this.imageURL = imageURL;
		this.description = description;
		this.rooms = rooms;
		this.customer = customer;
	}

	@Id
	@GeneratedValue
	@Column(name = "accommodation_id")
	private Long id;

	@Column
	private String name;

	@Column
	private Boolean pool;

	@Column
	private Boolean nightEntertainment;

	@Column
	private Boolean childEvents;

	@Column
	private Boolean restaurant;

	@Column
	private Short distanceToBeach;

	@Column
	private Short distanceToCenter;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Location location;

	@Column
	private String imageURL;

	@Column
	private String description;

	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Room> rooms;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private Customer customer;
	
	@Column
	private Float rating;

	/**
	 * Method that returns the <code>id</code> of the
	 * {@link com.group.foctg.holidayMaker.model.Accommodation} object
	 *
	 * @return Long value {@link com.group.foctg.holidayMaker.model.Accommodation}
	 *         objects field <code>id</code>
	 */

	public Long getId() {
		return id;
	}

	/**
	 * Method that returns the field <code>customer</code> of the
	 * {@link com.group.foctg.holidayMaker.model.Accommodation} object
	 *
	 * @return {@link java.lang.String} object of
	 *         {@link com.group.foctg.holidayMaker.model.Accommodation} objects
	 *         field <code>name</code>
	 */

	public String getName() {
		return name;
	}

	/**
	 * Method that will set the value of the field <code>name</code> by the value
	 * sent as parameter.
	 *
	 * @param name {@link java.lang.String} value to be added to field
	 *             <code>name</code>
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method that returns the field <code>pool</code> of the
	 * {@link com.group.foctg.holidayMaker.model.Accommodation} object
	 *
	 * @return {@link java.lang.Boolean} object of
	 *         {@link com.group.foctg.holidayMaker.model.Accommodation} objects
	 *         field <code>pool</code>
	 */

	public Boolean getPool() {
		return pool;
	}

	/**
	 * Method that will set the value of the field <code>pool</code> by the value
	 * sent as parameter.
	 *
	 * @param name {@link java.lang.Boolean} value to be added to field
	 *             <code>pool</code>
	 */

	public void setPool(Boolean pool) {
		this.pool = pool;
	}

	/**
	 * Method that returns the field <code>nightEntertainment</code> of the
	 * {@link com.group.foctg.holidayMaker.model.Accommodation} object
	 *
	 * @return {@link java.lang.Boolean} object of
	 *         {@link com.group.foctg.holidayMaker.model.Accommodation} objects
	 *         field <code>nightEntertainment</code>
	 */

	public Boolean getNightEntertainment() {
		return nightEntertainment;
	}

	/**
	 * Method that will set the value of the field <code>nightEntertainment</code>
	 * by the value sent as parameter.
	 *
	 * @param name {@link java.lang.Boolean} value to be added to field
	 *             <code>nightEntertainment</code>
	 */

	public void setNightEntertainment(Boolean nightEntertainment) {
		this.nightEntertainment = nightEntertainment;
	}

	/**
	 * Method that returns the field <code>childEvents</code> of the
	 * {@link com.group.foctg.holidayMaker.model.Accommodation} object
	 *
	 * @return {@link java.lang.Boolean} object of
	 *         {@link com.group.foctg.holidayMaker.model.Accommodation} objects
	 *         field <code>childEvents</code>
	 */

	public Boolean getChildEvents() {
		return childEvents;
	}

	/**
	 * Method that will set the value of the field <code>childEvents</code> by the
	 * value sent as parameter.
	 *
	 * @param name {@link java.lang.Boolean} value to be added to field
	 *             <code>childEvents</code>
	 */

	public void setChildEvents(Boolean childEvents) {
		this.childEvents = childEvents;
	}

	/**
	 * Method that returns the field <code>restaurant</code> of the
	 * {@link com.group.foctg.holidayMaker.model.Accommodation} object
	 *
	 * @return {@link java.lang.Boolean} object of
	 *         {@link com.group.foctg.holidayMaker.model.Accommodation} objects
	 *         field <code>restaurant</code>
	 */

	public Boolean getRestaurant() {
		return restaurant;
	}

	/**
	 * Method that will set the value of the field <code>restaurant</code> by the
	 * value sent as parameter.
	 *
	 * @param name {@link java.lang.Boolean} value to be added to field
	 *             <code>restaurant</code>
	 */

	public void setRestaurant(Boolean restaurant) {
		this.restaurant = restaurant;
	}

	/**
	 * Method that returns the field <code>distanceToBeach</code> of the
	 * {@link com.group.foctg.holidayMaker.model.Accommodation} object
	 *
	 * @return {@link java.lang.Short} object of
	 *         {@link com.group.foctg.holidayMaker.model.Accommodation} objects
	 *         field <code>distanceToBeach</code>
	 */

	public Short getDistanceToBeach() {
		return distanceToBeach;
	}

	/**
	 * Method that will set the value of the field <code>distanceToBeach</code> by
	 * the value sent as parameter.
	 *
	 * @param name {@link java.lang.Short} value to be added to field
	 *             <code>distanceToBeach</code>
	 */

	public void setDistanceToBeach(Short distanceToBeach) {
		this.distanceToBeach = distanceToBeach;
	}

	/**
	 * Method that returns the field <code>distanceToCenter</code> of the
	 * {@link com.group.foctg.holidayMaker.model.Accommodation} object
	 *
	 * @return {@link java.lang.Short} object of
	 *         {@link com.group.foctg.holidayMaker.model.Accommodation} objects
	 *         field <code>distanceToCenter</code>
	 */

	public Short getDistanceToCenter() {
		return distanceToCenter;
	}

	/**
	 * Method that will set the value of the field <code>distanceToCenter</code> by
	 * the value sent as parameter.
	 *
	 * @param name {@link java.lang.Short} value to be added to field
	 *             <code>distanceToCenter</code>
	 */

	public void setDistanceToCenter(Short distanceToCenter) {
		this.distanceToCenter = distanceToCenter;
	}

	/**
	 * Method that returns the field <code>location</code> of the
	 * {@link com.group.foctg.holidayMaker.model.Accommodation} object
	 *
	 * @return {@link com.group.foctg.holidayMaker.model.Location} object of
	 *         {@link com.group.foctg.holidayMaker.model.Accommodation} objects
	 *         field <code>location</code>
	 */

	public Location getLocation() {
		return location;
	}

	/**
	 * Method that will set the value of the field <code>location</code> by the
	 * value sent as parameter.
	 *
	 * @param name {@link com.group.foctg.holidayMaker.model.Location} value to be
	 *             added to field <code>location</code>
	 */

	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * Method that returns the field <code>imageURL</code> of the
	 * {@link com.group.foctg.holidayMaker.model.Accommodation} object
	 *
	 * @return {@link java.lang.String} object of
	 *         {@link com.group.foctg.holidayMaker.model.Accommodation} objects
	 *         field <code>imageURL</code>
	 */

	public String getImageURL() {
		return imageURL;
	}

	/**
	 * Method that will set the value of the field <code>imageURL</code> by the
	 * value sent as parameter.
	 *
	 * @param name {@link java.lang.String} value to be added to field
	 *             <code>imageURL</code>
	 */

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	/**
	 * Method that returns the field <code>description</code> of the
	 * {@link com.group.foctg.holidayMaker.model.Accommodation} object
	 *
	 * @return {@link java.lang.String} object of
	 *         {@link com.group.foctg.holidayMaker.model.Accommodation} objects
	 *         field <code>description</code>
	 */

	public String getDescription() {
		return description;
	}

	/**
	 * Method that will set the value of the field <code>description</code> by the
	 * value sent as parameter.
	 *
	 * @param name {@link java.lang.String} value to be added to field
	 *             <code>description</code>
	 */

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Method that returns the field <code>rooms</code> of the
	 * {@link com.group.foctg.holidayMaker.model.Accommodation} object
	 *
	 * @return {@link java.util.List} object of
	 *         {@link com.group.foctg.holidayMaker.model.Accommodation} objects
	 *         field <code>rooms</code>
	 */

	public List<Room> getRooms() {
		return rooms;
	}

	/**
	 * Method that will set the value of the field <code>rooms</code> by the value
	 * sent as parameter.
	 *
	 * @param name {@link java.util.List} value to be added to field
	 *             <code>rooms</code>
	 */

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	/**
	 * Method that returns the field <code>customer</code> of the
	 * {@link com.group.foctg.holidayMaker.model.Accommodation} object
	 *
	 * @return {@link com.group.foctg.holidayMaker.model.Customer} object of
	 *         {@link com.group.foctg.holidayMaker.model.Accommodation} objects
	 *         field <code>customer</code>
	 */

	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Method that will set the value of the field <code>customer</code> by the
	 * value sent as parameter.
	 *
	 * @param name {@link com.group.foctg.holidayMaker.model.Customer} value to be
	 *             added to field <code>customer</code>
	 */

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Method that returns the field <code>rating</code> of the
	 * {@link com.group.foctg.holidayMaker.model.Accommodation} object
	 *
	 * @return {@link java.lang.Float} object of
	 *         {@link com.group.foctg.holidayMaker.model.Accommodation} objects
	 *         field <code>rating</code>
	 */
	
    public Float getRating() {
		return rating;
	}
    
    /**
	 * Method that will set the value of the field <code>rating</code> by the
	 * value sent as parameter.
	 *
	 * @param name {@link java.lang.Float} value to be
	 *             added to field <code>rating</code>
	 */

	public void setRating(Float rating) {
		this.rating = rating;
	}

}
