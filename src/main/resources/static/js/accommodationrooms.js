checkLoginTime();
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
      asc = false;
      populateTable(data);
    });
}

function populateTable(data) {
  var table = document.getElementById("table-rooms");
  table.innerHTML = "";
  table.innerHTML = '<tr><th onclick="">Room</th><th onclick="sortTable()">Price</th></tr>';

  console.log(table.rows.length);

  data.forEach(function(object) {
    var tr = document.createElement("tr");
    tr.setAttribute("id", ("TR-" + table.rows.length));
    tr.innerHTML = '<td> Room with ' + object.numberOfBeds +
      ' beds <label class="rooms-data-container">Choose<input id="' +
      object.id + '" type = "checkbox" onClick="check(this)"><span class = "checkmark"></span></label></td>' +
      '<td><span id=price-' + object.id + '>' + object.price.toFixed(2) + '</span>' +
      '</td>';
    table.appendChild(tr);
    console.log(table.rows.length);
  });
}

function check(element) {
  var bookButton = document.getElementById("bookBtn");
  var tableRoomPrice = document.getElementById("price-" + element.id);
  var totalCostParagraph = document.getElementById("totalCostParagraph");
  var currentTotalCost = parseFloat(totalCostParagraph.innerHTML.split(" ")[1]);

  if (element.checked) {
    totalCostParagraph.innerHTML = "<b>Cost:</b> " + (currentTotalCost + parseFloat(tableRoomPrice.innerHTML)).toFixed(2) + ":- SEK";
    roomsChecked.add(element.id);
  } else {
    totalCostParagraph.innerHTML = "<b>Cost:</b> " + (currentTotalCost - parseFloat(tableRoomPrice.innerHTML)).toFixed(2) + ":- SEK";
    roomsChecked.delete(element.id);
  }

  if (roomsChecked.size > 0) {
    bookButton.disabled = false;
  } else {
    bookButton.disabled = true;
  }
}

function addExtraBed() {
  var totalCostParagraph = document.getElementById("totalCostParagraph");
  var currentTotalCost = parseFloat(totalCostParagraph.innerHTML.split(" ")[1]);
  var checkboxExtraBed = document.getElementById("checkbox-extrabed");

  if (checkboxExtraBed.checked) {
    totalCostParagraph.innerHTML = "<b>Cost:</b> " + (currentTotalCost + 200.0) + ":- SEK";
  } else {
    totalCostParagraph.innerHTML = "<b>Cost:</b> " + (currentTotalCost - 200.0) + ":- SEK";
  }
}

function getCheckedRooms() {
  var retStr = '"rooms": [';

  for (room of roomsChecked) {
    retStr += `{"id": ${room} },`;
  }

  retStr = retStr.substr(0, (retStr.length - 1));
  retStr += "],";

  return retStr;
}

async function book() {
  var acc = JSON.parse(localStorage.getItem('selectAcc'));
  var usr = JSON.parse(localStorage.getItem('user'));
  var hasExtraBed = document.getElementById("checkbox-extrabed");

  var packageList = [false, false, false];

  if (acc.package == "All Inclusive") {
    packageList[0] = true;
  } else if (acc.package == "Fullboard") {
    packageList[1] = true;
  } else {
    packageList[2] = true;
  }

  var data = {
    customer: {
      id: usr.id
    },
    rooms: [],
    dateFrom: acc.dateFrom,
    dateTo: acc.dateTo,
    numberOfAdults: 1,
    numberOfKids: 1,
    allInclusive: packageList[0],
    fullBoard: packageList[1],
    halfBoard: packageList[2],
    extraBed: hasExtraBed.checked
  };

  for (room of roomsChecked) {
    data.rooms.push({
      id: room
    });

    removeChecked()
  }

  await fetch(baseURL + "/booking", {
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

function removeChecked() {
  var table = document.getElementById("table-rooms");

  console.log(roomsChecked);
  for (room of roomsChecked) {
    console.log(room);
    table.deleteRow(room);
  }
}

// Sorting for the table -->
let bubbleSortAsc = (inputArr) => {
  let len = inputArr.length;
  for (let i = 0; i < len; i++) {
    for (let j = 0; j < len - 1; j++) {
      if (inputArr[j].price > inputArr[j + 1].price) {
        let tmp = inputArr[j];
        inputArr[j] = inputArr[j + 1];
        inputArr[j + 1] = tmp;
      }
    }
  }
  return inputArr;
};

let bubbleSortDesc = (inputArr) => {
  let len = inputArr.length;
  for (let i = 0; i < len; i++) {
    for (let j = 0; j < len - 1; j++) {
      if (inputArr[j].price < inputArr[j + 1].price) {
        let tmp = inputArr[j];
        inputArr[j] = inputArr[j + 1];
        inputArr[j + 1] = tmp;
      }
    }
  }
  return inputArr;
};

function sortTable() {
  if (asc) {
    populateTable(bubbleSortDesc(tableData));
    asc = false;
  } else {
    populateTable(bubbleSortAsc(tableData));
    asc = true;
  }
}