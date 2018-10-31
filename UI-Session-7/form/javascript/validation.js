var errorMap = new Map;

function checkValidity() {
	firstNameValidity(document.getElementById("firstName"));
	lastNameValidity(document.getElementById("lastName"));
	emailValidity(document.getElementById("email"));
	/*phoneNumberValidity(document.getElementById("phoneNumber"));*/
	stateValidity(document.getElementById("state"));

	/*projectValidity(document.getElementById("project"));*/

	if(document.getElementById("form_container").contains(document.getElementById("phoneNumber"))) {
		phoneNumberValidity(document.getElementById("phoneNumber"));
	}

	if(document.getElementById("form_container").contains(document.getElementById("city"))) {
		cityValidity(document.getElementById("city"));
	}

	if(document.getElementById("form_container").contains(document.getElementById("zipCode"))) {
		zipodeValidity(document.getElementById("zipCode-input"));
	}

	if(document.getElementById("form_container").contains(document.getElementById("project"))) {
		projectValidity(document.getElementById("project-input"));
	}

	showMessage();

	if(errorMap.size!=0) {
		return false;
	}

	if(errorMap.size===0) {
		var formElements = document.getElementById("contact_form");
		if(localStorage) {
			localStorage.clear();

			localStorage.setItem("1.First Name", document.getElementById("firstName").value);
			localStorage.setItem("2.Last Name", document.getElementById("lastName").value);

			localStorage.setItem("3.Email", document.getElementById("email").value);
			localStorage.setItem("4.State", document.getElementById("state").value);

			var contact = document.getElementById("phoneNumber");
        	var address = document.getElementById("address");
        	var city = document.getElementById("city");
        	var project = document.getElementById("project-input");
        	var website = document.getElementById("website-input");
        	var zip = document.getElementById("zipCode-input");
        	var hosting = document.getElementById(".radio");
        	
			if(contact.value != "") {
		    localStorage.setItem("Phone #", contact.value);
			}

			if(address.value != "") {
			    localStorage.setItem("Address", address.value);
			}

			if(city.value != "") {
			    localStorage.setItem("City", city.value);
			}

			if(project != null) {
			    localStorage.setItem("Project Description", project.value);
			}

			if(website != null && website.value != "") {
			    localStorage.setItem("Website or domain name", website.value);
			}

			if(zip != null || zip.value != "") {
			    localStorage.setItem("Zip Code", zip.value);
			}

			if(hosting != null) {
			    localStorage.setItem("Hosting", hosting.value);
			}

			
			/*for(var i=0; i<formElements.elements.length;i++) {
				localStorage.setItem(formElements.elements[i].name,formElements.elements[i].value);
			}*/
		}
		else {
			console.log("Browser doesn't support storage");
		}
	}
	return true;
}



function showMessage() {
	var message = "";
	if(errorMap.size > 0) {
		var allKeys = errorMap.keys();
		for(var key of allKeys) {
			message+= key + " - " + errorMap.get(key) + "\n";
		}
		alert(message);
	}
}

function deleteEntry(key) {
	if(errorMap.has(key)) {
		errorMap.delete(key);
	}
}

function firstNameValidity(firstName) {
	if(firstName.value == "") {
		errorMap.set("FirstName","First name is required");
		firstName.style.borderColor = "red" ;
	}
	else if(!(/^[a-zA-Z]{2,}$/.test(firstName.value))) {
		errorMap.set("FirstName","First name is invalid");
		firstName.style.borderColor = "red";
	}
	else {
		deleteEntry("FirstName");
		firstName.style.borderColor = "green";
	}
}

function lastNameValidity(lastName) {
	if(lastName.value == ""){
		errorMap.set("LastName", "Last name is required");
		lastName.style.borderColor = "red";
	}
	else if (!(/^[a-zA-Z]{2,}$/.test(lastName.value))) {
		errorMap.set("LastName", "Last name is invalid");
		lastName.style.borderColor = "red";
	}
	else{
		deleteEntry("LastName");
		lastName.style.borderColor = "green";
    }	
}

function emailValidity(email) {
	if(email.value == ""){
		errorMap.set("Email", "Email is required");
		email.style.borderColor = "red";
	}
	else if(!(/^\w+([\.-]?\w+)*@[a-zA-Z]+(\.[a-zA-Z]{2,3})+$/.test(email.value))){
		errorMap.set("Email", "Email is invalid");
		email.style.borderColor = "red";
	}
	else{
		deleteEntry("Email");
		email.style.borderColor = "green";
	}	
}

function phoneNumberValidity(phoneNumber) {
	if(!((phoneNumber.value == "") || (/^[\d]{10}$/.test(phoneNumber.value)))) {
		errorMap.set("Phone", "Phone number is invalid");
		phoneNumber.style.borderColor = "red";
	}
	else{
		deleteEntry("Phone");
		phoneNumber.style.borderColor = "green";
	}	
}

function cityValidity(city) {
	if(!((city.value == "") || (/^[a-zA-Z]{2,}$/.test(city.value)))) {
		errorMap.set("City", "City name is invalid");
		city.style.borderColor = "red";
	}
	else{
		deleteEntry("City");
		city.style.borderColor = "green";
    }	
}

function stateValidity(state) {
    if(state.value == ""){
		errorMap.set("State", "State is required");
		state.style.borderColor = "red";
	}else{
		deleteEntry("State");
		state.style.borderColor = "green";
	}	
}

function zipodeValidity(zipCode) {
    if(zipCode.value == ""){
		errorMap.set("ZipCode", "ZipCode is required");
		zipCode.style.borderColor = "red";
	}
	else if(!(/^[\d]{6}$/.test(zipCode.value))){
		errorMap.set("ZipCode", "ZipCode is invalid");
		zipCode.style.borderColor = "red";
	}
	else{
		deleteEntry("ZipCode");
		zipCode.style.borderColor = "green";
	}
}

function projectValidity(project) {
	if(project.value == ""){
		errorMap.set("Project", "Project is required");
		project.style.borderColor = "red";
	}
	else if (!(/^[a-zA-Z]{2,}$/.test(project.value))) {
		errorMap.set("Project", "Project is invalid");
		project.style.borderColor = "red";
	}
	else{
		deleteEntry("Project");
		project.style.borderColor = "green";
    }	
}