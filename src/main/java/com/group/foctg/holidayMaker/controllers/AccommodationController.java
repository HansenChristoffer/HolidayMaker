package com.group.foctg.holidayMaker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Filter;
import com.group.foctg.holidayMaker.services.AccommodationService;

@RestController
public class AccommodationController {

	@Autowired
	private AccommodationService accommodationService;

	@GetMapping("/api/accommodations")
	public List<Accommodation> allAccommodations() {
		return accommodationService.findAll();
	}
	
	@PostMapping("/api/accommodation")
	public boolean saveAccommodation(@RequestBody Accommodation accommodation) {
		if (accommodationService.saveAccommodation(accommodation)) {
			return true;
		} else return false;
	}

	@GetMapping("/api/accommodation/filter")
	public List<Accommodation> filterAccommodations(@RequestBody Filter filter) {
		return accommodationService.getFilteredAccommodations(filter);
	}

	@GetMapping("/api/accommodation")
	public String getOneAccommodation(@RequestParam Long accommodationid) {
		return accommodationService.getOne(accommodationid).getID().toString();
	}
	
	@DeleteMapping("/api/accommodation")
	public void deleteAccommodation(@RequestParam Long accommodationid) {
		accommodationService.removeAccommodationByID(accommodationid);
	}
}