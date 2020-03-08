<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ORDER METHOD DATA PAGE</title>

</head>
<body>

	<h3>WELCOME TO ORDER METHOD DATA PAGE</h3>

	<c:choose>
		<c:when test="${!empty list }">
			<table border="1">
				<tr>
					<th>ID</th>
					<th>MODE</th>
					<th>CODE</th>
					<th>METHOD</th>
					<th>ACCEPT</th>
					<th>DESCRIPTION</th>
					<th colspan="3">OPERATION</th>
					
				</tr>
				<c:forEach items="${list }" var="ob">
					<tr>
						<td>${ob.orderId }</td>
						<td>${ob.orderMode }</td>
						<td>${ob.orderCode }</td>
						<td>${ob.orderMethod }</td>
						<td>${ob.orderAccept }</td>
						<td>${ob.orderDesc }</td>
						<td><a href="delete?omid=${ob.orderId }">DELETE</a></td>
						<td><a href="edit?omid=${ob.orderId }">EDIT</a></td>
						<td><a href="view?omid=${ob.orderId }">VIEW</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			No Data Found!!!
		</c:otherwise>
	</c:choose>
	<h5>${message}</h5>


</body>
</html>