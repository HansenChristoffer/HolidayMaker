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

import com.group.foctg.holidayMaker.model.ReservedDates;
import com.group.foctg.holidayMaker.services.ReservedDatesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController for the
 * {@link com.group.foctg.holidayMaker.model.ReservedDates} entity and column.
 * This class holds all the endpoints for
 * {@link com.group.foctg.holidayMaker.model.ReservedDates}.
 *
 * Autowiring
 * {@link com.group.foctg.holidayMaker.services.ReservedDatesService}.
 *
 * The default URL value is set to, "/api".
 *
 * @author Christoffer Hansen &lt;chris.hansen.ch@outlook.com&gt;
 *
 */
@RestController
@RequestMapping(value = "/api")
public class ReservedDatesController {

    @Autowired
    private ReservedDatesService reservedDatesService;

    @PostMapping("/reserveddates")
    public ReservedDates saveReservedDatesService(ReservedDates reservedDates) {
        return reservedDatesService.saveReservedDates(reservedDates);
    }

    @GetMapping("/reserveddates")
    public List<ReservedDates> findAll() {
        return reservedDatesService.findAll();
    }

    @GetMapping("/reserveddates/byroom")
    public List<ReservedDates> findReservedDatesByRoomId(@RequestParam Long id) {
        return reservedDatesService.findReservedDatesByRoomId(id);
    }

}
