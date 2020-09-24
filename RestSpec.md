# REST SPECIFICATION

## Customer

**POST** "/api/customer" : Saves the JSON Customer Object passed as @RequestBody and returns boolean if successful.

**DELETE** "/api/customer?id=" : Deletes the JSON Customer Object with the **id** that was passed as @RequestParam.

**GET** "/api/login?email=&password= Returns a JSON user object with the **login** that was passed as @RequestParam 

**GET** "/api/customers": Returns all customers.

**GET** "/api/booking/customer?id=" : Returns a JSON Customer Object with the **customerId** that was passed as @RequestParam.

**GET** "/api/customer/by?email=" : Returns a JSON Customer Object with the **email** that was passed as @RequestParam.

**GET** "/api/customer/bookings?id=" : Returns all the bookings that the Customer with the **customerId** that was passed as @RequestParam has.

**GET** "/api/customer/accommodations?id=" : Returns all the accommodations that the Customer with the **customerId** that was passed @RequestParam has.

## Room

**POST** "/api/room" : Saves the Room passed as JSON and returns boolean if successful.

**DELETE** "/api/room" : Deletes the JSON Room Object with the **id** that was passed as @RequestParam.

**PUT** "/api/room?id=" : Updates the room with passed **id** with the JSON Object that was passed through @RequestBody.

**GET** "/api/rooms" : Returns all rooms.

**GET** "/api/room?id=" : Returns a Room with the **id** that was passed as @RequestParam as a JSON Object.

**GET** "/api/room/accommodation?id=" : Returns an Accommodation with the **id** that was passed as @RequestParam as a JSON Object.

**GET** "/api/rooms/accommodation?id=" : Returns all Accommodations with the **id** that was passed as @RequestParam as a JSON Object.

**GET** "/api/filter/rooms/accommodation?id=&dateFrom=&dateTo=" 


## Location

**POST** "/api/location" : Saves the Location passed as JSON and returns boolean if successful.

**DELETE** "/api/location?id=" : Deletes the JSON Location Object with the **id** that was passed as @RequestParam.

**GET** "/api/locations" : Returns all locations.

**GET** "/api/location?id=" : Returns a Location with the **id** that was passed as @RequestParam as a JSON Object.

**GET** "/api/location/accommodations?id=" : Returns all accommodations at the location with the passed **id**.

## Booking

**POST** "/api/booking" : Saves the Booking passed as JSON and returns boolean if successful.

**DELETE** "/api/booking" : Deletes the JSON Booking Object with the **id** that was passed as @RequestParam.

**PUT** "/api/booking?id=" : Updates the booking with passed **id** with the JSON Object that was passed through @RequestBody.

**GET** "/api/booking?id=" : Returns the bookings that is owned by the Customer with the passed **id**.

## Accommodation

**POST** "/api/accommodation" : Saves the Accommodation passed as JSON and returns boolean if successful.

**DELETE** "/api/accommodation" : Deletes the JSON Accommodation Object with the **id** that was passed as @RequestParam.

**PUT** "/api/accommodation?id=" : Updates the accommodation with passed **id** with the JSON Object that was passed through @RequestBody.

**GET** "/api/accommodations" : Returns all the accommodations.

**GET** "/api/accommodation?id=" : Returns the accommodation with the passed **id** as a JSON Object.

**GET** "/api/accommodation/customer?id=" : Returns the accommodations that is owned by a Customer with the passed **id**.

**GET** "/api/accommodation/tobeach?distance=" : Returns the accommodations that is within the passed **distance** to a beach.

**GET** "/api/accommodation/tocenter?distance=" : Returns the accommodations that is within the passed **distance** to a center.

**GET** "/api/accommodation/rating?value=" : Returns the accommodations that has the passed **rating** in their rating.

**GET** "/api/accommodation/filter?location=&dateFrom=&dateTo=&pool=&childrenClub=&restaurant=&nightEntertainment=&rooms=&adults=&kids=&distToBeach=&distToCenter=" : returns all accommodations that matches the filter-criteria
