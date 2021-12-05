<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Search Bikes</title>
	</head>
	<body>
		<h2>Search Bikes</h2>
		<form action="${pageContext.request.contextPath}/bike/doSearchBikes.htm" method="post">
			<%-- <p style="color:red;">
				<form:errors path="bikeSearchForm.*"/>
			</p> --%>
			Model Name: <input type="text" name="modelName"/><br/>
			<p style="color:red;">
				<form:errors path="bikeSearchForm.modelName"/>
			</p><br/>
			Manufacturer: <input type="Text" name="manufacturer"/><br/>
			<p style="color:red;">
				<form:errors path="bikeSearchForm.manufacturer"/>
			</p><br/>
			Rta Registration Number: <input type="Text" name="rtaRegistrationNo"/><br/>
			<p style="color:red;">
				<form:errors path="bikeSearchForm.rtaRegistrationNo"/>
			</p><br/>
			Price Between: <input type="text" name="minPrice" value="0"/> 
			<p style="color:red;">
				<form:errors path="bikeSearchForm.minPrice"/>
			</p><br/>and 
			<input type="text" name="maxPrice" value="0"/><br/>
			<p style="color:red;">
				<form:errors path="bikeSearchForm.maxPrice"/>
			</p><br/>
			<input type="submit" value="search"/> 
		</form>
	</body>
</html>