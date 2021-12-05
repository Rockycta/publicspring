<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Vogo Home</title>
	</head>
	<body>
		<h2>Vogo</h2>
		<ul>
			<li><a href="${pageContext.request.contextPath}/bike/list.htm">Show Bikes</a></li>
			<li><a href="${pageContext.request.contextPath}/search-bikes.htm">Search Bikes</a></li>
		</ul>
		
	</body>
</html>