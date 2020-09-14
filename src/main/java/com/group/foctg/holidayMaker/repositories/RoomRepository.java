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

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Room;

/**
 * Repository interface for the
 * {@link com.group.foctg.holidayMaker.model.Room} and this extends
 * JpaRepository. This repository also has 1 custom functions with their own HQL
 * query associated with them.
 *
 * This repository is suppose to be autowired by a Service. See
 * {@link com.group.foctg.holidayMaker.services.RoomService}.
 *
 * @author Tanvir Siddique
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
	
	@Query("SELECT r.accommodation FROM Room r WHERE r.id = ?1")
	public Accommodation findAccommdotionByRoomId(Long id);


}

