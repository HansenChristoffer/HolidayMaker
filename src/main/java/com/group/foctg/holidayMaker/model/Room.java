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

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * The {@link com.group.foctg.holidayMaker.model.Room} entity class. Holds
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
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column
    private Long ID;

    @Column
    private Short numberOfBeds;

    @ManyToOne
    private Accommodation accommodation;

    //@Column
    //private Boolean isVacant;
    
    @Column
    private Float price;

    //@Column
    //private List<List<Date>> datesAvailable;
    
    /**
     * Method that returns the <code>id</code> of the
     * {@link com.group.foctg.holidayMaker.model.Room} object
     *
     * @return Long value {@link com.group.foctg.holidayMaker.model.Room}
     * objects field <code>id</code>
     */
    public Long getID() {
        return ID;
    }
    
    /**
     * Method that returns the field <code>numberOfBeds</code> of the
     * {@link com.group.foctg.holidayMaker.model.Room} object
     * 
     * @return Short of {@link com.group.foctg.holidayMaker.model.Room}
     * objects field <code>numberOfBeds</code>
     */
    public Short getNumberOfBeds() {
        return numberOfBeds;
    }
    
    /**
     * Method that will set the value of the field <code>numberOfBeds</code>
     * by the value sent as parameter.
     *
     * @param numberOfBeds <code>Short</code> value to be added to field
     * <code>numberOfBeds</code>
     */
    public void setNumberOfBeds(Short numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }
    
    /**
     * Method that returns the field <code>accommodation</code> of the
     * {@link com.group.foctg.holidayMaker.model.Room} object
     * 
     * @return {@link com.group.foctg.holidayMaker.model.Accommodation} object of
     * {@link com.group.foctg.holidayMaker.model.Room} objects field
     * <code>accommodation</code>
     */
    public Accommodation getAccommodation() {
        return accommodation;
    }
    
    /**
     * Method that will set the value of the field <code>accommodation</code> by the
     * value sent as parameter.
     *
     * @param accommodation {@link com.group.foctg.holidayMaker.model.Room} value
     * to be added to field <code>accommodation</code>
     */
    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }
    
    /**
     * Method that returns the field <code>price</code> of the
     * {@link com.group.foctg.holidayMaker.model.Room} object
     * 
     * @return Float of {@link com.group.foctg.holidayMaker.model.Room}
     * objects field <code>price</code>
     */
    public Float getPrice() {
        return price;
    }
    
    /**
     * Method that will set the value of the field <code>price</code>
     * by the value sent as parameter.
     *
     * @param price <code>Float</code> value to be added to field
     * <code>price</code>
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    //public List<List<Date>> getDatesAvailable() {
    //    return datesAvailable;
    //}
    //public void setDatesAvailable(List<List<Date>> datesAvailable) {
    //    this.datesAvailable = datesAvailable;
    //}
}
