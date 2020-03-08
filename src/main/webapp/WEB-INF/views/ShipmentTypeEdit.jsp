<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<H3>WELCOME TO SHIPMENTTYPE EDIT PAGE</H3>
	<form:form action="update" method="POST" modelAttribute="shipmentType">
		<pre>
SHIPMENT ID:
<form:input path="shipId" readonly="true" />
SHIPMENT MODE:
<form:select path="shipMode">
<form:option value="">--SELECT--</form:option>
<form:option value="Air">Air</form:option>
<form:option value="Truck">Truck</form:option>
<form:option value="Ship">Ship</form:option>
<form:option value="Train">Train</form:option>
</form:select>
SHIPMENT CODE:
<form:input path="shipCode" />
ENABLE SHIPMENT:
<form:select path="enbShip">
<form:option value="">--SELECT--</form:option>
<form:option value="Yes">YES</form:option>
<form:option value="No">NO</form:option>
</form:select>
SHIPMENT GRADE:
<form:radiobutton path="shipGrad" value="A" />A
<form:radiobutton path="shipGrad" value="B" />B
<form:radiobutton path="shipGrad" value="C" />C
DESCRIPTION:
<form:textarea path="shipDesc" />

<input type="submit" value="Update">
</pre>

	</form:form>
</body>
</html>