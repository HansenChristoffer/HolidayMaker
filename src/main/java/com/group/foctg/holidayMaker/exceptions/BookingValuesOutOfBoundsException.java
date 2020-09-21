package com.group.foctg.holidayMaker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Christoffer
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookingValuesOutOfBoundsException extends RuntimeException {

    public BookingValuesOutOfBoundsException(short bedCapacity, short bedsNeeded) {
        super("The total needed beds exceeds the bed capacity = { bedNeeded : " + bedsNeeded + " > " + bedCapacity + " : bedCapacity }");
    }
}
