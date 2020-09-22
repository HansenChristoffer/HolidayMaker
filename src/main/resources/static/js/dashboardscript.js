fetch("http://localhost:8080/api/booking?id=3")
  .then(response => response.json())
  .then(function(data) {
    console.log(data);

    var bookingId = document.getElementById('booking-id');
    bookingId.innerHTML = "Booking ID " + data[0].booking_id;

    var price = document.getElementById('price')
    price.innerHTML = "Price " + data[0].price;

    //  var dateFrom = document.getElementById('date-from');
    //  dateFrom.innerHTML = "Date from " + data[0]

    //  var dateTo = document.getElementById('date-to');
    //  dateTo.innerHTML = "Date to " + data[0]

    var rooms = document.getElementById('rooms')
    rooms.innerHTML = "Number of rooms " + data[0].rooms;

    var adults = document.getElementById('adults')
    adults.innerHTML = "Number of adults " + data[0].number_of_adults;

    var kids = document.getElementById('kids')
    kids.innerHTML = "Number of kids " + data[0].number_of_kids;
  });

fetch("http://localhost:8080/api/accommodations")
  .then(response => response.json())
  .then(function(data) {
    console.log(data);

    var listingId = document.getElementById('listing-id');
    listingId.innerHTML = "Listing ID " + data[0].accommodation_id;

    var location = document.getElementById('location');
    listingId.innerHTML = "Location " + data[0].location_id;

    var listingRooms = document.getElementById('rooms');
    listingRooms.innerHTML = "Number of rooms " + data[0].rooms;

    var rating = document.getElementById('rating');
    rating.innerHTML= "Rating " + data[0].rating;

    var pool = document.getElementById('pool');
    pool.innerHTML= "Pool " + data[0].pool;

    var beach = document.getElementById('beach');
    beach.innerHTML= "Distance to beach " + data[0].distance_to_beach;

    var center = document.getElementById('center');
    center.innerHTML= "Distance to center " + data[0].distance_to_center;
  });
