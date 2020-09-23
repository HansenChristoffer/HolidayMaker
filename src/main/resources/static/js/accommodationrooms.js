document.addEventListener("DOMContentLoaded", startUp(), false);

async function startUp() {
  setViewData();

}

/*
+
   Json.parse(localStorage.getItem('accId'))
 */

async function setViewData() {
  let baseURL = "http://localhost:8080/api";
  let response = await fetch(baseURL + "/accommodation?id=11")
    .then(response => response.json())
    .then(function(data) {

      var header = document.getElementById("accommodation-header");
      var imgElement = document.getElementById("accommodation-img");
      var descriptionElement = document.getElementById("accommodation-description");
      var ratingElement = document.getElementById("rating");
      var hasPool = document.getElementById("hasPool");
      var hasRestaurant = document.getElementById("hasRestaurant");
      var hasChildEvents = document.getElementById("hasChildEvents");
      var hasEntertainment = document.getElementById("hasEntertainment");
      var distanceBeach = document.getElementById("distanceBeach");
      var distanceCenter = document.getElementById("distanceCenter");

      header.innerHTML = data.name;
      imgElement.setAttribute("src", data.imageURL);
      descriptionElement.innerHTML = data.description;
      ratingElement.innerHTML = "Rating " + data.rating + " / 5";

      hasPool.innerHTML = data.pool;
      hasRestaurant.innerHTML = data.restaurant;
      hasChildEvents.innerHTML = data.childEvents;
      hasEntertainment.innerHTML = data.nightEntertainment;
      distanceBeach.innerHTML = data.distanceToBeach;
      distanceCenter.innerHTML = data.distanceToCenter;

    });
}

async function getData() {
  let baseURL = "http://localhost:8080/api";
  let response = await fetch(baseURL + "/filter/rooms/accommodation?id=" +
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
    tr.innerHTML = '<td> id:' + object.id +
      ' numBeds: ' + object.numberOfBeds +
      ' price: ' + object.price +
      '<button class="btn-book">Book</button></td>';
    table.appendChild(tr);
  });
}