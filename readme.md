# REST SPECIFICATION

## Customer

**POST** "/api/customer" : Saves the JSON Customer Object passed as @RequestBody and returns boolean if successful.

**DELETE** "/api/customer" : Deletes the JSON Customer Object with the **customerId** that was passed as @RequestParam.

**GET** "/api/customer?customerid=" : Returns a JSON Customer Object with the **customerId** that was passed as @RequestParam.

**GET** "/api/customer/by?email=" : Returns a JSON Customer Object with the **email** that was passed as @RequestParam.

**GET** "/api/customer/bookings?customerid=" : Returns all the bookings that the Customer with the **customerId** that was passed as @RequestParam has.

**GET** "/api/customer/accommodations?customerid=" : Returns all the accommodations that the Customer with the **customerId** that was passed @RequestParam has.

## Room

**POST** "/api/room" : Saves the Room passed as JSON and returns boolean if successful.

**DELETE** "/api/room" : Deletes the JSON Room Object with the **roomId** that was passed as @RequestParam.

**PUT** "/api/room?roomid=" : Updates the room with passed **roomId** with the JSON Object that was passed through @RequestBody.

**GET** "/api/rooms" : Returns all rooms.

**GET** "/api/room?roomid=" : Returns a Room with the **roomId** that was passed as @RequestParam as a JSON Object.

**GET** "/api/room/accommodation?roomid=" : Returns an Accommodation with the **roomId** that was passed as @RequestParam as a JSON Object.

## Location

**POST** "/api/location" : Saves the Location passed as JSON and returns boolean if successful.

**DELETE** "/api/location" : Deletes the JSON Location Object with the **locationId** that was passed as @RequestParam.

**GET** "/api/locations" : Returns all locations.

**GET** "/api/location?locationid=" : Returns a Location with the **locationId** that was passed as @RequestParam as a JSON Object.

**GET** "/api/location/accommodations?locationid=" : Returns all accommodations at the location with the passed **locationId**.

## Booking

**POST** "/api/booking" : Saves the Booking passed as JSON and returns boolean if successful.

**DELETE** "/api/booking" : Deletes the JSON Booking Object with the **bookingId** that was passed as @RequestParam.

**PUT** "/api/booking?bookingid=" : Updates the booking with passed **bookingId** with the JSON Object that was passed through @RequestBody.

**GET** "/api/booking?customerid=" : Returns the bookings that is owned by the Customer with the passed **customerId**.

## Accommodation

**POST** "/api/accommodation" : Saves the Accommodation passed as JSON and returns boolean if successful.

**DELETE** "/api/accommodation" : Deletes the JSON Accommodation Object with the **accommodationId** that was passed as @RequestParam.

**PUT** "/api/accommodation?accommodationid=" : Updates the accommodation with passed **accommodationId** with the JSON Object that was passed through @RequestBody.

**GET** "/api/accommodations" : Returns all the accommodations.

**GET** "/api/accommodation?accommodationid=" : Returns the accommodation with the passed **accommodationId** as a JSON Object.

**GET** "/api/accommodation/customer?customerid=" : Returns the accommodations that is owned by a Customer with the passed **customerId**.

**GET** "/api/accommodation/tobeach?distance=" : Returns the accommodations that is within the passed **distance** to a beach.

**GET** "/api/accommodation/tocenter?distance=" : Returns the accommodations that is within the passed **distance** to a center.

**GET** "/api/accommodation/rating?value=" : Returns the accommodations that has the passed **value** in their rating.
