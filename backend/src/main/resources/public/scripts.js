/**
 * Short function to make requests consistent.
 * @param URL The URL for the request.
 */
function makePostRequest(url) {
    let xhr = new XMLHttpRequest();
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    return xhr;
}

/**
 * Function to submit a login request.
 * @param URL The destination URL for the request.
 * @param Prefix The prefix of the email and password fields.
 * @param outputName The destination for output messages.
 */
function submitLogin(url, prefix, outputName) {
    let output = document.getElementById(outputName);
    let email = document.getElementById(prefix + 'Email');
    let password = document.getElementById(prefix + 'Password');

    // Creating a XHR object
    let xhr = makePostRequest(url);

    // Create a state change callback
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            // Just print a success message if code 200.
            if (xhr.status == 200) {
                output.innerHTML = "Login Successful!";
                // NOTE: If we can get the account type,
                //       we can redirect to the corresponding
                //       page using this function:
                //window.open("/admin/index.html", "_self")
            }
            // Otherwise, print failure response.
            else {
                output.innerHTML = responseToString(xhr);
            }
        }
    };

    // Convert JSON data to string
    let data = JSON.stringify({"email": email.value,
                               "password": password.value
                               });

    // Send data with the request
    xhr.send(data);
    output.innerHTML = "Data sent: " + data.toString() + "\n";
}

/**
 * Function to submit a patient registration request.
 * @param URL The destination URL for the request.
 * @param Prefix The prefix for fields used to register.
 * @param outputName The destination for output messages.
 */
function submitRegistration(url, prefix, outputName) {
    let output = document.getElementById(outputName);
    let firstName = document.getElementById(prefix + 'FirstName');
    let lastName = document.getElementById(prefix + 'LastName');
    let email = document.getElementById(prefix + 'Email');
    let password = document.getElementById(prefix + 'Password');

    // Creating a XHR object
    let xhr = makePostRequest(url);

    // Create a state change callback
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            // Just print a success message if code 200.
            if (xhr.status == 200) {
                output.innerHTML = "Registration Successful!";
            }
            // Otherwise, print failure response.
            else {
                output.innerHTML = responseToString(xhr);
            }
        }
    };

    // Convert JSON data to string
    let data = JSON.stringify({"firstName": firstName.value,
                               "lastName": lastName.value,
                               "email": email.value,
                               "password": password.value
                               });

    // Send data with the request
    xhr.send(data);
    output.innerHTML = "Data sent: " + data.toString() + "\n";
}

/**
 * Function to submit a new account request.
 * @param URL The destination URL for the request.
 * @param outputName The destination for output messages.
 */
function submitAccount(url, prefix, outputName) {
    let output = document.getElementById(outputName);
    let firstName = document.getElementById(prefix + 'FirstName');
    let lastName = document.getElementById(prefix + 'LastName');
    let email = document.getElementById(prefix + 'Email');
    let password = document.getElementById(prefix + 'Password');
    // Logic to get the selected radio button.
    let radioButtons = document.getElementsByName(prefix + 'Role');
    let role = null;
    for (i = 0; i < radioButtons.length; i++) {
        if (radioButtons[i].checked) {
            role = radioButtons[i];
        }
    }

    // Creating a XHR object
    let xhr = makePostRequest(url);

    // Create a state change callback
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            // Print received data from server
            output.innerHTML = xhr.status + ": " + this.responseText;
        }
    };

    // Convert JSON data to string
    let data = JSON.stringify({"firstName": firstName.value,
                               "lastName": lastName.value,
                               "email": email.value,
                               "password": password.value,
                               "role": role.value
                               });

    // Send data with the request
    xhr.send(data);
    output.innerHTML = "Data sent: " + data.toString() + "\n";
}

/**
 * Placeholder to write HTTP responses in a consistent format.
 * @param xhr the XMLHTTPRequest class we wish to write.
 */
function responseToString(xhr) {
    return xhr.status + ": " + xhr.responseText;
}

// Test button, please ignore.
function testButton(outputName) {
    let output = document.getElementById(outputName);
    output.innerHTML = "Did the JavaScript!";
}