<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>Friends</title>
</head>
<body>
		<form:form>
			<h3>Friends</h3>
			<table>
				<tr>
					<td>Full Name</td>
					<td>Profile</td>
				</tr>
				<c:forEach items="${friend}" var="f">
					<tr>
						<td>${f.full_name}</td>
						<td><a href="/FriendProfile?email=${f.email}">Profile</a></td>
					</tr>
				</c:forEach>
			</table>
		</form:form>
</body>
</html>