/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group.foctg.holidayMaker.repositories;

import com.group.foctg.holidayMaker.model.ReservedDates;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Chris
 */
@Repository
public interface ReservedDatesRepository extends JpaRepository<ReservedDates, Long> {

    @Query("SELECT d FROM ReservedDates d WHERE d.room.id = ?1")
    public List<ReservedDates> findReservedDatesByRoomId(Long id);
}
