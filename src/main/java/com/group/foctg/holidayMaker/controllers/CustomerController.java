package com.group.foctg.holidayMaker.controllers;

import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Booking;
import com.group.foctg.holidayMaker.model.Customer;
import com.group.foctg.holidayMaker.services.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Christoffer Hansen <christoffer.hansen.hc@gmail.com>
 */

@RestController
@RequestMapping(value = "/api")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public boolean saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }
    
    @RequestMapping(value = "/customer", method = RequestMethod.DELETE)
    public boolean removeCustomer(@RequestParam Long id) {
        return customerService.removeCustomer(id);
    }
    
    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public Customer findCustomerById(@RequestParam Long id) {
        return customerService.getOne(id);
    }
    
    @RequestMapping(value = "/customer/by", method = RequestMethod.GET)
    public Customer findCustomerByEmail(@RequestParam String email) {
        return customerService.findCustomerByEmail(email);
    }
    
    @RequestMapping(value = "/customer/bookings", method = RequestMethod.GET)
    public List<Booking> findBookingsByCustomerId(@RequestParam Long id) {
        return customerService.findCustomersBookingsByCustomerID(id);
    }
    
    @RequestMapping(value = "/customer/accommodations", method = RequestMethod.GET)
    public List<Accommodation> findAccommodationsByCustomerId(@RequestParam Long id) {
        return customerService.findCustomersAccommodationsByCustomerID(id);
    }
    
    
}
