<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <table>
            <tr>
                <th>Airlines</th>
                <th>Departure City</th>
                <th>Arrival City</th>
                <th>Departure Time </th>
            </tr>

            <c:forEach items="${flights}" var="flight">
                <tr>
                    <td>${flight.operatingAirlines}</td>
                    <td>${flight.departureCity}</td>
                    <td>${flight.arrivalCity}</td>
                    <td>${flight.estimatedDepartureTime}</td>
                    <td><a href="showCompleteReservation?flightId=${flight.id}&user=${loggedUser}"> Select</a> </td>
                </tr>
            </c:forEach>

    </div>
    <a href="#">View All Flights</a>

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>