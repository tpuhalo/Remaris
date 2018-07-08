<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adresar</title>
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

cb {
	font-size: 10px;
	font-color: red
}
</style>
</head>
<body>
	<h2 align="center" style="color: #DF01010">Adresar</h2>
	<hr />
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<div align="center">
		<form:form action="saveEditAddress" modelAttribute="editAddress"
			method="POST">
			<table>
				<tr>
					<td>Street:</td>
					<td><form:input path="street" placeholder="Enter street name"
							cssClass="ciput"></form:input> <form:errors path="street"
							cssClass="cb"></form:errors></td>
				</tr>
				<tr>
					<td>Street number:</td>
					<td><form:input path="streetNumber"
							placeholder="Enter street number" cssClass="ciput"></form:input>
						<form:errors path="streetNumber" cssClass="cb"></form:errors></td>
				</tr>
				<tr>
					<td>City:</td>
					<td><select name="cities">
							<c:forEach items="${cities}" var="city">
								<option value="${city.id}">${city.name} ${city.zipCode},
									${city.country.name}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="Submit"></td>
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