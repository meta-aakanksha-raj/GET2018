function stateChange(stateName) {
	var formElement = document.getElementById("form_container");
	var lastDiv = document.getElementById("last_div");
	

	var doesZipCodeExist = formElement.contains(document.getElementById("zipCode"));
	var doesWebsiteExist = formElement.contains(document.getElementById("website"));
	var doesHostingExist = formElement.contains(document.getElementById("radio"));
	var doesProjectExist = formElement.contains(document.getElementById("project"));

	switch(stateName) {
		case "Rajasthan":
			if(!doesZipCodeExist) {
				formElement.insertBefore(getZipCode(),lastDiv);
			}
			if(!doesWebsiteExist) {
				formElement.insertBefore(getWebsite(),lastDiv);
			}
			if(doesHostingExist) {
				formElement.removeChild(document.getElementById("radio"));
			}
			if(doesProjectExist) {
				formElement.removeChild(document.getElementById("project"));
			}
			break;


		case "Haryana":
			if(!doesZipCodeExist) {
				formElement.insertBefore(getZipCode(),lastDiv);
			}
			if(doesWebsiteExist) {
				formElement.removeChild(document.getElementById("website"));
			}
			if(!doesHostingExist) {
				formElement.insertBefore(getHosting(),lastDiv);
			}
			if(doesProjectExist) {
				formElement.removeChild(document.getElementById("project"));
			}
			break;

		case "Maharashtra":
			if(!doesZipCodeExist) {
				formElement.insertBefore(getZipCode(),lastDiv);
			}
			if(doesWebsiteExist) {
				formElement.removeChild(document.getElementById("website"));
			}
			if(doesHostingExist) {
				formElement.removeChild(document.getElementById("radio"));
			}
			if(!doesProjectExist) {
				formElement.insertBefore(getProject(),lastDiv);
			}
			break;
	}
}

function getZipCode() {
	var zip = document.createElement('div');
	zip.className = "form_section";
	zip.id = "zipCode";
	zip.innerHTML = "<div class='form_field field_title'>Zip Code</div><div class='form_field entry_field'><div class='icon'> <i class='fa fa-home'></i></div><input class='input_field' type='text'id='zipCode-input' name='zipCode' placeholder='Zip Code'></div>" 
	return zip;
}

function getWebsite() {
	var webDomain = document.createElement('div');
	webDomain.id = "website";
	webDomain.className = "form_section";
	webDomain.innerHTML = "<div class='form_field field_title'>Website or domain name</div><div class='form_field entry_field'><div class='icon'> <i class='fa fa-globe-asia'></i></div><input class='input_field' type='text' id='website-input' name='website' placeholder='Website or domain name'></div>"
	return webDomain;
}

function getHosting() {
	var hosting = document.createElement('div');
	hosting.id = "radio";
	hosting.className = "form_section";
	hosting.innerHTML = "<div class='form_field field_title'>Do you have hosting?</div><div class='form_field entry_field'><input class='input_field' type='radio' name='hosting'>Yes<input class='input_field' type='radio' name='hosting'>No</div>"
	return hosting; 
}

function getProject() {
	var projectDesc = document.createElement('div');
	projectDesc.id = "project";
	projectDesc.className = "form_section";
	projectDesc.innerHTML = "<div class='form_field field_title'>Project Description</div><div class='form_field entry_field'><div class='icon'> <i class='fa fa-pencil-alt'></i></div><textarea rows='1' cols='22' class='input_field' id='project-input' name='project' placeholder='Project Description'></textarea></div>"
	return projectDesc;
}
