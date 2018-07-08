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
		<form:form action="address" modelAttribute="addressInfo" method="GET">
			<table>
				<tr>
					<td><form:label path="street" cssClass="clabel">Street: </form:label></td>
					<td><form:input path="street" placeholder="Enter street name"
							cssClass="ciput" ></form:input></td>
					<td><form:errors path="street" cssClass="cb"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="streetNumber" cssClass="clabel">Street number: </form:label></td>
					<td><form:input path="streetNumber" placeholder="Enter street number" cssClass="ciput" ></form:input> </td>
					<td><form:errors path="streetNumber" cssClass="cb"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="city">city: </form:label></td>
					<td><form:select path="city">
							<form:option value="NONE">---SELECT---</form:option>
							<form:options items="${cityList }" />
						</form:select></td>
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