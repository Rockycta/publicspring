<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Bikes</title>
		<style>
			table {
			  font-family: arial, sans-serif;
			  border-collapse: collapse;
			  width: 100%;
			}
			
			td, th {
			  border: 1px solid #dddddd;
			  text-align: left;
			  padding: 8px;
			}
			
			tr:nth-child(even) {
			  background-color: #dddddd;
			}
		</style>
	</head>
	<body>
		<h2>Bikes</h2>
		<table>
			<tr>
				<th>Bike No</th>
				<th>Model Name</th>
				<th>Manufacturer</th>
				<th>Price</th>
			<tr>
			<c:forEach items="${bikes}" var="bike">
				<tr>
					<td>${bike.bikeNo}</td>
					<td>${bike.bikeModelName}</td>
					<td>${bike.manufacturer}</td>
					<td>${bike.price}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>