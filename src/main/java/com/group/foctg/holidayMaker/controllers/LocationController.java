package com.group.foctg.holidayMaker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Location;
import com.group.foctg.holidayMaker.services.LocationService;


@RestController
public class LocationController {

	@Autowired
	private LocationService locationService;

	@GetMapping("/api/locations")
	public List<Location> allLocations() {
		return locationService.findAll();
	}
	
	@PostMapping("/api/location")
	public boolean saveAccommodation(@RequestBody Location location) {
		if (locationService.saveLocation(location)) {
			return true;
		} else return false;
	}

	@GetMapping("/api/location")
	public String getOneLocation(@RequestParam Long locationid) {
		return locationService.getOne(locationid).getID().toString();
	}
	
	@DeleteMapping("/api/location")
	public void deleteAccommodation(@RequestParam Long locationid) {
		locationService.removeLocationByID(locationid);
	}
	
	@GetMapping("/api/location/accommodations")
	public List<Accommodation> getAccommodationsByLocationID(@RequestParam Long locationid) {
		return locationService.findAccommodationsByLocation(locationid);
	}
}
