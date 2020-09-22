document.addEventListener("DOMContentLoaded", getData(), false);

async function getData() {
  let baseURL = "http://localhost:8080/api";
  let id = 4; /* get this from selection from past page */
  let dateFrom = "05/04/2020"; /* get this from selection from past page */
  let dateTo = "15/04/2020"; /* get this from selection from past page */
  let response = await fetch(baseURL + "/filter/rooms/accommodation?id=" + id + "&dateFrom=" + dateFrom + "&dateTo=" + dateTo)
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