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
package com.group.foctg.holidayMaker.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.group.foctg.holidayMaker.exceptions.RoomNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Room;
import com.group.foctg.holidayMaker.services.RoomService;
import java.text.ParseException;
import java.util.Optional;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

/**
 * RestController for the {@link com.group.foctg.holidayMaker.model.Room} entity
 * and column. This class holds all the endpoints for
 * {@link com.group.foctg.holidayMaker.model.Room}.
 *
 * Autowiring {@link com.group.foctg.holidayMaker.services.RoomService}.
 *
 * The default URL value is set to, "/api".
 *
 * @author Frida Ek
 * @see com.group.foctg.holidayMaker.services.RoomService
 */
@RestController
@RequestMapping(value = "/api")
@Slf4j
public class RoomController {

    @Autowired
    private RoomService roomService;

    /**
     * POST endpoint method that listens on <code>"/room"</code> URL and will
     * call the
     * {@link com.group.foctg.holidayMaker.services.RoomService#saveRoom} method
     * from the Service.
     *
     * @param room {@link com.group.foctg.holidayMaker.model.Room} object to
     * pass to the Service class.
     * @return a boolean value from the autowired Service.
     */
    @PostMapping("/room")
    public boolean saveRoom(@RequestBody Room room) {
        return roomService.saveRoom(room);
    }

    /**
     * DELETE endpoint method that listens on <code>"/room"</code> URL and will
     * call the
     * {@link com.group.foctg.holidayMaker.services.RoomService#removeRoom}
     * method from the autowired Service.
     *
     * @param id Long value to pass to the Service class.
     * @return a boolean value from the Service.
     */
    @DeleteMapping("/room")
    public boolean removeRoom(@RequestParam Long id) {
        return roomService.removeRoom(id);
    }

    /**
     * PUT endpoint method that listens on <code>"/room"</code> URL and will
     * call the
     * {@link com.group.foctg.holidayMaker.services.RoomService#updateRoom}
     * method from the autowired Service.
     *
     * @param room {@link com.group.foctg.holidayMaker.model.Room} object to
     * pass to the Service class.
     * @param id
     * @return a boolean value from the Service.
     */
    @PutMapping("/room")
    public Room updateRoom(@RequestBody Room room, @RequestParam Long id) {
        return roomService.updateRoom(room, id);
    }

    /**
     * GET endpoint method that listens on <code>"/rooms"</code> URL and will
     * call the
     * {@link com.group.foctg.holidayMaker.services.RoomService#findAll} method
     * from the Service.
     *
     * @return a List object from the autowired Service.
     */
    @GetMapping("/rooms")
    public List<Room> findAll() {
        return roomService.findAll();
    }

    /**
     * GET endpoint method that listens on <code>"/rooms"</code> URL and will
     * call the
     * {@link com.group.foctg.holidayMaker.services.RoomService#findById} method
     * from the autowired Service.
     *
     * @param id Long value to pass to the Service class.
     * @return a Optional list of type
     * {@link com.group.foctg.holidayMaker.model.Room} object from the Service.
     */
    @GetMapping("/room")
    public Optional<Room> findById(@RequestParam Long id) {
        Optional<Room> room = roomService.findById(id);

        if (room.isEmpty()) {
            throw new RoomNotFoundException(id);
        }

        return room;
    }

    /**
     * GET endpoint method that listens on <code>"/room/accommodation"</code>
     * URL and will call the
     * {@link com.group.foctg.holidayMaker.services.RoomService#findAccommodationByRoomId}
     * method from the autowired Service.
     *
     * @param id Long value to pass to the Service class.
     * @return a {@link com.group.foctg.holidayMaker.model.Accommodation} object
     * from the Service.
     */
    @GetMapping("/room/accommodation")
    public Accommodation findAccommodationByRoomId(@RequestParam Long id) {
        return roomService.findAccommodationByRoomId(id);
    }

    /**
     * GET endpoint method that listens on <code>"/rooms/accommodation"</code>
     * URL and will call the
     * {@link com.group.foctg.holidayMaker.services.RoomService#findAllByAccommodationId(java.lang.Long)}
     * method from the autowired Service.
     *
     * @param id Long value to pass to the Service class.
     * @return a Set of type {@link com.group.foctg.holidayMaker.model.Room}
     * from the Service.
     */
    @GetMapping("/rooms/accommodation")
    public Set<Room> findAllByAccommodationId(@RequestParam Long id) {
        return roomService.findAllByAccommodationId(id);
    }

    /**
     * GET endpoint method that listens on <code>"/rooms/accommodation"</code>
     * URL and will call the
     * {@link com.group.foctg.holidayMaker.services.RoomService#findAllByAccommodationIdFilteredByDate(java.lang.Long, java.lang.String, java.lang.String)}
     * method from the autowired Service.
     *
     * @param id Long value to pass to the Service class.
     * @param dates ObjectNode that expects a JSON with 2 fields named dateFrom
     * and dateTo
     * @return a Set of type {@link com.group.foctg.holidayMaker.model.Room}
     * from the Service.
     * @throws java.text.ParseException
     */
    @GetMapping("/rooms/accommodation/filter")
    public Set<Room> findAllByAccommodationIdFilteredByDate(@RequestParam Long id, @RequestBody ObjectNode dates) throws ParseException {
        return roomService.findAllByAccommodationIdFilteredByDate(id, dates.get("dateFrom").asText(), dates.get("dateFrom").asText());
    }

}
