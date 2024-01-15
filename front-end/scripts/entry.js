function getQueryParams() {
    const queryString = window.location.search.slice(1); 
    const params = {};
  
    queryString.split('&').forEach(param => {
        const [key, value] = param.split('=');
        params[key] = decodeURIComponent(value);
    });
  
    return params;
  }

function getExcursions(id){

    const apiUrl = `http://localhost:8080/allExcursions?departureLocation=&arrivalLocation=&startDate=&endDate=&agencyId=${id}`;

    fetch(apiUrl)
    .then(response => {
        if (!response.ok) {
        throw new Error(`HTTP error! Status: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
        FillExcursions(data);
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

function FillExcursions(data)
{
    console.log(data);
    data.forEach(excursion => {
        const container = document.getElementById('total-trips');
        const excursionDiv = document.createElement('div');
        excursionDiv.innerHTML = `
            <div class='trip-title'>${excursion.name}</div>
            <div class='trip-description'>${excursion.description}</div>
            <div class='trip-date'>${excursion.startDate} εως ${excursion.endDate}</div>
            <div class='dep-location'>Αναχώρηση απο: <b>${excursion.departureLocation}</b></div>
            <div class='Price'>Τιμή:${excursion.price}</p>
            `;
        
        excursionDiv.classList.add("trip-container");
        container.appendChild(excursionDiv);
        });
      
}

function checkDates(dateFly, dateRet){


    if(dateFly == '' || dateRet == ''){
        unsuccesfulEntry();
        alert("Enter both dates");
        return false;
    }

    const date1 = new Date(dateFly);
    const date2 = new Date(dateRet);

    if(date2 > date1 ){
        return true;
    }

    if(date2<=date1){
        unsuccesfulEntry();
        alert("Invalid Return Date");
        return false;
    }
    return false;
}

function unsuccesfulEntry(){
    alert("Reservation not completed!");
}

function registerExcursion(){
    const location = document.getElementById("location").value;
    const description = document.getElementById("description").value;
    const dateFly = document.getElementById("date-fly").value;
    const dateRet = document.getElementById("date-ret").value;
    const depLocation = document.getElementById("depLocation").value;
    const capacity = document.getElementById("capacity").value;
    const price = document.getElementById("pricePerPerson").value;
    
    const validDates = checkDates(dateFly, dateRet);
    const rightForm = location!='' && description!='' && dateFly!='' 
    && dateRet!=undefined && capacity!=undefined && price!= '' && depLocation!='' && validDates;
    console.log(rightForm);

    if(rightForm){
        const apiUrl = "http://localhost:8080/registerExcursion";

        const excursionData = {
            name: location,
            description: description,
            startDate: dateFly,
            endDate: dateRet,
            departureLocation: depLocation,
            arrivalLocation: location,
            price: price,
            capacity: capacity,
            agencyId: id
        };
        console.log(excursionData);
        fetch(apiUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(excursionData)
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! Status: ${response.status}`);
                }
                alert("Successful entry!");
                document. location. reload() ;
                return response.json();
            })
            .then(data => {
                console.log('POST request successful:', data);
            })
            .catch(error => {
                console.error('Error:', error);
            });
    }

    



}
  
  // Get the parameters from the URL
const queryParams = getQueryParams();

const name = queryParams.name;
const id = queryParams.id;

console.log(name);
document.getElementById("user-text").textContent = `Hello ${name}`;

getExcursions(id);
