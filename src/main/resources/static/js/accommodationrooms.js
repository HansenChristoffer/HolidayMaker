document.addEventListener("DOMContentLoaded", startUp(), false);

async function startUp() {
  setViewData();
  //getData();
}

/*

   Json.parse(localStorage.getItem('accId'))
   <span class="fa fa-star checked"></span>
   <span class="fa fa-star checked"></span>
   <span class="fa fa-star checked"></span>
   <span class="fa fa-star"></span>
   <span class="fa fa-star"></span>
 */

async function setViewData() {
  var baseURL = "http://localhost:8080/api";
  let response = await fetch(baseURL + "/accommodation?id=11")
    .then(response => response.json())
    .then(function(data) {

      let header = document.getElementById("accommodation-header");
      let imgElement = document.getElementById("accommodation-img");
      let descriptionElement = document.getElementById("accommodation-description");
      let ratingElement = document.getElementById("rating");
      let hasPool = document.getElementById("hasPool");
      let hasRestaurant = document.getElementById("hasRestaurant");
      let hasChildEvents = document.getElementById("hasChildEvents");
      let hasEntertainment = document.getElementById("hasEntertainment");
      let distanceBeach = document.getElementById("distanceBeach");
      let distanceCenter = document.getElementById("distanceCenter");

      let cr = Math.round(data.rating + 0.5);
      let ratingEleString = '';

      for (var i = 0; i < cr; i++) {
        ratingEleString = ratingEleString.concat('<span class="fa fa-star checked"></span>');
      }

      for (var i = 0; i < (5 - cr); i++) {
        ratingEleString = ratingEleString.concat('<span class="fa fa-star"></span>');
      }

      header.innerHTML = data.name;
      imgElement.setAttribute("src", data.imageURL);
      descriptionElement.innerHTML = data.description;
      ratingElement.innerHTML = ratingEleString;

      hasPool.innerHTML = (data.pool) ? "Yes" : "No";
      hasRestaurant.innerHTML = (data.restaurant) ? "Yes" : "No";
      hasChildEvents.innerHTML = (data.childEvents) ? "Yes" : "No";
      hasEntertainment.innerHTML = (data.nightEntertainment) ? "Yes" : "No";
      distanceBeach.innerHTML = data.distanceToBeach;
      distanceCenter.innerHTML = data.distanceToCenter;

    });
}

async function getData() {
  //var baseURL = "http://localhost:8080/api";
  var response = await fetch(baseURL + "/filter/rooms/accommodation?id=" +
      Json.parse(localStorage.getItem('accId')) + "&dateFrom=" +
      Json.parse(localStorage.getItem('dateFrom')) + "&dateTo=" +
      Json.parse(localStorage.getItem('dateTo')))
    .then(response => response.json())
    .then(function(data) {
      populateTableWithJson(data);
    });
}

function populateTableWithJson(data) {
  /*
  Populate table with data.
  Has not been decided on WHAT to show yet
  */
  var table = document.getElementById("table-rooms");
  data.forEach(function(object) {
    var tr = document.createElement("tr");
    tr.innerHTML = '<td> Room with ' + object.numberOfBeds +
      ' beds, Price: ' + object.price +
      '<label class="rooms-data-container">Choose<input id="rcm-' + object.id +
      '"type = "checkbox" data-toggle="tooltip" ' +
      'data-placement="right" title="Checkmark if you want to book this room">' +
      '<span class = "checkmark"></span></label></td>';
    table.appendChild(tr);
  });
}