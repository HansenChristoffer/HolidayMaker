/*
 * Copyright 2020-2030 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.group.foctg.holidayMaker.services;

import com.group.foctg.holidayMaker.exceptions.BookingNotFoundException;
import com.group.foctg.holidayMaker.exceptions.BookingValuesOutOfBoundsException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.group.foctg.holidayMaker.model.Booking;
import com.group.foctg.holidayMaker.model.ReservedDates;
import com.group.foctg.holidayMaker.model.Room;
import com.group.foctg.holidayMaker.repositories.BookingRepository;

/**
 * Service class for the {@link com.group.foctg.holidayMaker.model.Booking}
 * column and entity. Autowires the repository.
 *
 * @author Frida Ek
 *
 * @see com.group.foctg.holidayMaker.repositories.BookingRepository
 */
@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomService roomService;

    @Autowired
    private ReservedDatesService reservedDatesService;

    /**
     * Saves the {@link com.group.foctg.holidayMaker.model.Booking} object from
     * parameter in the database.
     *
     * @param booking {@link com.group.foctg.holidayMaker.model.Booking} object
     * that shall be saved.
     * @return A boolean value representing whether the saving was successful or
     * not.
     */
    public boolean saveBooking(Booking booking) {
        boolean safeToSave = true;
        short totalBedsNeeded = (short) (booking.getNumberOfAdults() + booking.getNumberOfKids() + (booking.getExtraBed() ? 1 : 0));
        short totalBedCapacity = 0;

        if (booking.getAllInclusive()) {
            booking.setCost(booking.getCost() + 3000.0f);
            booking.setFullBoard(false);
            booking.setHalfBoard(false);
        } else if (booking.getFullBoard()) {
            booking.setCost(booking.getCost() + 1500.0f);
            booking.setAllInclusive(false);
            booking.setHalfBoard(false);
        } else {
            booking.setCost(booking.getCost() + 500.0f);
            booking.setAllInclusive(false);
            booking.setFullBoard(false);
            booking.setHalfBoard(true);
        }

        for (Room r : booking.getRooms()) {
            Room room = roomService.findById(r.getId()).get();
            booking.setCost(booking.getCost() + room.getPrice());
            totalBedCapacity += room.getNumberOfBeds();
        }

        if (totalBedCapacity < totalBedsNeeded) {
            throw new BookingValuesOutOfBoundsException(totalBedCapacity, totalBedsNeeded);
        } else {
            for (Room r : booking.getRooms()) {
                if (reservedDatesService.roomExistsById(r.getId())) {
                    for (ReservedDates rd : reservedDatesService.findReservedDatesByRoomId(r.getId())) {
                        if (rd.isOverlapping(booking.getDateFrom(), booking.getDateTo())) {
                            safeToSave = false;
                        } else {
                            booking.setReservedDates(new ReservedDates(booking.getDateFrom(), booking.getDateTo(), r, booking));
                        }
                    }
                } else {
                    booking.setReservedDates(new ReservedDates(booking.getDateFrom(), booking.getDateTo(), r, booking));
                }
            }

            if (safeToSave) {
                return bookingRepository.saveAndFlush(booking).equals(booking);
            }
        }
        return false;
    }

    /**
     * Removes the {@link com.group.foctg.holidayMaker.model.Booking} object
     * with the same <code>id</code> as the parameter from the database.
     *
     * @param id Long value used for finding and removing
     * {@link com.group.foctg.holidayMaker.model.Booking} with that
     * <code>id</code>
     * @return A boolean value representing whether the removing was successful
     * or not.
     */
    public boolean removeBooking(Long id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
            return true;
        } else {
            throw new BookingNotFoundException(id);
        }
    }

    /**
     * If there is a Booking object already that has the same id as the
     * {@link com.group.foctg.holidayMaker.model.Booking} passed as parameter
     * then it'll update the existing object. If object does not exist then it
     * throws BookingNotFoundException(Long)
     *
     * @param booking {@link com.group.foctg.holidayMaker.model.Booking} object
     * passed for updating or saving.
     * @param id
     * @return A Booking object representing the new Booking
     */
    public Booking updateBooking(Booking booking, Long id) {
        return bookingRepository.findById(id)
                .map(bkn -> {
                    bkn.setAllInclusive(booking.getAllInclusive());
                    bkn.setFullBoard(booking.getFullBoard());
                    bkn.setHalfBoard(booking.getHalfBoard());
                    bkn.setExtraBed(booking.getExtraBed());
                    return bookingRepository.save(bkn);
                })
                .orElseGet(() -> {
                    throw new BookingNotFoundException(id);
                });
    }

    /**
     * Goes through the database, checks and returns all
     * {@link com.group.foctg.holidayMaker.model.Booking} objects in the
     * List&lt;{@link com.group.foctg.holidayMaker.model.Booking}&gt; if a
     * customer with given <code>id</code> exists.
     *
     * @param id Long value to use for finding the
     * {@link com.group.foctg.holidayMaker.model.Customer}
     * @return List&lt;{@link com.group.foctg.holidayMaker.model.Booking}&gt;
     * from {@link com.group.foctg.holidayMaker.model.Customer} with the given
     * <code>id</code>, if it exists
     */
    public List<Booking> findBookingsByCustomerId(Long id) {
        return bookingRepository.findBookingsByCustomerID(id);
    }
}
