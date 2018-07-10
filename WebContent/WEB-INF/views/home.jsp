<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact formular</title>
<style>
table {
	border-collapse: collapse;
}

table, th, td {
	padding: 5px;
	margin: 10px;
	font-size: 20px;
	border: 1px solid black;
}
</style>
</head>
<body>
	<h2 align="center" style="color: #DF01010">Please enter your
		contact</h2>
	<hr />

	<h3>
		<span>${error}</span>
	</h3>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<div align="center">
		<form:form action="saveForm" modelAttribute="formSubmitted"
			method="POST">
			<table>
				<tr>
					<td>Name:</td>
					<td><form:input path="name" placeholder="Enter name"></form:input>
						<form:errors path="name"></form:errors></td>
				</tr>
				<tr>
					<td>Surname:</td>
					<td><form:input path="surname" placeholder="Enter surname"></form:input>
						<form:errors path="surname"></form:errors></td>
				</tr>
				<tr>
					<td>Street number:</td>
					<td><form:input path="email" placeholder="Enter email"></form:input>
						<form:errors path="email"></form:errors></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="Submit" ${condition ? 'disable = true' : 'disable = false' }></td>
				</tr>
			</table>
		</form:form>
	</div>
	<hr>
	<div align="right">
		<a href="${contextPath}">Home</a> <br /> Tihomir Puhalo

	</div>
</body>
</html>