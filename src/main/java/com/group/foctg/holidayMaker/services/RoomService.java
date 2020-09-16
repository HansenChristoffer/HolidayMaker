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
package com.group.foctg.holidayMaker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Room;
import com.group.foctg.holidayMaker.repositories.RoomRepository;
import java.util.Optional;

/**
 * Service class for the {@link com.group.foctg.holidayMaker.model.Room} column
 * and entity. Autowires the repository.
 *
 * @author Tanvir Siddique
 *
 * @see com.group.foctg.holidayMaker.repositories.RoomRepository
 */
@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    /**
     * Saves the {@link com.group.foctg.holidayMaker.model.Room} object from
     * parameter in the database.
     *
     * @param room {@link com.group.foctg.holidayMaker.model.Room} object that
     * shall be saved
     * @return A boolean value representing whether the saving was successful or
     * not.
     */
    public boolean saveRoom(Room room) {
        return roomRepository.saveAndFlush(room).equals(room);
    }

    /**
     * Removes the {@link com.group.foctg.holidayMaker.model.Room} object with
     * the same <code>id</code> as the parameter from the database.
     *
     * @param id Long value used for finding and removing
     * {@link com.group.foctg.holidayMaker.model.Room} with that <code>id</code>
     * @return A boolean value representing whether the removing was successful
     * or not.
     */
    public boolean removeRoom(Long id) {
        if (roomRepository.existsById(id)) {
            roomRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    /**
     * If there is a Room object already that has the same id as the
     * {@link com.group.foctg.holidayMaker.model.Room} passed as parameter then
     * it'll update the existing object. Otherwise it will save the object.
     *
     * @param room {@link com.group.foctg.holidayMaker.model.Room} object passed
     * for updating or saving
     * @return A boolean value representing whether the updating or saving was
     * successful or not.
     */
    public boolean updateRoom(Room room) {
        return roomRepository.saveAndFlush(room).equals(room);
    }

    /**
     * Goes through the database, checks and returns all
     * {@link com.group.foctg.holidayMaker.model.Room} objects in the
     * List&lt;{@link com.group.foctg.holidayMaker.model.Room}&gt;
     *
     * @return List&lt;{@link com.group.foctg.holidayMaker.model.Room}&gt; 
     */
    public List<Room> findall() {
        return roomRepository.findAll();
    }

    /**
     * Goes through the database, checks and returns a
     * {@link com.group.foctg.holidayMaker.model.Room} object if a room with
     * given <code>id</code> exists.
     *
     * @param id Long value to use for finding the
     * {@link com.group.foctg.holidayMaker.model.Room}
     * @return {@link com.group.foctg.holidayMaker.model.Room} object with the
     * given <code>id</code>, if it exists.
     * @return Optional list of the type
     * {@link com.group.foctg.holidayMaker.model.Room} object with the given
     * <code>id</code>, if it exists
     */
    public Optional<Room> findById(Long id) {
        return roomRepository.findById(id);
    }

    /**
     * Goes through the database, checks and returns a
     * {@link com.group.foctg.holidayMaker.model.Accommodation} object in the
     * List&lt;{@link com.group.foctg.holidayMaker.model.Accommodation}&gt; if a
     * room with given <code>id</code> exists.
     *
     * @param id Long value to use for finding the
     * {@link com.group.foctg.holidayMaker.model.Accommodation}
     * @return
     * {@link com.group.foctg.holidayMaker.model.Accommodation} object from
     * {@link com.group.foctg.holidayMaker.model.Room} object with the given
     * <code>id</code>, if it exists.
     */
    public Accommodation findAccommodation(Long id) {
        return roomRepository.findAccommdotionByRoomId(id);
    }

}
