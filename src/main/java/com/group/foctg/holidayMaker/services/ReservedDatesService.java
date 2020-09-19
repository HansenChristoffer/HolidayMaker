/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group.foctg.holidayMaker.services;

import com.group.foctg.holidayMaker.model.ReservedDates;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.group.foctg.holidayMaker.repositories.ReservedDatesRepository;

/**
 *
 * @author Chris
 */
@Service
public class ReservedDatesService {

    @Autowired
    private ReservedDatesRepository reservedDatesRepository;

    //for testing purposes
    public List<ReservedDates> findAll() {
        return reservedDatesRepository.findAll();
    }

    public ReservedDates findReservedDatesByRoomId(Long id) {
        return reservedDatesRepository.findReservedDatesByRoomId(id);
    }
    
    public ReservedDates saveReservedDates(ReservedDates reservedDates) {
        return reservedDatesRepository.saveAndFlush(reservedDates);
    }
    
}
