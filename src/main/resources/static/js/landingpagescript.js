function openLogin() {
  document.getElementById("formCover").style.display = "block";
  document.getElementById("loginForm").style.display = "flex";
}

function closeLogin() {
  document.getElementById("formCover").style.display = "none";
  document.getElementById("loginForm").style.display = "none";
}

function openReg() {
  document.getElementById("formCover").style.display = "block";
  document.getElementById("regForm").style.display = "flex";
}

function closeReg() {
  document.getElementById("formCover").style.display = "none";
  document.getElementById("regForm").style.display = "none";
}

fetch("http://localhost:8080/api/accommodations")
    .then(response => response.json())
    .then(function(data) {
        console.log(data);
        /*Result container */
        /*<div class="resultItem">
                <div class="itemImg"></div>
                <p class="itemTitle">Title</p>
                <p class="itemRooms">Rooms</p>
                <div class="rowPairContainer">
                    <p class="itemPool halfContainer">Pool</p>
                    <p class="itemChildren halfContainer">Children Activities</p>
                </div>

                <div class="rowPairContainer">
                    <p class="itemEntertainment halfContainer">Entertainment</p>
                    <p class="itemRestaurant halfContainer">Restaurant</p>
                </div>
                <p class="itemDesc">Desc</p>
                <input class="submit" type="button" value="Book Now!" />
            </div>
         */
         
         
         var resultContainer = document.getElementsByClassName('resultsContainer')[0];
         
         for (var i = 0; i < data.length; i++) {
          
            var resultItem = document.createElement('div');
            resultItem.classList.add("resultItem");
            
            var itemImg = document.createElement('div');
            itemImg.classList.add("itemImg");
            
            var itemTitle = document.createElement('p');
            itemTitle.classList.add('itemTitle');
            itemTitle.innerHTML = data[i].name;
            
            var itemRooms = document.createElement('p');
            itemRooms.classList.add('itemRooms');
            itemRooms.innerHTML = data[i].rooms.length + " rooms";
            
            var rowPairContainer1 = document.createElement('div');
            rowPairContainer1.classList.add("rowPairContainer");
            
            var rowPairContainer2 = document.createElement('div');
            rowPairContainer2.classList.add("rowPairContainer");
            
            var itemPool = document.createElement('p');
            itemPool.classList.add('itemPool');
            itemPool.classList.add('halfContainer');
            itemPool.innerHTML = (data[i].pool ? 'Pool' : 'No Pool');
            
            var itemChildren = document.createElement('p');
            itemChildren.classList.add('itemChildren');
            itemChildren.classList.add('halfContainer');
            itemChildren.innerHTML = (data[i].childEvents ? 'Children Activities' : 'No Children Activities');
            
            var itemEntertainment = document.createElement('p');
            itemEntertainment.classList.add('itemEntertainment');
            itemEntertainment.classList.add('halfContainer');
            itemEntertainment.innerHTML = (data[i].nightEntertainment ? 'Entertainment' : 'No Entertainment');
            
            var itemRestaurant = document.createElement('p');
            itemRestaurant.classList.add('itemRestaurant');
            itemRestaurant.classList.add('halfContainer');
            itemRestaurant.innerHTML = (data[i].restaurant ? 'Restaurant' : 'No Restaurant');
            
            var itemDesc = document.createElement('p');
            itemDesc.classList.add('itemDesc');
            itemDesc.innerHTML = data[i].description;
            
            var button = document.createElement('input');
            button.setAttribute("type", "button");
            button.setAttribute("value", "Book Now!");
            
            rowPairContainer1.appendChild(itemPool);
            rowPairContainer1.appendChild(itemChildren);
            
            
            rowPairContainer2.appendChild(itemEntertainment);
            rowPairContainer2.appendChild(itemRestaurant);
     
            
            resultItem.appendChild(itemImg);
            resultItem.appendChild(itemTitle);
            resultItem.appendChild(itemRooms);
            resultItem.appendChild(rowPairContainer1);
            resultItem.appendChild(rowPairContainer2);
            resultItem.appendChild(itemDesc);
            resultItem.appendChild(button);
            
            resultContainer.appendChild(resultItem);
         }
    });

fetch("http://localhost:8080/api/locations")
    .then(response => response.json())
    .then(function(data) {
       var locationSelector = document.getElementById('locationSelector');
       for (var i = 0; i < data.length; i++) {
           var option = document.createElement("option");
           option.text = data[i].name;
           locationSelector.add(option);
       }
       
       var adultsSelector = document.getElementById('adultsSelector');
       for (var i = 1; i <= 50; i++) {
           var option = document.createElement("option");
           option.text = i;
           adultsSelector.add(option);
       }
       
       
       var kidsSelector = document.getElementById('kidsSelector');
       for (var i = 1; i <= 50; i++) {
           var option = document.createElement("option");
           option.text = i;
           kidsSelector.add(option);
       }
       
       var roomsSelector = document.getElementById('roomsSelector');
       for (var i = 1; i <= 50; i++) {
           var option = document.createElement("option");
           option.text = i;
           roomsSelector.add(option);
       }
       
       var packageSelector = document.getElementById('packageSelector');
       var full = document.createElement("option");
       full.text = "Full Board";
       
       var half = document.createElement("option");
       half.text = "Half Board";
       
       var all = document.createElement("option");
       all.text = "All Inclusive";
       
       packageSelector.add(all);
       packageSelector.add(full);
       packageSelector.add(half);
       
       var centerSelector = document.getElementById('centerSelector');
       for (var i = 500; i <= 5000; i += 500) {
           var option = document.createElement("option");
           option.text = '<' + i + 'm';
           centerSelector.add(option);
       }
       
       var beachSelector = document.getElementById('beachSelector');
       for (var i = 500; i <= 5000; i += 500) {
           var option = document.createElement("option");
           option.text = '<' + i + 'm';
           beachSelector.add(option);
       }
       
    });