package com.group.foctg.holidayMaker.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Customer;
import com.group.foctg.holidayMaker.model.Filter;
import com.group.foctg.holidayMaker.repositories.AccommodationRepository;

@Service
@Transactional
public class AccommodationService {

	@Autowired
	private AccommodationRepository accommodationRepository;

	public boolean saveAccommodation(Accommodation accommodation) {
		if (accommodationRepository.save(accommodation).equals(accommodation)) {
			return true;
		} else return false;
	}

	public boolean removeAccommodationByID(Long ID) {
		if (accommodationRepository.existsById(ID)) {
			Accommodation found = accommodationRepository.getOne(ID);
			accommodationRepository.delete(found);
			return true;
		} else return false;
	}

	// Sounds good, doesnt work
	public boolean updateAccommodation(Accommodation accommodation) {
		return false;
	}

	// mitt förslag
	// Accommodation Entity SetID required
	// public boolean updateAccommodation(Accommodation old, Accommodation new) {
	// new.setID(old);
	// old = new
	//
	// return false;
	// }

	public List<Accommodation> findAll() {
		return accommodationRepository.findAll();
	}

	public Accommodation getOne(Long ID) {
		return accommodationRepository.getOne(ID);
	}

	public List<Accommodation> findAccommodationsByUser(Long id) {
            return accommodationRepository.findAccommodationsByCustomerID(id);
	}

	public List<Accommodation> getFilteredAccommodations(Filter filter) {

		
		List<Accommodation> filtered = findAll().stream()
			    .filter(a -> a.getDistanceToBeach() > filter.getMinDistBeach() && a.getDistanceToBeach() < filter.getMaxDistBeach())
			    .filter(a -> a.getDistanceToCenter() > filter.getMinDistCenter() && a.getDistanceToCenter() < filter.getMaxDistCenter())
			    //.filter(a -> a.getLocation().getName() == filter.getLocation() && a.getLocation() != null && filter.getLocation() != null)
			    .filter(a -> a.getPool() == true || filter.hasPool() == false)
			    .filter(a -> a.getChildEvents() == true || filter.hasChildrenClub() == false)
			    .filter(a -> a.getRestaurant() == true || filter.hasRestaurant() == false)
			    .filter(a -> a.getNightEntertainment() == true || filter.hasNightEntertainment() == false)
			    //filter rooms
			    //filter beds
			    //filter price
			    //filter package
			    .collect(Collectors.toList());
		
		
		return filtered;
	}

}
