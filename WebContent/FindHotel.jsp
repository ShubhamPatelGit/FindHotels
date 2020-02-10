<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find Hotels</title>
<link href="CSS/FindHotel.css" rel="stylesheet">
</head>
<body>

	<h1>Find Hotels</h1>
	<form action="Search">
		<label for="date">Date:</label> 
		<input type="date" name="date" id="date" required><br> 
		<label for="guest">No.of Guests:</label> 
		<input type="number" min="15" max="500" id="guest" name="guest" placeholder="No. of Guests" required><br> 
		<label for="seating">Seating type:</label>
		<select name="seating" id="seating">
			<option value="15">Boardroom</option>
			<option value="6">Theatre</option>
			<option value="16">Banquet</option>
		</select><br> 
		<label for="city">City:</label> 
		<select name="city" id="city">
			<option value="Bombay">Bombay</option>
			<option value="Delhi">Delhi</option>
			<option value="Bangalore">Bangalore</option>
		</select><br>
		<label for='budget'>Budget per person:</label> 
		<input type="number" min="1000" max="5000" id="budget" name="budget" placeholder="Budget per person" required><br> 
		<input class="button" type="reset">
		<input class="button" type="submit" value="search">
	</form>

	<script type="text/javascript">
			var dateControl = document.querySelector('#date');
			
		    var d = new Date();
	        month = '' + (d.getMonth() + 1);
	        day = '' + d.getDate();
	        year = d.getFullYear();
	
	    	if (month.length < 2) 
	        	month = '0' + month;
	    	if (day.length < 2) 
	        	day = '0' + day;
	
	    	var currentDate =  [year, month, day].join('-');
			dateControl.value = currentDate;
			dateControl.min = currentDate;
		</script>
</body>
</html>