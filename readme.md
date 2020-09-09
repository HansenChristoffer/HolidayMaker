# REST SPECIFICATION

## User

**POST** "/api/user" : Saves the JSON User Object passed as @RequestBody and returns boolean if successful.

**DELETE** "/api/user" : Deletes the JSON User Object passed as @RequestBody and returns boolean if successful.

**GET** "/api/user?userid=" : Returns a JSON User Object with the **userId** that was passed as @RequestParam.

**GET** "/api/user?email=" : Returns a JSON User Object with the **email** that was passed as @RequestParam.

**GET** "/api/user/bookings?userid=" : Returns all the bookings that the User with the **userId** that was passed @RequestParam has.

**GET** "/api/user/accommodations?userid=" : Returns all the bookings that the User with the **userId** that was passed @RequestParam has.

## Room

**POST** "/api/room" : Saves the Room passed as JSON and returns boolean if successful.

**DELETE** "/api/room" : Deletes the Room passed as JSON and returns boolean if successful.

**PUT** "/api/room?roomid=" : Updates the room with passed **roomId** with the JSON Object that was passed through @RequestBody.

**GET** "/api/rooms" : Returns all Rooms as JSON objects.

**GET** "/api/room?roomid=" : Returns a User with the **roomId** that was passed as @RequestParam as a JSON Object.

**GET** "/api/room/accommodation?roomid=" : Returns a Accommodation  with the **roomId** that was passed as @RequestParam as a JSON Object.

**GET** "/api/room/datesavailable?roomid=" : Returns all the available dates that the Room with the given **roomId** is free.

## Location

**POST** "/api/location" : Saves the Location passed as JSON and returns boolean if successful.

**DELETE** "/api/location" : Deletes the Location passed as JSON and returns boolean if successful.

**GET** "/api/locations" : Returns all locations as JSON objects.

**GET** "/api/location?locationid=" : Returns a Location with the **locationId** that was passed as @RequestParam as a JSON Object.

**GET** "/api/location/accommodations?locationid=" : Returns all accommodations at the location with the passed **locationId**.

## Booking

**POST** "/api/booking" : Saves the Booking passed as JSON and returns boolean if successful.

**DELETE** "/api/booking" : Deletes the Booking passed as JSON and returns boolean if successful.

**PUT** "/api/booking?bookingid=" : Updates the booking with passed **bookingId** with the JSON Object that was passed through @RequestBody.

**GET** "/api/booking?userid=" : Returns the bookings that is owned by the User with the passed **userId**.

## Accommodation

**POST** "/api/accommodation" : Saves the Accommodation passed as JSON and returns boolean if successful.

**DELETE** "/api/accommodation" : Deletes the Accommodation passed as JSON and returns boolean if successful.

**PUT** "/api/accommodation?accommodationid=" : Updates the accommodation with passed **accommodationId** with the JSON Object that was passed through @RequestBody.

**GET** "/api/accommodations" : Returns all the accommodations.

**GET** "/api/accommodation?accommodationid=" : Returns the accommodation with the passed **accommodationId** as a JSON Object.

**GET** "/api/accommodation/user?userid=" : Returns the accommodations that is owned by a User with the passed **userId**.

**GET** "/api/accommodation/pool?has=" : Returns the accommodations that has a pool or not (True/False) depending on what was passed as **has**.

**GET** "/api/accommodation/entertainment?has=" : Returns the accommodations that has a entertainment or not (True/False) depending on what was passed as **has**.

**GET** "/api/accommodation/childevent?has=" : Returns the accommodations that has a child events or not (True/False) depending on what was passed as **has**.

**GET** "/api/accommodation/tobeach?km=" : Returns the accommodations that is within the passed **km** distance to a beach.

**GET** "/api/accommodation/tocenter?km=" : Returns the accommodations that is within the passed **km** distance to a center.

**GET** "/api/accommodation/rating?value=" : Returns the accommodations that has the passed **value** in their rating.
