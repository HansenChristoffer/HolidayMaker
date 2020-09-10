package com.group.foctg.holidayMaker.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Customer;
import com.group.foctg.holidayMaker.model.Filter;
import com.group.foctg.holidayMaker.repositories.AccommodationRepo;

@Service
@Transactional
public class AccommodationService {

	@Autowired
	private AccommodationRepo accommodationRepository;

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

	public Accommodation findOne(Long ID) {
		return accommodationRepository.getOne(ID);
	}

	public List<Accommodation> findAccommodationsByUser(Customer customer) {
		/*
		 * 1. CustomerRepo
		 * 2. if Customer exists in CustomerRepo
		 *    then return every accommodation that customer has
		 * */
		return null;
	}

	public List<Accommodation> getFilteredAccommodations(Filter filter, List<Accommodation> accommodations) {

		// do this last

		return null;
	}

}
