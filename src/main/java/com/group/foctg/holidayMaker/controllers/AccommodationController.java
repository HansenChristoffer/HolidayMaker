package com.group.foctg.holidayMaker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Filter;
import com.group.foctg.holidayMaker.services.AccommodationService;

@RestController
public class AccommodationController {

	@Autowired
	private AccommodationService accommodationService;

	@GetMapping("/accommodations")
	public List<Accommodation> allAccommodations() {
		return accommodationService.findAll();
	}
	
	@PostMapping("/accommodations")
	public String saveAccommodation(@RequestBody Accommodation accommodation) {
		if (accommodationService.saveAccommodation(accommodation)) {
			return "Saved!";
		} else return "Not Saved!";
	}

	@GetMapping("/filter")
	public List<Accommodation> filterAccommodations(@RequestBody Filter filter) {
		return accommodationService.getFilteredAccommodations(filter, accommodationService.findAll());
	}

	@GetMapping("/accommodations/id={ID}")
	public String getOneAccommodation(@PathVariable Long ID) {
		return accommodationService.findOne(ID).getID().toString();
	}
	
	@DeleteMapping("/accommodations/del={ID}")
	public void deleteAccommodation(@PathVariable Long ID) {
		accommodationService.removeAccommodationByID(ID);
	}
}
