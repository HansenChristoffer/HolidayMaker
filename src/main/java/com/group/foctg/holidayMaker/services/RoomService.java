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

import com.group.foctg.holidayMaker.exceptions.AccommodationNotFoundException;
import com.group.foctg.holidayMaker.exceptions.RoomNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Room;
import com.group.foctg.holidayMaker.repositories.AccommodationRepository;
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

    @Autowired
    private AccommodationRepository accommodationRepository;

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
        if (accommodationRepository.existsById(room.getAccommodation().getId())) {
            return roomRepository.saveAndFlush(room).equals(room);
        } else {
            throw new AccommodationNotFoundException(room.getAccommodation().getId());
        }
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
            throw new RoomNotFoundException(id);
        }
    }

    /**
     * If there is a Room object already that has the same id as the
     * {@link com.group.foctg.holidayMaker.model.Room} passed as parameter then
     * it'll update the existing object. Otherwise it will save the object.
     *
     * @param room {@link com.group.foctg.holidayMaker.model.Room} object passed
     * for updating or saving
     * @param id The id of the {@link com.group.foctg.holidayMaker.model.Room to
     * update
     * @return A {@link com.group.foctg.holidayMaker.model.Room object
     */
    public Room updateRoom(Room room, Long id) {
        return roomRepository.findById(id).map(rom -> {
            rom.setNumberOfBeds(room.getNumberOfBeds());
            rom.setPrice(room.getPrice());
            return roomRepository.saveAndFlush(rom);
        }).orElseGet(() -> {
            throw new RoomNotFoundException(id);
        });
    }

    /**
     * Goes through the database, checks and returns all
     * {@link com.group.foctg.holidayMaker.model.Room} objects in the
     * List&lt;{@link com.group.foctg.holidayMaker.model.Room}&gt;
     *
     * @return List&lt;{@link com.group.foctg.holidayMaker.model.Room}&gt;
     */
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    /**
     * Goes through the database, checks and returns a
     * {@link com.group.foctg.holidayMaker.model.Room} object if a room with
     * given <code>id</code> exists.
     *
     * @param id Long value to use for finding the
     * {@link com.group.foctg.holidayMaker.model.Room}
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
     * @return {@link com.group.foctg.holidayMaker.model.Accommodation} object
     * from {@link com.group.foctg.holidayMaker.model.Room} object with the
     * given <code>id</code>, if it exists.
     */
    public Accommodation findAccommodationByRoomId(Long id) {
        return roomRepository.findAccommdotionByRoomId(id);
    }

}
