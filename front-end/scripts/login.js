function login() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const data = {
        username: username,
        password: password
    };

    fetch('http://localhost:8080/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        if(data!=null)
        {
            if(data["userType"] == "citizen")
            {
                citizenLogin(data["name"], data["surname"], data["id"]);
            }
            else if(data["userType"] == "travel_agency")
            {
                agencyLogin(data["name"], data["id"]);
            }
            else
            {
                
            }
        }
        else{
           displayError("Username and/or Password are invalid");
           clearIdentifiers();
        }

    })
    .catch(error => {
        displayError("Failed to make request");
    });
}


function citizenLogin(name, surname, id){
    const data = { name: name, surname: surname, id: id };
    const queryString = Object.keys(data).map(key => `${key}=${data[key]}`).join('&');
    window.location.href = `search.html?${queryString}`;
}

function agencyLogin(name, id){
    const data = { name: name, id: id };
    const queryString = Object.keys(data).map(key => `${key}=${data[key]}`).join('&');
    window.location.href = `entry.html?${queryString}`;
}

function displayError(message){
    document.getElementById("wrong-identifier").style.color = "red";
    document.getElementById("wrong-identifier").textContent = message;
}

function clearIdentifiers(){
    document.getElementById("username").value = "";
    document.getElementById("password").value = "";
    document.getElementById("username").focus();
}

function submitForm(event){
    event.preventDefault();
    login();
}

