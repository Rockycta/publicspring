<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Edit Bike</title>
		<style type="text/css">
			.error {
				color: red;
			}
		</style>
	</head>
	<body>
		<h2>Edit Bike</h2>
		<form:form modelAttribute="editBikeForm">
			Bike No: ${editBikeForm.bikeNo}
			<form:hidden path="bikeNo"/><br/>
			Model Name: <form:input path="modelName"/>
			<form:errors path="modelName" cssClass="error"/>
			<br/>
			Manufacturer: <form:input path="manufacturer"/>
			<form:errors path="manufacturer" cssClass="error"/><br/>
			Rta Registration No: <form:input path="rtaRegistrationNo"/>
			<form:errors path="rtaRegistrationNo" cssClass="error"/>
			<br/>
			Price: <form:input path="price"/>
			<form:errors path="price" cssClass="error"/><br/>
			<input type="submit" value="updateBike"/>
		</form:form>
	</body>
</html>