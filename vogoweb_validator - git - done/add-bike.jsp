<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add Bike</title>
		<style type="text/css">
			.error {
				color: red;
			}
		</style>
	</head>
	<body>
		<h2>Add Bike</h2>		
		<form:form modelAttribute="bikeForm">
			Model Name: <form:input path="modelName"/> &nbsp; <form:errors path="modelName" cssClass="error"/><br/>
			Manufacturer: <form:input path="manufacturer"/> &nbsp; <form:errors path="manufacturer" cssClass="error"/><br/>
			Rta Registration No: <form:input path="rtaRegistrationNo"/> &nbsp; <form:errors path="rtaRegistrationNo" cssClass="error"/><br/>
			Price: <form:input path="price"/> &nbsp; <form:errors path="price" cssClass="error"/><br/>
			<input type="submit" value="add bike"/>
		</form:form>
	</body>
</html>