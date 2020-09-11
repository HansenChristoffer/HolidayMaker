package com.group.foctg.holidayMaker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Customer;
import com.group.foctg.holidayMaker.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    
    @Query("SELECT a FROM Accommodation a WHERE a.location.ID = ?1")
    List<Accommodation> findAccommodationsByLocationID(Long ID);
}
