var user = JSON.parse(localStorage.getItem('user'));

fetch("http://localhost:8080/api/booking?id=" + user.id)
  .then(response => response.json())
  .then(function(data) {
    console.log(data);

    var leftContainer = document.getElementsByClassName('left-container')[0];

    for (var i = 0; i < data.length; i++) {

      var bookingContainer = document.createElement('div');
      bookingContainer.classList.add('booking-container');

      var resultBookingLeft = document.createElement('div');
      resultBookingLeft.classList.add("left-inner");

      var bookingId = document.createElement('p');
      bookingId.classList.add('style-p');
      bookingId.innerHTML = "Booking ID: " + data[i].id;

      var price = document.createElement('p');
      price.classList.add('style-p');
      price.innerHTML = "Cost: " + data[i].cost;

      var dateFrom = document.createElement('p');
      dateFrom.classList.add('style-p');
      dateFrom.innerHTML = "Date from: " + data[i].dateFrom;

      var dateTo = document.createElement('p');
      dateTo.classList.add('style-p');
      dateTo.innerHTML = "Date from: " + data[i].dateTo;

      var resultBookingRight = document.createElement('div');
      resultBookingRight.classList.add("right-inner");

      var rooms = document.createElement('p');
      rooms.classList.add('style-p');
      rooms.innerHTML = "Number of rooms: " + data[i].rooms;

      var adults = document.createElement('p');
      adults.classList.add('style-p');
      adults.innerHTML = "Number of adults: " + data[i].numberOfAdults;

      var kids = document.createElement('p');
      adults.classList.add('style-p');
      kids.innerHTML = "Number of kids: " + data[i].numberOfKids;

      var btnDiv = document.createElement('div');
      btnDiv.classList.add('buttons');

      var button1 = document.createElement('input');
      button1.setAttribute("type", "button");
      button1.setAttribute("value", "Edit booking");

      var button2 = document.createElement('input');

      button2.setAttribute("type", "button");
      button2.setAttribute("value", "Delete booking");

      btnDiv.appendChild(button1);
      btnDiv.appendChild(button2);

      resultBookingLeft.appendChild(bookingId);
      resultBookingLeft.appendChild(price);
      resultBookingLeft.appendChild(dateFrom);
      resultBookingLeft.appendChild(dateTo);

      resultBookingRight.appendChild(rooms);
      resultBookingRight.appendChild(adults);
      resultBookingRight.appendChild(kids);

      bookingContainer.appendChild(resultBookingLeft);
      bookingContainer.appendChild(resultBookingRight);
      bookingContainer.appendChild(btnDiv);

      leftContainer.appendChild(bookingContainer);

    }

  });

fetch("http://localhost:8080/api/accommodation/customer?id=" + user.id)
  .then(response => response.json())
  .then(function(data) {
    console.log(data);

    var rightContainer = document.getElementsByClassName('right-container')[0];

    for (var i = 0; i < data.length; i++) {

      var listingContainer = document.createElement('div');
      listingContainer.classList.add('listing-container');

      var resultListingLeft = document.createElement('div');
      resultListingLeft.classList.add('column-left');

      var listingId = document.createElement('p');
      listingId.classList.add('style-p');
      listingId.innerHTML = "Listing ID: " + data[i].id;

      var listingLocation = document.createElement('p');
      listingLocation.classList.add('style-p');
      listingLocation.innerHTML = "Location: " + data[i].location.name;

      var listingRooms = document.createElement('p');
      listingRooms.classList.add('style-p');
      listingRooms.innerHTML = "Number of rooms: " + data[i].rooms;

      var rating = document.createElement('p');
      rating.classList.add('style-p');
      rating.innerHTML = "Rating: " + data[i].rating;

      var resultListingRight = document.createElement('div');
      resultListingRight.classList.add('column-right');

      var pool = document.createElement('p');
      pool.classList.add('style-p');
      pool.innerHTML = "Pool: " + (data[i].pool ? 'Yes' : 'No')

      var beach = document.createElement('p');
      beach.classList.add('style-p');
      beach.innerHTML = "Distance to beach: " + data[i].distanceToBeach;

      var center = document.createElement('p');
      center.classList.add('style-p');
      center.innerHTML = "Distance to center: " + data[i].distanceToCenter;


      var btnDiv = document.createElement('div');
      btnDiv.classList.add('buttons');

      var listingBtn = document.createElement('input');
      listingBtn.setAttribute("type", "button");
      listingBtn.setAttribute("value", "Delete listing");

      btnDiv.appendChild(listingBtn);

      resultListingLeft.appendChild(listingId);
      resultListingLeft.appendChild(listingLocation);
      resultListingLeft.appendChild(listingRooms);
      resultListingLeft.appendChild(rating);

      resultListingRight.appendChild(pool);
      resultListingRight.appendChild(beach);
      resultListingRight.appendChild(center);

      listingContainer.appendChild(resultListingLeft);
      listingContainer.appendChild(resultListingRight);
      listingContainer.appendChild(btnDiv);

      rightContainer.appendChild(listingContainer);
    }
  });

function addListing() {
  document.getElementById("panel").style.display = "block";
}
