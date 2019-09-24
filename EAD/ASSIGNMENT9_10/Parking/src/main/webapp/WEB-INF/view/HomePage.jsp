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
<title>Home Page</title>
</head>
<body>

	<h4 align="right">
		Welcome <a href="/FileUpload?Email=${emp.email}"> <object
				data="${img}" width="50px" height="60px">
				 
				
				<img src="/Image/male.jpg" width="50px" height="60px">
			</object> 
			
		</a> ${emp.full_name}
	</h4>
	<br>

	<h4>Your Details :</h4>
	<form:form>
		<table>
			<tr>
				<td>Full Name &nbsp;</td>
				<td>Gender &nbsp;</td>
				<td>Email &nbsp;</td>
				<td>Password &nbsp;</td>
				<td>Contact Number &nbsp;</td>
				<td>Organization</td>
			</tr>
			<tr>
				<td>${emp.full_name}&nbsp;</td>
				<td>${emp.gender}&nbsp;</td>
				<td>${emp.email}&nbsp;</td>
				<td>${emp.password}&nbsp;</td>
				<td>${emp.contact_number}&nbsp;</td>
				<td>${emp.org}</td>
				<td>
			</tr>
		</table>
		<br>
		<a href="/EditPage?Email=${emp.email}"><input type="button" value="Edit"/></a>
		<a href="/FriendPage?Email=${emp.email}"><input type="button" value="Friends"/></a>
		<a href="/LogOutPage"><input type="button" value="Log Out"/></a>
		<h5 class="text-success">${edit}</h5>
	</form:form>
</body>
</html>