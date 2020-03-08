<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Uom Data Page</title>
</head>
<body>
	
<h3>Welcome to Uom Data Page</h3>

	<c:choose>
		<c:when test="${!empty list }">
			<table border="1">
				<tr>
					<th>ID</th>
					<th>TYPE</th>
					<th>MODEL</th>
					<th>DESCRIPTION</th>
					<th colspan="3">OPERATIONS</th>
				</tr>
				<c:forEach items="${list }" var="ob">
					<tr>
						<td>${ob.id}</td>
						<td>${ob.uomType}</td>
						<td>${ob.uomModel}</td>
						<td>${ob.uomDesc}</td>
						<td><a href="delete?uId=${ob.id}">DELETE</a></td>
						<td><a href="edit?uId=${ob.id}">EDIT</a></td>
			            <td><a href="view?uId=${ob.id}">VIEW</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			No Data Found!!!
		</c:otherwise>
	</c:choose>
	<h5>${message }</h5>


</body>
</html>