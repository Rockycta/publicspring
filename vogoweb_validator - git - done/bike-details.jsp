<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Bike Details</title>
	</head>
	<body>
		<h1>Bike Details</h1>
		<table style="border: 1px;">
			<tr>
				<td>Bike No:</td>
				<td>${bike.bikeNo}</td>
			</tr>
			<tr>
				<td>Bike Model Name:</td>
				<td>${bike.bikeModelName}</td>
			</tr>
			<tr>
				<td>Manufacturer:</td>
				<td>${bike.manufacturer}</td>
			</tr>
			<tr>
				<td>Rta Registration No:</td>
				<td>${bike.rtaRegistrationNo}</td>
			</tr>
			<tr>
				<td>Price:</td>
				<td>${bike.price}</td>
			</tr>
		</table>
	</body>
</html>