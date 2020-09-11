package com.group.foctg.holidayMaker.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Room;

@Repository
public interface RoomRepo extends JpaRepository<Room, Long> {
	
	public Accommodation findAccommdotionByID(Long ID);
	
	
	//public List<List<Date>> findDatesAvailable();

}

