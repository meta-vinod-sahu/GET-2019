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
<title>Image Upload Page</title>
</head>
<body>
<h4>Upload Here:</h4>
	<form:form modelAttribute="imageDTO">
		<table>
			<tr>
				<td>Image Link</td>
				<td><form:input path="imageURL" /></td>
				<td><form:errors path="imageURL" cssClass="text-danger"></form:errors>
			</tr>
		</table>
		<br><button type="submit">Upload</button>
	</form:form>
</body>
</html>