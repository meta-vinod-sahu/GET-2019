<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>add student here</title>
</head>
<body>
<div align="center">
		<form:form modelAttribute="student" method="POST" action="addStudentPost">
			<h1>Student Detail Form</h1>
			 <form:errors cssClass ="text-danger" element = "div" />
			<table>
				<tr>
				   
					<td>First Name</td>
					<td><form:input path="firstName" /></td>
					 <td><form:errors path="firstName" cssClass="text-danger"></form:errors></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><form:input path="lastName" /></td>
					 <td><form:errors path="lastName" cssClass="text-danger"></form:errors></td>				</tr>
				<tr>
					<td>Father Name</td>
					<td><form:input path="fatherName" /></td>
					 <td><form:errors path="fatherName" cssClass="text-danger"></form:errors></td> 
				</tr>
				<tr>
					<td>Email</td>
					<td><form:input path="email" /></td>
				       <td><form:errors path="email" cssClass="text-danger"></form:errors></td>
				</tr>
				<tr>
					<td>Class</td>
					<td><form:input path="studentClass" /></td>
				 <td><form:errors path="studentClass" cssClass="text-danger"></form:errors></td> 
				</tr>
				<tr>
					<td>Age</td>
					<td><form:input path="studentAge" /></td>
					 <td><form:errors path="studentAge" cssClass="text-danger"></form:errors></td>
					 
				</tr>
			</table>
			<br>
			<button type="submit">Submit</button>
		</form:form>
	</div>
</body>
</html>