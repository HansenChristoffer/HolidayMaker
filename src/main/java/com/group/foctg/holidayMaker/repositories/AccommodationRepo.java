package com.group.foctg.holidayMaker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Customer;
import com.group.foctg.holidayMaker.model.Filter;

@Repository
public interface AccommodationRepo extends JpaRepository<Accommodation, Long> {

	List<Accommodation> findAccommodationsByCustomerID(Long ID);
	
}
