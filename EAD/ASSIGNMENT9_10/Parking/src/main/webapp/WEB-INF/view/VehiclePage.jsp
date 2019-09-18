<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>Vehicle Details Form</title>
</head>
<body>
	<div align="center">
		<form:form modelAttribute="vehicleDTO">
		<h2 class="text-success">${msg}</h2>
			<h1>Vehicle Form</h1>
			<table>
				<tr>
					<td>Name :</td>
					<td><form:input path="name" /></td>
					<td><form:errors path="name" cssClass="text-danger"></form:errors>
				</tr>
				<tr>
					<td>Type :</td>
					<td><form:select path="type">
							<form:option value="cycle" label="Cycle" />
							<form:option value="motorcycle" label="MotorCycle" />
							<form:option value="fourwheeler" label="Four Wheeler" />
						</form:select></td>
				</tr>
				<tr>
					<td>Vehicle Number :</td>
					<td><form:input path="vehicle_number" /></td>
					<td><form:errors path="vehicle_number" cssClass="text-danger"></form:errors>
				</tr>
				<tr>
					<td>Employee Id :</td>
					<td><form:input path="employee_id" /></td>
					<td><form:errors path="employee_id" cssClass="text-danger"></form:errors>
				</tr>
				<tr>
					<td>Identification :</td>
					<td><form:textarea path="identification" /></td>
					<td><form:errors path="identification" cssClass="text-danger"></form:errors>
				</tr>
			</table>
			<br>
			<button type="submit">Submit</button>
		</form:form>
	</div>
</body>
</html>