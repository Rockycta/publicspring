<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add Doctor</title>
	</head>
	<body>
		<h2>Add Doctor</h2>
		<form:form modelAttribute="doctorForm">
			<p style="color:red;">
				<form:errors path="*"/>
			</p>
			Doctor Name: <form:input path="doctorName"/><br/>
			Qualification:
			<form:select path="qualification">
				<c:forEach items="${qualifications}" var="qualification">
					<form:option value="${qualification}">${qualification}</form:option>
				</c:forEach>
			</form:select> 
			<br/>
			Email Address: <form:input path="emailAddress"/><br/>
			<input type="submit" value="add doctor"/>
		</form:form>
	
	</body>
</html>