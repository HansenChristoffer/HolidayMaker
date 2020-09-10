package com.group.foctg.holidayMaker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Booking;
import com.group.foctg.holidayMaker.model.Customer;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    
    @Query("SELECT c FROM Customer c WHERE c.email = ?1")
    Customer findCustomerByEmail(String email);
    
    @Query("SELECT c.bookings FROM Customer c WHERE c.id = ?1")
    List<Booking> findBookingsByID(Long ID);
    
    @Query("SELECT c.accommodations FROM Customer c WHERE c.id = ?1")
    List<Accommodation> findAccommodationsByID(Long ID);
}