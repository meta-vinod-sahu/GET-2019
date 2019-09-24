<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>Login Page</title>
</head>
<body>
	<form:form modelAttribute="loginDTO">
		<form:errors cssClass="text-danger"></form:errors>
		<h5 class="text-danger">${msg}</h5>
		<h5 class="text-success">${getPass}</h5>
		<h4>Login Here:</h4>
		<table>
			<tr>
				<td>Email</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="text-danger"></form:errors>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="text-danger"></form:errors>
			</tr>
		</table>
		<br>
		<button type="submit">Login</button>
	</form:form>
</body>
</html>