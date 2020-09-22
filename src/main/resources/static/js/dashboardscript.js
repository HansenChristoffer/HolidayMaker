fetch("http://localhost:8080/api/booking?id=6")
  .then(response => response.json())
  .then(function(data) {
    console.log(data);

    var bookingId = document.getElementById('booking-id');
    bookingId.innerHTML = data[0].booking_id;

    //  var dateFrom = document.getElementById('date-from');
    //  dateFrom.innerHTML = data[0]

    //  var rooms = document.getElementById('rooms')
    //  rooms.innerHTML = data[0]

    //  var adults = document.getElementById('adults')
    //  adults.innerHTML = data[0].
  });
