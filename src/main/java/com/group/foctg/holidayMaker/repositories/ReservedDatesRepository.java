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
package com.group.foctg.holidayMaker.repositories;

import com.group.foctg.holidayMaker.model.ReservedDates;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for the
 * {@link com.group.foctg.holidayMaker.model.ReservedDates} and this extends
 * JpaRepository. This repository also has 1 custom function with their own HQL
 * query associated with it.
 *
 * This repository is suppose to be autowired by a Service. See
 * {@link com.group.foctg.holidayMaker.services.ReservedDatesService}.
 *
 * @author Christoffer Hansen &lt;chris.hansen.ch@outlook.com&gt;
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface ReservedDatesRepository extends JpaRepository<ReservedDates, Long> {

    @Query("SELECT d FROM ReservedDates d WHERE d.room.id = ?1")
    public List<ReservedDates> findReservedDatesByRoomId(Long id);
}
