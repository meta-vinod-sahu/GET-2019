<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>Pass Details</title>
</head>
<body>
	<div align="center">
		<form:form modelAttribute="planDTO">
			<p>1. Select Plans in (USD)</p>
			<form:select path="plan">
				<form:options items="${priceList}" />
				<form:errors path="plan"></form:errors>
			</form:select>
			<br>
			<br>
			<p>2. Do You Want To Change Currency</p>
			<form:select path="currency" align="center">
				<form:option value="USD" label="USD" />
				<form:option value="INR" label="INR" />
				<form:option value="YEN" label="YEN" />
				<form:errors  path="currency" ></form:errors>
			</form:select>
			<button type="submit">GetPass</button>
		</form:form>
	</div>