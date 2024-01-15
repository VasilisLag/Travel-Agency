
function submitForm(event){
    event.preventDefault();
    agencyRegister();
}

function agencyRegister(){
    const name = document.getElementById("name").value;
    const afm = String(document.getElementById("afm").value);
    const owner = document.getElementById("owner").value;
    const password = document.getElementById("password").value;
    const confPassword = document.getElementById("confirmPassword").value;

    const passCond = checkPassword(password, confPassword);
    const afmCond = checkAfm(afm);
    
    if(passCond && afmCond )
        agencyRequest(name, afm, owner, password);
}

function checkPassword(pass1, pass2){
    if(pass1 != pass2 || !(pass1.length >= 8)){
        displayError("Passwords don't match");
        clearPasswords();
    }
        
    return (pass1 == pass2 && pass1.length >= 8);
}

function checkAfm(afm){
    if(afm.length!=9)
        alert("Invalid AFM");
    return afm.length == 9;
}



function agencyRequest(name, afm, owner, password){
    const apiUrl = 'http://localhost:8080/registerAgency';

      const data = {
        afm: afm,
        name: name,
        owner: owner,
        password: password
      };

      fetch(apiUrl, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
      })
      .then(data => {
        console.log('Success:', data);
        login(afm, password);
      })
      .catch(error => {
        displayError("Failed to make request")
      });
}

function displayError(message){
    document.getElementById("connection-problem").style.color = "red";
    document.getElementById("connection-problem").textContent = message;
}

function clearPasswords(){
    document.getElementById("password").value = "";
    confPassword = document.getElementById("confirmPassword").value = "";
}


// ---------------------------------------------------------------------------------------
// Login Process 


function login(username, password) {


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
            agencyLogin(data["name"], data["id"]);
        }
        else{
            displayError("This user doesn't exist");
        }

    })
    .catch(error => {
        console.log(error);
        displayError("Failed to request");
    });
}


function agencyLogin(name, id){
    const data = { name: name, id: id };
    const queryString = Object.keys(data).map(key => `${key}=${data[key]}`).join('&');
    window.location.href = `entry.html?${queryString}`;
}
