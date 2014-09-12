// Function to handle Submit button clicks
function submitClick()
{
	console.log("Submit click");
	var url = document.getElementById('url_input').value;
    if (validationCheck()) {
		// Push inputs to database
		pushToDB();
   }
}

// Function to handle Cancel button clicks
function cancelClick()
{
    if(confirm("Are you sure you want to cancel your event addition?")) {
		window.location.href = "http://pennhillel.org";
		return false;
    } else {
		//Do nothing
    }
}

// Takes inputs and uploads them to Database
function pushToDB()
{
	// Load Parse
	console.log("Parse loaded.");
	Parse.initialize("SLe1mHC9Oz7IrQi0zNbhD3ae6t9ldiOUEbMpp82b", "lgteDVuvR9oTwqA8BFPz9LKsjVc2gj1P1a8wJCiR");

	// Simple inputs
	var name = document.getElementById('name_input').value;
	var description = document.getElementById('description_input').value;
	var location = document.getElementById('location_input').value;
	var cname = document.getElementById('cname_input').value;
    var cemail = document.getElementById('cemail_input').value;
    var url = document.getElementById('url_input').value;

    // Date inputs
    var yearIn = document.getElementById('year_input').value;
    var monthIn = document.getElementById('month_input').value;
    var dayIn = document.getElementById('day_input').value;
    var hourIn = document.getElementById('hour_input').value;
    var minuteIn = document.getElementById('minute_input').value;
    var whichIn = document.getElementById('ampm_input').value;
    var dateArr = {year: yearIn, month: monthIn, day: dayIn, hour: hourIn, minute: minuteIn, which: whichIn};
    var date = parseDate(dateArr);
    console.log("Date created: " + date);

    // Type input
    var typeIn = document.getElementById('type_input').value;
	var Type = Parse.Object.extend("Type");
    var type = new Type();
	type.id = typeIn;

	// Set up new event for DB
    var Event = Parse.Object.extend("Event");
	var hillelevent = new Event();
	hillelevent.set("Name", name);
	hillelevent.set("Description", description);
	hillelevent.set("Date", date);
	hillelevent.set("Location", location);
	hillelevent.set("ContactName", cname);
	hillelevent.set("ContactEmail", cemail);
	hillelevent.set("URL", url);
	hillelevent.set("Type", type);

	hillelevent.save(null, {
	  success: function(event) {
	    console.log('New object created with objectId: ' + event.id);
	    window.location.href = "thanks.html";
		return false;
	  },
	  error: function(event, error) {
	    alert('Failed to create new object, with error code: ' + error.description);
	  }
	});



}

// Checks that all fields have input and that input is of the correct format
function validationCheck() 
{
    var name = document.getElementById('name_input').value;
	var description = document.getElementById('description_input').value;
    var year = document.getElementById('year_input').value;
    var month = document.getElementById('month_input').value;
    var day = document.getElementById('day_input').value;
    var hour = document.getElementById('hour_input').value;
    var minute = document.getElementById('minute_input').value;
    var location = document.getElementById('location_input').value;
    var cname = document.getElementById('cname_input').value;
    var cemail = document.getElementById('cemail_input').value;
    var url = document.getElementById('url_input').value;

    // Validate all fields have information entered into them
    var alertMsg = "Please fill out the following:";
    if (name == "") {
		alertMsg += "\n\tEvent name";
    }
    if (description == "") {
		alertMsg += "\n\tDescription";
    }
    if (month == "") {
		alertMsg += "\n\tDate: month";
    }
    if (day == "") {
		alertMsg += "\n\tDate: day";
    }
    if (year == "") {
		alertMsg += "\n\tDate: year";
    }
    if (hour == "") {
		alertMsg += "\n\tTime: hour";
    }
    if (minute == "") {
		alertMsg += "\n\tTime: minute";
    }
    if (location == "") {
		alertMsg += "\n\tLocation";
    }
    if (cname == "") {
    	alertMsg +="\n\tContact name"
    }
    if (cemail == "") {
    	alertMsg +="\n\tContact email"
    }
    if (url == "") {
		alertMsg += "\n\tSign up link";
    }
    if (alertMsg != "Please fill out the following:") {
		alert(alertMsg);
		return false;
    }

    return validateTime(year, month, day, hour, minute, true);
}

// Function to date and time inputs - alert flag is to avoid double alerts
function validateTime(year, month, day, hour, minute, alertFlag) 
{
	var iyear = parseInt(year);
	var imonth = parseInt(month);
	var iday = parseInt(day);
	var ihour = parseInt(hour);
	var iminute = parseInt(minute);

	if (isNaN(imonth) || imonth > 12 || imonth < 1) {
		if (alertFlag) {alert("Please enter a valid month");}
		return false;
	}
	if (isNaN(iday) || iday > 31 || iday < 1) {
		if (alertFlag) {alert("Please enter a valid day");}
		return false;
	}
	if (isNaN(iyear) || iyear < 2014) {
		if (alertFlag) {alert("Please enter a valid year");}
		return false;
	}
	if (isNaN(ihour) || ihour < 1 || ihour > 12) {
		if (alertFlag) {alert("Please enter a valid hour");}
		return false;
	}
	if (isNaN(iminute) || iminute < 0 || iminute > 59) {
		if (alertFlag) {alert("Please enter a valid minute");}
		return false;
	}
	return validateUrl();
}

function validateUrl() 
{
	// Check URL is valid by trying to access. If no 404 error, then it exists and it is valid
	var request = new XMLHttpRequest();
	var url = document.getElementById('url_input').value;  
	request.open('GET', url, true);  
	request.send();  

	if (request.status != "404") {  
    	return true;
	} else {
		alert("Please enter a valid URL for the sign up link");
		return false;
	}

}



// Function to put date into correct format. Found online
function parseDate(a) 
{
  // new Date(year, month [, day [, hours[, minutes[, seconds[, ms]]]]])
  var hour = a.hour;
  if (a.which == "pm" && hour != 12) {
  	hour = hour + 12;
  } else if (a.which == "am" && hour == 12) {
  	hour = 0;
  }
  return new Date(a.year, a.month-1, a.day, hour, a.minute); // Note: months are 0-based
}