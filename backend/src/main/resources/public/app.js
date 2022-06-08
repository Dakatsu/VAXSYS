const menu = document.querySelector('#mobile-menu');
const menuLinks = document.querySelector('.navbar__menu');

const mobileMenu = ()  => {
    menu.classList.toggle('is-active');
    menuLinks.classList.toggle('active');
}

menu.addEventListener('click', mobileMenu);

function sendLogin() {
    let result = document.getElementById('result');
    let email = document.getElementById('email');
    let password = document.getElementById('password');

    // Creating a XHR object
    let xhr = new XMLHttpRequest();
    let url = "/home/login";

    // open a connection
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");

    // Create a state change callback
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            // Print received data from server
            result.innerHTML = xhr.status + ": " + this.responseText;
        }
    };

    // Converting JSON data to string
    var data = JSON.stringify({ "email": email.value, "password": password.value });

    // Sending data with the request
    xhr.send(data);
    result.innerHTML += "Data sent: " + data.toString() + "\n";
}

function addAccount() {
    let result = document.getElementById('resultX');
    let firstName = document.getElementById('firstName');
    let lastName = document.getElementById('lastName');
    let email = document.getElementById('emailX');
    let password = document.getElementById('passwordX');
    let role = document.getElementById('role');

    // Creating a XHR object
    let xhr = new XMLHttpRequest();
    let url = "/admin/account";

    // open a connection
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");

    // Create a state change callback
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            // Print received data from server
            result.innerHTML = xhr.status + ": " + this.responseText;
        }
    };

    // Converting JSON data to string
    let data = JSON.stringify({ "firstName": firstName.value,
        "lastName": lastName.value,
        "email": emailX.value,
        "password": passwordX.value,
        "role": role.value,
    });

    // Sending data with the request
    xhr.send(data);
    result.innerHTML += "Data sent: " + data.toString() + "\n";
}