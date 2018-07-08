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
		<form:form action="contact" modelAttribute="contactInfo" method="GET">
			<table>
				<tr>
					<td><form:label path="firstName" cssClass="clabel">First name: </form:label></td>
					<td><form:input path="firstName"
							placeholder="Enter first name" cssClass="ciput" /></td>
					<td><form:errors path="firstName" cssClass="cb"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="lastName" cssClass="clabel">Last name: </form:label></td>
					<td><form:input path="lastName"
							placeholder="Enter street number" cssClass="ciput" /></td>
					<td><form:errors path="lastName" cssClass="cb"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="phone" cssClass="clabel">Phone: </form:label></td>
					<td><form:input path="phone" placeholder="Enter city"
							cssClass="ciput" /></td>
					<td><form:errors path="phone" cssClass="cb"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="email" cssClass="clabel">Email: </form:label></td>
					<td><form:input path="email" placeholder="Enter city"
							cssClass="ciput" /></td>
					<td><form:errors path="email" cssClass="cb"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="sex">Sex: </form:label></td>
					<td><form:select path="sex">
							<form:option value="NONE">---SELECT---</form:option>
							<form:options items="${sexList }" />
						</form:select></td>
				</tr>
				<tr>
					<td><form:label path="addresses.name" cssClass="clabel">Street: </form:label></td>
					<td><form:input path="addresses.name"
							placeholder="Enter street name" cssClass="ciput" /></td>
					<td><form:errors path="addresses.name" cssClass="cb"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="addresses.streetNumber" cssClass="clabel">Street number: </form:label></td>
					<td><form:input path="addresses.streetNumber"
							placeholder="Enter street number" cssClass="ciput" /></td>
					<td><form:errors path="address.streetNumber" cssClass="cb"></form:errors></td>
				</tr>
				
				<tr>
					<td><form:label path="addresses.city.name" cssClass="clabel">City: </form:label></td>
					<td><form:input path="addresses.city.city" placeholder="Enter city"
							cssClass="ciput" /></td>
					<td><form:errors path="addresses.city.city" cssClass="cb"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="addresses.city.zipCode" cssClass="clabel">Zip code: </form:label></td>
					<td><form:input path="addresses.city.zipCode" placeholder="Enter zipCode"
							cssClass="ciput" /></td>
					<td><form:errors path="addresses.city.zipCode" cssClass="cb"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="addresses.city.country" cssClass="clabel">Country: </form:label></td>
					<td><form:input path="addresses.city.country" placeholder="Enter country"
							cssClass="ciput" /></td>
					<td><form:errors path="addresses.city.country" cssClass="cb"></form:errors></td>
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