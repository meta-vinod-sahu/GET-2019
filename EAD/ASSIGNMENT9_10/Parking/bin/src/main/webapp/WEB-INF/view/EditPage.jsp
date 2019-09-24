<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>Update Details Form</title>
</head>
<body>
	<div align="center" id="reg">
		<form:form modelAttribute="employeeDTO">
		<form:errors cssClass="text-danger"></form:errors>
			<h1>Update Details</h1>
			<table>
				<tr>
					<td>Full name :</td>
					<td><form:input path="full_name" value="${employeeDTO.full_name}"/></td>
					<td><form:errors path="full_name" cssClass="text-danger"></form:errors>
				</tr>
				<tr>
					<td>Gender :</td>
					<td><form:select path="gender">
							<form:option value="female" label="Female" />
							<form:option value="male" label="Male" />
							<form:option value="other" label="Other" />
						</form:select></td>
				</tr>
				<tr>
					<td>Email Id :</td>
					<td><form:input path="email"  value="${employeeDTO.email}" readonly="true"/></td>
					<td><form:errors path="email" cssClass="text-danger"></form:errors>
				</tr>
				<tr>
					<td>Password :</td>
					<td><form:password path="password" value="${employeeDTO.password}"/></td>
					<td><form:errors path="password" cssClass="text-danger"></form:errors>
				</tr>
				<tr>
					<td>Confirm Password :</td>
					<td><form:password path="repass" /></td>
				</tr>
				<tr>
					<td>Contact Number :</td>
					<td><form:input path="contact_number" value="${employeeDTO.contact_number}"/></td>
					<td><form:errors path="contact_number" cssClass="text-danger"></form:errors>
				</tr>
				<tr>
					<td>Organization :</td>
					<td><form:select path="org">
							<form:option value="Org1" label="Org1" />
							<form:option value="Org2" label="Org2" />
							<form:option value="Org3" label="Org3" />
							<form:option value="Org4" label="Org4" />
						</form:select></td>
				</tr>
			</table>
			<br>
			<button type="submit">Update</button>
			<br>
		</form:form>
	</div>
</body>
</html>