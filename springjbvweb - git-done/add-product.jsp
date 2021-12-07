<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add Product</title>
	</head>
	<body>
		<h2>Add Product</h2>
		<form:form modelAttribute="productForm">
			<p style="color: red;">
				<form:errors path="*"/>
			</p>
			ProductName: <form:input path="productName"/><br/>
			Description: <form:input path="description"/><br/>
			Price: <form:input path="price"/><br/>
			<input type="submit" value="add product"/>
		</form:form>
	</body>
</html>