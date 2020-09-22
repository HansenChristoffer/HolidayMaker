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

import com.group.foctg.holidayMaker.model.ReservedDates;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.group.foctg.holidayMaker.repositories.ReservedDatesRepository;

/**
 * Service class for the
 * {@link com.group.foctg.holidayMaker.services.ReservedDatesService} column and
 * entity. Autowires the repository.
 *
 *
 * @author Christoffer Hansen &lt;chris.hansen.ch@outlook.com&gt;
 * 
 * @see com.group.foctg.holidayMaker.repositories.ReservedDatesRepository
 */
@Service
public class ReservedDatesService {

    @Autowired
    private ReservedDatesRepository reservedDatesRepository;

    //for testing purposes
    public List<ReservedDates> findAll() {
        return reservedDatesRepository.findAll();
    }

    public List<ReservedDates> findReservedDatesByRoomId(Long id) {
        return reservedDatesRepository.findReservedDatesByRoomId(id);
    }

    public ReservedDates saveReservedDates(ReservedDates reservedDates) {
        return reservedDatesRepository.saveAndFlush(reservedDates);
    }

    public boolean roomExistsById(Long id) {
        return (!reservedDatesRepository.findReservedDatesByRoomId(id).isEmpty());
    }

}
