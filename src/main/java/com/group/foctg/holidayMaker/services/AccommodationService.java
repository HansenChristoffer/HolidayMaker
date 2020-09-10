package com.group.foctg.holidayMaker.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Customer;
import com.group.foctg.holidayMaker.repositories.AccommodationRepo;

@Service
@Transactional
public class AccommodationService {
	
	@Autowired
	private AccommodationRepo accommodationRepository;
	
	public boolean saveAccommodation(Accommodation accommodation) {
		return false;
	}
	
	public boolean removeAccommodation(Accommodation accommodation) {
		return false;
	}
	
	//Sounds good, doesnt work
	public boolean updateAccommodation(Accommodation accommodation) {
		return false;
	}
	
	//mitt förslag
	//Accommodation Entity SetID required
	//public boolean updateAccommodation(Accommodation old, Accommodation new) {
	//  new.setID(old);
	//	old = new
	//	
	//  return false;
	//}
	
	public List<Accommodation> findAll() {
		return null;
	}
	
	public Accommodation findOne(Long id) {
		return null;
	}
	
	public List<Accommodation> findAccommodationsByUser(Customer customer) {
		return null;
	}
	
	
	
}
