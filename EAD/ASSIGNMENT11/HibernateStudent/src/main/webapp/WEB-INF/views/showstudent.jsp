<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<c:set var="pageTitle" scope="request" value="Students" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      <div class="container" style="margin-top: 60px">
	<div class="card">
		<div class="card-header">
			<h3 class="card-title">Students</h3>
		</div>
		<div class="card-body">
			<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Father's Name</th>
						<th>Email</th>
						<th>Class</th>
						<th>Age</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${students}" var="student">
						<tr>
							<td>${student.firstName}</td>
							<td>${student.lastName}</td>
							<td>${student.fatherName}</td>
							<td>${student.email}</td>
							<td>${student.studentClass}</td>
							<td>${student.studentAge}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
		</div>
	</div>
	<div align = "center">
	<a href = "home" >Return To Homepage</a></div>
</div>
</body>
</html>