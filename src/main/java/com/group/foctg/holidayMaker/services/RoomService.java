package com.group.foctg.holidayMaker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Room;
import com.group.foctg.holidayMaker.repositories.RoomRepository;

@Service
public class RoomService {
	
	@Autowired
	private RoomRepository roomRepository;
	
	public boolean saveRoom(Room room) {
		if(roomRepository.saveAndFlush(room).equals(room)) {
		return true;
		}else {
			return false;
		}
	}
	
	public boolean removeRoom(Long id) {
		if(roomRepository.existsById(id)) {
			roomRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean updateRoom(Room room) {
		if(roomRepository.saveAndFlush(room).equals(room)) {
			return true;
			}else {
				return false;
			}
	}
	
	public List<Room> findall() {
		return roomRepository.findAll();
	}
	
	public Room getOne(Long id) {
		return roomRepository.getOne(id);
	}
	
	public Accommodation findAccommodation(Long id) {
		return roomRepository.findAccommdotionByID(id);
	}
	

}
