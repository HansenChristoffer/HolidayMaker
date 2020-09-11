package com.group.foctg.holidayMaker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Location;
import com.group.foctg.holidayMaker.repositories.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;

	public boolean saveLocation(Location location) {
		if (locationRepository.save(location).equals(location)) {
			return true;
		} else
			return false;
	}

	public boolean removeLocationByID(Long ID) {
		if (locationRepository.existsById(ID)) {
			Location found = locationRepository.getOne(ID);
			locationRepository.delete(found);
			return true;
		} else
			return false;
	}

	public List<Location> findAll() {
		return locationRepository.findAll();
	}

	public Location getOne(Long ID) {
		return locationRepository.getOne(ID);
	}

	public List<Accommodation> findAccommodationsByLocation(Long ID) {
		return locationRepository.findAccommodationsByLocationID(ID);
	}

}
