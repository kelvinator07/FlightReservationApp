<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<title>Login User</title>
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="registerUser">Flight Reservation Application Using Spring Boot</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="showReg">Home</a></li>
					<li class="active" ><a href="showLogin">User Login</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">

		<div class="starter-template">
			<h1>Welcome To Peace Airline</h1>
			<h2>User Login Page: ${loggedUser}</h2>
		</div>

	</div>

    <div class="maindiv" align="center" >
        <form action = "loginUser" method = "post" >
            User Name: <input type = "text" name="email" class="elem" placeholder="Email Address" /> <br>
            Password: <input type = "password" name="password" class="elem" /> <br>
            <input type="submit" value= "login" />
        </form>
    <br> ${msg} <br>
    </div>

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>