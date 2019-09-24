<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>Friend Profile Page</title>
</head>
<body>
	<h4>Friend Profile :</h4>
	<form:form>
		<table>
			<tr>
				<td>Full Name &nbsp;</td>
				<td>Gender &nbsp;</td>
				<td>Email &nbsp;</td>
				<td>Contact Number &nbsp;</td>
				<td>Organization</td>
			</tr>
			<tr>
				<td>${emp.full_name}&nbsp;</td>
				<td>${emp.gender}&nbsp;</td>
				<td>${emp.email}&nbsp;</td>
				<td>${emp.contact_number}&nbsp;</td>
				<td>${emp.org}</td>
				<td>
			</tr>
		</table>
		<br>
	</form:form>
</body>
</html>

