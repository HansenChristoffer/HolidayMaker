const baseURL = "http://localhost:8080/api";
var roomsChecked = new Set();

document.addEventListener("DOMContentLoaded", startUp(), false);

async function startUp() {
  setViewData();
  setTableData();
}

async function setViewData() {
  var acc = JSON.parse(localStorage.getItem('selectAcc'));
  var response = await fetch(baseURL + "/accommodation?id=" + acc.id)
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

      var cr = Math.round(data.rating + 0.5);
      var ratingEleString = '';

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

async function setTableData() {
  let acc = JSON.parse(localStorage.getItem('selectAcc'))
  var response = await fetch(baseURL + "/filter/rooms/accommodation?id=" +
      acc.id + "&dateFrom=" +
      acc.dateFrom + "&dateTo=" +
      acc.dateTo)
    .then(response => response.json())
    .then(function(data) {
      populateTable(data);
    });
}

function populateTable(data) {
  var table = document.getElementById("table-rooms");
  data.forEach(function(object) {
    var tr = document.createElement("tr");
    tr.innerHTML = '<td> Room with ' + object.numberOfBeds +
      ' beds, <b>Price:</b> <span id=price-' + object.id + '>' + object.price.toFixed(2) + '</span>' +
      ':- SEK<label class="rooms-data-container">Choose<input id="' + object.id +
      '" type = "checkbox" data-toggle="tooltip" ' +
      'data-placement="right" title="Checkmark if you want to book this room" onClick="check(this)">' +
      '<span class = "checkmark"></span></label></td>';
    table.appendChild(tr);
  });
}

function check(element) {
  var bookButton = document.getElementById("bookBtn");
  var tableRoomPrice = document.getElementById("price-" + element.id);
  var totalCost = document.getElementById("totalCost");
  var currentTotalCost = parseFloat(totalCost.innerHTML.split(" ")[1]);

  if (element.checked) {
    totalCost.innerHTML = "<b>Cost:</b> " + (currentTotalCost + parseFloat(tableRoomPrice.innerHTML)).toFixed(2);
    roomsChecked.add(element.id);
  } else {
    totalCost.innerHTML = "<b>Cost:</b> " + (currentTotalCost - parseFloat(tableRoomPrice.innerHTML)).toFixed(2);
    roomsChecked.delete(element.id);
  }
}

function book() {
  let acc = JSON.parse(localStorage.getItem('selectAcc'));

  const data =
    ('{
      "customer": {
        "id": $ {
          acc.id
        }
      },
      "rooms": [{
        "id": 5
      }],
      "dateFrom": $ {
        acc.dateFrom
      },
      "dateTo": $ {
        acc.dateTo
      },
      "numberOfAdults": $ {
        acc.numberOfAdults
      },
      "numberOfKids": $ {
        acc.numberOfKids
      },
      "allInclusive": $ {
        acc.allInclusive
      },
      "fullBoard": $ {
        acc.fullBoard
      },
      "halfBoard": $ {
        acc.halfBoard
      },
      "extraBed": $ {
        acc.extraBed
      }
    }
  ');

  fetch(baseURL + '/booking', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data),
    })
    .then(response => response.json())
    .then(data => {
      console.log('Success:', data);
    })
    .catch((error) => {
      console.error('Error:', error);
    });
}

function getCheckedRooms() {
  var retStr = '';

  for (room of roomsChecked) {

  }
}