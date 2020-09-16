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
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 * The {@link com.group.foctg.holidayMaker.model.Location} entity class. Holds
 * the various fields that are required for the functionality of the program.
 * These fields are also turned into columns in the SQLite3 database. There is
 * also one OneToMany relationships with other entity classes.
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
public class Location implements Serializable {

    public Location() {
    }

    public Location(String name, List<Accommodation> accommodations) {
        this.name = name;
        this.accommodations = accommodations;
    }

    @Id
    @GeneratedValue
    @Column(name = "location_id")
    private Long id;

    @NotEmpty
    @Column
    private String name;
    
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Accommodation> accommodations;

    /**
     * Method that returns the <code>id</code> of the
     * {@link com.group.foctg.holidayMaker.model.Location} object
     *
     * @return Long value {@link com.group.foctg.holidayMaker.model.Location}
     * objects field <code>id</code>
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Method that returns the field <code>name</code> of the
     * {@link com.group.foctg.holidayMaker.model.Location} object
     *
     * @return String of {@link com.group.foctg.holidayMaker.model.Location}
     * objects field <code>name</code>
     */
    public String getName() {
        return this.name;
    }

    /**
     * Method that will set the value of the field <code>name</code> by the
     * value sent as parameter.
     *
     * @param name String value to be added to field <code>name</code>
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method that returns the field <code>accommodation</code> of the
     * {@link com.group.foctg.holidayMaker.model.Location} object.
     *
     * @return
     * List&lt;{@link com.group.foctg.holidayMaker.model.Accommodation}&gt; of
     * the {@link com.group.foctg.holidayMaker.model.Location} objects field
     * accommodations
     */
    public List<Accommodation> getAccommodation() {
        return this.accommodations;
    }

    /**
     * Method that will set the value of the field <code>accommodations</code>
     * by the value sent as parameter.
     *
     * @param accommodations List that will become the new
     * <code>accommodations</code>
     */
    public void setAccommodation(List<Accommodation> accommodations) {
        this.accommodations = accommodations;
    }
}
