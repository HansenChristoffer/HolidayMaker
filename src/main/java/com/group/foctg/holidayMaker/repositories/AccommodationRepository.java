package com.group.foctg.holidayMaker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group.foctg.holidayMaker.model.Accommodation;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

    @Query("SELECT a FROM Accommodation a WHERE a.customer = ?1")
    List<Accommodation> findAccommodationsByCustomerID(Long ID);
	
}
