fetch("http://localhost:8080/api/booking?id=3")
  .then(response => response.json())
  .then(function(data) {
    console.log(data);

    for (var i = 0; i < data.length; i++) {

      var bookingId = document.getElementById('booking-id');
      bookingId.innerHTML = "Booking ID " + data[i].booking_id;

      var price = document.getElementById('price')
      price.innerHTML = "Price " + data[i].price;

      //  var dateFrom = document.getElementById('date-from');
      //  dateFrom.innerHTML = "Date from " + data[0]

      //  var dateTo = document.getElementById('date-to');
      //  dateTo.innerHTML = "Date to " + data[0]

      var rooms = document.getElementById('rooms')
      rooms.innerHTML = "Number of rooms " + data[i].rooms;

      var adults = document.getElementById('adults')
      adults.innerHTML = "Number of adults " + data[i].number_of_adults;

      var kids = document.getElementById('kids')
      kids.innerHTML = "Number of kids " + data[i].number_of_kids;
    }

  });

fetch("http://localhost:8080/api/accommodations")
  .then(response => response.json())
  .then(function(data) {
    console.log(data);

    for (var i = 0; i < data.length; i++) {

      var listingId = document.getElementById('listing-id');
      listingId.innerHTML = "Listing ID " + data[i].accommodation_id;

      var location = document.getElementById('location');
      listingId.innerHTML = "Location " + data[i].location_id;

      var listingRooms = document.getElementById('rooms');
      listingRooms.innerHTML = "Number of rooms " + data[i].rooms;

      var rating = document.getElementById('rating');
      rating.innerHTML = "Rating " + data[i].rating;

      var pool = document.getElementById('pool');
      pool.innerHTML = "Pool " + data[i].pool;

      var beach = document.getElementById('beach');
      beach.innerHTML = "Distance to beach " + data[i].distance_to_beach;

      var center = document.getElementById('center');
      center.innerHTML = "Distance to center " + data[i].distance_to_center;
    }
  });

function addListing() {
  document.getElementById("panel").style.display = "block";
}
