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
</style>
</head>
<body>
	<h2 align="center" style="color: #DF01010">Adresar</h2>
	<hr />
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<div align="center">
		<form:form action="country" modelAttribute="countryInfo" method="GET">
			<table>
			<tr>
					<td><form:label path="name" cssClass="clabel">Country: </form:label></td>
					<td><form:input path="name"
							placeholder="Enter country name" cssClass="ciput" /></td>
					<td><form:errors path="name" cssClass="cb"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="alpha2" cssClass="clabel">Alpha2: </form:label></td>
					<td><form:input path="alpha2"
							placeholder="Enter alpha2" cssClass="ciput" /></td>
					<td><form:errors path="alpha2" cssClass="cb"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="alpha3" cssClass="clabel">Alpha3: </form:label></td>
					<td><form:input path="alpha3"
							placeholder="Enter alpha3" cssClass="ciput" /></td>
					<td><form:errors path="alpha3" cssClass="cb"></form:errors></td>
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