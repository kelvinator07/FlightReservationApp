<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register User</title>
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
					<li class="active"><a href="#">Home</a></li>
					<li><a href="showLogin">User Login</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">

		<div class="starter-template">
			<h1>Welcome To Peace Airline</h1>
			<h2>User Registration: ${message}</h2>
		</div>

	</div>

    <div class="maindiv" align="center" >
        <form action = "registerUser" method = "post" >
            First Name: <input type = "text" name="firstName" class="elem" /> <br>
            Last Name: <input type = "text" name="lastName" class="elem" /> <br>
            Email Address: <input type = "text" name="email" class="elem" /> <br>
            Password: <input type = "password" name="password" class="elem" /> <br>
            Confirm Password: <input type = "password" name="confirmPassword" class="elem" /> <br>
            <input type="submit" value= "register" />
        </form>
    </div>

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>