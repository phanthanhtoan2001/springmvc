<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>User form</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://examples.javacodegeeks.com/wp-content/litespeed/localres/aHR0cHM6Ly9tYXhjZG4uYm9vdHN0cmFwY2RuLmNvbS8=bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h3 id="form_header" class="text-warning" align="center">User
			Form</h3>
		<div></div>

		<!-- User input form to add a new user or update the existing user-->
		<c:url var="saveUrl" value="/user/save" />
		<form:form id="user_form" modelAttribute="userAttr" method="POST"
			action="${saveUrl}">
			<form:hidden path="id" />
			<label for="user_name">Enter Name: </label>
			<form:input id="user_name" cssClass="form-control" path="name" />
			<div></div>

			<button id="saveBtn" type="submit" class="btn btn-primary">Save</button>
		</form:form>
	</div>
</body>
</html>