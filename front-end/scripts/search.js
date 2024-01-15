
function updateSliderLabel(value) {
    document.getElementById("sliderLabel").textContent = `Up to ${value}€`;
}

function resetFilters(){

  if(document.getElementById('smallerdevicesfilter').style.display == "none"){
    document.getElementById("dep-dropdown").value ="";
    document.getElementById("arr-dropdown").value ="";
    document.getElementById("agency-dropdown").value ="";
    document.getElementById("datepicker-ret").value ="";
    document.getElementById("datepicker-fly").value ="";
    const val = document.getElementsByClassName("slider")[0].value="";
    updateSliderLabel(val);
  }
  else{
    document.getElementById("dep-dropdown1").value ="";
    document.getElementById("arr-dropdown1").value ="";
    document.getElementById("agency-dropdown1").value ="";
    document.getElementById("datepicker-ret1").value ="";
    document.getElementById("datepicker-fly1").value ="";
    
  }
  const val = document.getElementsByClassName("slider")[0].value="";
    updateSliderLabel(val);



  

}


function getSelectedValue() {
    const radioButtons = document.querySelectorAll('input[name="location"]:checked');

    if (radioButtons.length > 0) {
      const selectedValue = radioButtons[0].value;
      return selectedValue;
    } else {
    }  
}

function searchExcursion(){
  let departureLocation ;
  let arrivalLocation ;
  let agencyId ;
  let endDate ;
  let startDate;

  if(document.getElementById('smallerdevicesfilter').style.display == "none"){
    departureLocation =  document.getElementById("dep-dropdown").value;
    arrivalLocation = document.getElementById("arr-dropdown").value;
    agencyId = document.getElementById("agency-dropdown").value;
    endDate = document.getElementById("datepicker-ret").value;
    startDate = document.getElementById("datepicker-fly").value;
  }else{
    departureLocation =  document.getElementById("dep-dropdown1").value;
    arrivalLocation = document.getElementById("arr-dropdown1").value;
    agencyId = document.getElementById("agency-dropdown1").value;
    endDate = document.getElementById("datepicker-ret1").value;
    startDate = document.getElementById("datepicker-fly1").value;
  }
  

  getAllExcursions(departureLocation, arrivalLocation,startDate,endDate,agencyId)

}


function getAllExcursions(departureLocation, arrivalLocation,startDate,endDate,agencyId){


console.log(`http://localhost:8080/allExcursions?departureLocation=${departureLocation}&arrivalLocation=${arrivalLocation}&startDate=${startDate}&endDate=${endDate}&agencyId=${agencyId}`)
  const apiUrl = `http://localhost:8080/allExcursions?departureLocation=${departureLocation}&arrivalLocation=${arrivalLocation}&startDate=${startDate}&endDate=${endDate}&agencyId=${agencyId}`;
  fetch(apiUrl)
  .then(response => {
      if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}`);
      }
      return response.json();
  })
  .then(data => {
      ClearExcursions();
      FillExcursions(data);
      if(firstReload)
      {
        FillFilters(data);
        firstReload = false;
      }
      
  })
  .catch(error => {
      console.error('Error:', error);
  });

 
}

function ClearExcursions(){
  const container = document.getElementById('total-trips');
  container.innerHTML = '';

}



function FillExcursions(data)
{
    data.forEach(excursion => {
        const container = document.getElementById('total-trips');
        const excursionDiv = document.createElement('div');
        excursionDiv.innerHTML = `
            <div class='trip-title'>${excursion.name}</div>
            <div class='trip-description'>${excursion.description}</div>
            <div class='trip-date'>${excursion.startDate} εως ${excursion.endDate}</div>
            <div class='dep-location'>Αναχώρηση απο: <b>${excursion.departureLocation}</b></div>
            <div class='Price'>Τιμή:${excursion.price}€</p>
            <div class="reserve-radio">
              <label>Επιλογή</label>
              <input type="radio" name="location" value="${excursion.id}">
            </div>
            `;
        
        excursionDiv.classList.add("trip-container");
        container.appendChild(excursionDiv);
        });
      
}


document.getElementById("reserve-btn").onclick = function () {
  const excId = getSelectedValue();
  console.log(excId);
  if(excId != null)
    reservePage(userId, excId);
  else
    alert("Choose an excursion");
};

function reservePage(citizenId, excId){
  const data = { citizenId: citizenId, excId: excId };
  const queryString = Object.keys(data).map(key => `${key}=${data[key]}`).join('&');
  window.location.href = `reserve.html?${queryString}`;
}






function getQueryParams() {
  const queryString = window.location.search.slice(1); 
  const params = {};

  queryString.split('&').forEach(param => {
      const [key, value] = param.split('=');
      params[key] = decodeURIComponent(value);
  });

  return params;
}



function uniqueFilterData(data)
{
  const uniqueItems = {};

  data.forEach((item) => {
    const key = `${item.name}-${item.surname}-${item.id}`;
    uniqueItems[key] = uniqueItems[key] || item;
  });
  
  const filteredData = Object.values(uniqueItems);
  return filteredData;
  
}

function FillFilters(data)
{
  var arrOptionsD = [];
  var depOptionsD = [];
  var agencyOptionsD = [];
  var agencyOptionsWithId = [];

  data.forEach(trip => {
    depOptionsD.push(trip.departureLocation);
    arrOptionsD.push(trip.arrivalLocation);
    agencyOptionsD.push(trip.agency);
  }); 

  var arrOptions = arrOptionsD.filter((value, index, self) => {
    return self.indexOf(value) === index;
  });

  var depOptions = depOptionsD.filter((value, index, self) => {
    return self.indexOf(value) === index;
  });

  var agencyOptionsWithId = uniqueFilterData(agencyOptionsD);

    createDropdownOptions("dep-dropdown", depOptions);
    createDropdownOptions("arr-dropdown", arrOptions);
    createDropdownOptions("agency-dropdown", agencyOptionsWithId);

    createDropdownOptions("dep-dropdown1", depOptions);
    createDropdownOptions("arr-dropdown1", arrOptions);
    createDropdownOptions("agency-dropdown1", agencyOptionsWithId);

}


function createDropdownOptions(parentId, options) {
  var parentDropdown = document.getElementById(parentId);
  options.forEach(function (option) {
      var optionElement = document.createElement("option");
      if(option.name != null){
        optionElement.value = option.id;
        console.log(option.id);
        optionElement.textContent = option.name;
      }else{
        optionElement.value = option;
        optionElement.textContent = option;
      }
      
      parentDropdown.appendChild(optionElement);
  });
}


function convertDateFormat(inputDate) {
  // Parse the input date in "yyyy-MM-DD" format
  const parts = inputDate.split("-");
  const year = parts[0];
  const month = parts[1];
  const day = parts[2];

  // Create a new date object in the desired format "dd/mm/yyyy"
  const formattedDate = `${day}/${month}/${year}`;

  return formattedDate;
}

function updateSliderLabel(value) {
  document.getElementById("sliderLabel").textContent = "Price Range: $" + value;
}




// Get the parameters from the URL
const queryParams = getQueryParams();

const name = queryParams.name;
const surname = queryParams.surname;
const userId = queryParams.id;
let firstReload = true;

document.getElementById("user-text").textContent = `Hello ${name} ${surname}`;
getAllExcursions("", "", "", "", "");




function isSmallerScreen() {
  return window.innerWidth <= 900; 
}
function toggleSmallerDevicesFilter() {
  var smallerDevicesFilter = document.getElementById('smallerdevicesfilter');
  smallerDevicesFilter.style.display = isSmallerScreen() ? 'block' : 'none';
}

function toggleFilterPopup() {
  var filterPopup = document.getElementById('filterPopup');
  filterPopup.style.display = filterPopup.style.display === 'none' ? 'block' : 'none';
}

window.addEventListener('resize', toggleSmallerDevicesFilter);

window.onload = function () {
  toggleSmallerDevicesFilter();
};

function openFilterPopup() {
  document.getElementById('filterPopup').style.display = 'block';
}

function closeFilterPopup() {
  document.getElementById('filterPopup').style.display = 'none';
}
