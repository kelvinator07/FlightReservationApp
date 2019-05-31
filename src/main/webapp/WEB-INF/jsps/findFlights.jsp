<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
        <form action = "findFlights" method = "post" >
            Departure City : <input type = "text" name="from" class="elem" placeholder="Flight Number" /> <br>
            Arrival City  : <input type = "text" name="to" class="elem" /> <br>
            Departure Date  : <input type = "text" name="departureDate" class="elem" placeholder="YYYY-MM-DD" /> <br>
            <input type="submit" value= "Search" />
            <input type = "hidden" name="user" value= "${loggedUser}"/>
        </form>
    <br> ${msg} <br>
    </div>

    <h3 align="center"><a href="viewAllFlights?user=${loggedUser}">View All Available Flights</a></h3>

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>