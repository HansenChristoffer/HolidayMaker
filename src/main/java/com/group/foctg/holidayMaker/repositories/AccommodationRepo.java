package com.group.foctg.holidayMaker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Customer;
import com.group.foctg.holidayMaker.filter.Filter;

public interface AccommodationRepo extends JpaRepository<Accommodation, Long> {

	List<Accommodation> findAccommodationsByUser(Customer customer);
	List<Accommodation> findAccommodationsByFilter(Filter filter);
	
}
