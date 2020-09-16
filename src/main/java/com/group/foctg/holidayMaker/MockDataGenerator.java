package com.group.foctg.holidayMaker;

import com.group.foctg.holidayMaker.model.Accommodation;
import com.group.foctg.holidayMaker.model.Booking;
import com.group.foctg.holidayMaker.model.Customer;
import com.group.foctg.holidayMaker.model.Location;
import com.group.foctg.holidayMaker.model.Room;
import com.group.foctg.holidayMaker.services.AccommodationService;
import com.group.foctg.holidayMaker.services.BookingService;
import com.group.foctg.holidayMaker.services.CustomerService;
import com.group.foctg.holidayMaker.services.LocationService;
import com.group.foctg.holidayMaker.services.RoomService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author Christoffer Hansen
 */
@Component
public class MockDataGenerator implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(MockDataGenerator.class);

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccommodationService accommodationService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private LocationService locationService;

    @Override
    public void run(String... args) throws Exception {

        Location mockLocation1 = new Location("Mock_Location_1", new ArrayList<>());

        Customer mockCustomer1 = new Customer("mockEmail1@mock.io",
                "mock_password1", new ArrayList<>(), new ArrayList<>());
        Customer mockCustomer2 = new Customer("mockEmail2@mock.io",
                "mock_password2", new ArrayList<>(), new ArrayList<>());

        Accommodation mockAccommodation1 = new Accommodation(
                "Mock_accommodation_1",
                false, false, false, true,
                (short) 200, (short) 800, mockLocation1,
                "https://www.youtube.com/embed/dQw4w9WgXcQ?autoplay=1", "mock_Description",
                new ArrayList<>(), mockCustomer2);
        
        mockAccommodation1.setRating(0.5f);

        Room mockRoom1 = new Room((short) 2, new ArrayList<>(),mockAccommodation1, 258f, (short) 20);
        Room mockRoom2 = new Room((short) 3, new ArrayList<>(),mockAccommodation1, 380f, (short) 15);
        Room mockRoom3 = new Room((short) 1, new ArrayList<>(),mockAccommodation1, 800f, (short) 25);

        Booking mockBooking1 = new Booking(mockCustomer1,
                new ArrayList<>(Arrays.asList(mockRoom1)),
                "01/01/2020", "10/01/2020",
                (short) 2, (short) 0, true, false, false, (short) 0);
        Booking mockBooking2 = new Booking(mockCustomer1,
                new ArrayList<>(Arrays.asList(mockRoom2)),
                "11/01/2020", "20/01/2020",
                (short) 1, (short) 2, false, true, false, (short) 0);
        Booking mockBooking3 = new Booking(mockCustomer1,
                new ArrayList<>(Arrays.asList(mockRoom3)),
                "21/01/2020", "30/01/2020",
                (short) 1, (short) 0, false, false, true, (short) 1);

        mockLocation1.setAccommodation(new ArrayList<>(Arrays.asList(
                mockAccommodation1)));

        mockAccommodation1.setRooms(new ArrayList<>(Arrays.asList(
                mockRoom1, mockRoom2, mockRoom3)));

        mockCustomer2.setAccommodations(new ArrayList<>(Arrays.asList(
                mockAccommodation1)));

        mockCustomer1.setBookings(new ArrayList<>(Arrays.asList(
                mockBooking1, mockBooking2, mockBooking3)));
        
        mockRoom1.setBookings(new ArrayList<>(Arrays.asList(mockBooking1)));
        mockRoom2.setBookings(new ArrayList<>(Arrays.asList(mockBooking2)));
        mockRoom3.setBookings(new ArrayList<>(Arrays.asList(mockBooking3)));

        List<String[]> mockDatesTaken1 = new ArrayList<String[]>();

        mockDatesTaken1.add(new String[] { "01/01/2020", "10/01/2020" });
        mockDatesTaken1.add(new String[] { "01/02/2020", "10/02/2020" });
        
        mockRoom1.setDatesTaken(mockDatesTaken1);
        
        customerService.saveCustomer(mockCustomer1);
        customerService.saveCustomer(mockCustomer2);

        locationService.saveLocation(mockLocation1);

        accommodationService.saveAccommodation(mockAccommodation1);

        roomService.saveRoom(mockRoom1);
        roomService.saveRoom(mockRoom2);
        roomService.saveRoom(mockRoom3);

        bookingService.saveBooking(mockBooking1);
        bookingService.saveBooking(mockBooking2);
        bookingService.saveBooking(mockBooking3);

        customerService.findAll().forEach((cust) -> {
            LOGGER.info("{}", cust);
        });

        accommodationService.findAll().forEach((acc) -> {
            LOGGER.info("{}", acc);
        });

        locationService.findAll().forEach((loc) -> {
            LOGGER.info("{}", loc);
        });

//        roomService.findAll().forEach((cust) -> {
//            LOGGER.info("{}", cust);
//        });
//        
//        bookingService.findAll().forEach((cust) -> {
//            LOGGER.info("{}", cust);
//        });
    }
}
