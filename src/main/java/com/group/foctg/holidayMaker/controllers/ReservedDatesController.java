/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group.foctg.holidayMaker.controllers;

import com.group.foctg.holidayMaker.model.ReservedDates;
import com.group.foctg.holidayMaker.services.ReservedDatesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Chris
 */
@RestController
@RequestMapping(value = "/api")
public class ReservedDatesController {
    
    @Autowired
    private ReservedDatesService reservedDatesService;
    
    @PostMapping("/reserveddates")
    public ReservedDates saveReservedDatesService(ReservedDates reservedDates) {
        return reservedDatesService.saveReservedDates(reservedDates);
    }
    
    @GetMapping("/reserveddates")
    public List<ReservedDates> findAll() {
        return reservedDatesService.findAll();
    }
    
    @GetMapping("/reserveddates/byroom")
    public ReservedDates findReservedDatesByRoomId(@RequestParam Long id) {
        return reservedDatesService.findReservedDatesByRoomId(id);
    }
    
}
