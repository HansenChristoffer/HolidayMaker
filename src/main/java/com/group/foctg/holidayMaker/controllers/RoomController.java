package com.group.foctg.holidayMaker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Room;
import com.group.foctg.holidayMaker.services.RoomService;

@RestController
public class RoomController {
	
	@Autowired
	RoomService roomService;
	
	@PostMapping("/api/room")
	public boolean saveRoom(@RequestBody Room room) {
		return roomService.saveRoom(room);
	}
	
	@DeleteMapping("/api/room")
	public boolean removeRoom(@RequestParam Long id) {
		return roomService.removeRoom(id);
	}
	
	@PutMapping("/api/room")
	public boolean updateRoom(@RequestBody Room room) {
		return roomService.updateRoom(room);
	}
	
	@GetMapping("/api/rooms")
	public List<Room> findAll() {
		return roomService.findall();
	}
	
	@GetMapping("/api/room") 
	public Room getOne(@RequestParam Long id) {
		return roomService.getOne(id);
	}
	
	@GetMapping("/api/room/accommodation")
	public Accommodation findAccommodation(@RequestParam Long id) {
		return roomService.findAccommodation(id);
	}
}
