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
 * The {@link com.group.foctg.holidayMaker.model.Accommodation} entity class. Holds
 * the various fields that are required for the functionality of the program.
 * These fields are also turned into columns in the SQLite3 database. There is
 * also one OneToMany and one ManyToOne relationships with other entity classes.
 *
 * Uses the SEQUENCE type for auto gen id values because of the restrictions
 * that SQLite3 holds.
 *
 * @author Olle Johansson
 */

@Entity
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "id")
public class Accommodation implements Serializable {

    public Accommodation() {
    }

    public Accommodation(String name, Boolean pool, Boolean nightEntertainment, 
            Boolean childEvents, Boolean restaurant, Short distanceToBeach, 
            Short distanceToCenter, Location location, String imageURL, 
            String description, List<Room> rooms, Customer customer) {
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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPool() {
        return pool;
    }

    public void setPool(Boolean pool) {
        this.pool = pool;
    }

    public Boolean getNightEntertainment() {
        return nightEntertainment;
    }

    public void setNightEntertainment(Boolean nightEntertainment) {
        this.nightEntertainment = nightEntertainment;
    }

    public Boolean getChildEvents() {
        return childEvents;
    }

    public void setChildEvents(Boolean childEvents) {
        this.childEvents = childEvents;
    }

    public Boolean getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Boolean restaurant) {
        this.restaurant = restaurant;
    }

    public Short getDistanceToBeach() {
        return distanceToBeach;
    }

    public void setDistanceToBeach(Short distanceToBeach) {
        this.distanceToBeach = distanceToBeach;
    }

    public Short getDistanceToCenter() {
        return distanceToCenter;
    }

    public void setDistanceToCenter(Short distanceToCenter) {
        this.distanceToCenter = distanceToCenter;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
