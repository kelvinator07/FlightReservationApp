<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Homepage</title>
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="showReg">Flight Reservation Application Using Spring Boot</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="showReg">Home</a></li>
					<li class="active" ><a href="#">User Homepage</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">

		<div class="starter-template">
			<h1>Welcome To Peace Airline Find Flights</h1>
			<h2>Welcome: ${loggedUser}</h2>
		</div>

	</div>

    <div class="maindiv" align="center" >
        <h2>Complete Reservation</h2>
        Airline : ${flight.operatingAirlines}<br/>
        Departure City : ${flight.departureCity}<br/>
        Arrival City : ${flight.arrivalCity}<br/>

        <form action = "completeReservation" method = "post" >
            First Name: <input type = "text" name="passengerFirstName" class="elem" /> <br>
            Last Name: <input type = "text" name="passengerLastName" class="elem" /> <br>
            Email Address: <input type = "text" name="passengerEmail" class="elem" /> <br>
            Phone: <input type = "text" name="passengerPhone" class="elem" /> <br>

            <h2>Card Details</h2>
            Name On Card: <input type = "text" name="nameOnCard" class="elem" /> <br>
            Card No: <input type = "text" name="cardNumber" class="elem" /> <br>
            Expiry Date: <input type = "text" name="expirationDate" class="elem" /> <br>
            Three Digit Sec Code: <input type = "text" name="securityCode" class="elem" /> <br>

            <input type="hidden" name = "flightId" value= "${flight.id}" />
            <input type="submit" value= "Confirm" />
        </form>
    <br> ${msg} <br>
    </div>

    <h3 align="center"><a href="#">View All Available Flights</a></h3>
    <input type="hidden" name = "user" value= "${loggedUser}" />

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>