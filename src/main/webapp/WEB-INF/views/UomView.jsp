<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME TO UOM VIEW PAGE</h3>
<table border="1">
<tr>
   <th>UOM ID  </th><td>${ob.id}</td>
</tr>
<tr>
   <th>UOM TYPE</th><td>${ob.uomType}</td>
</tr>
<tr>
   <th>UOM MODEL</th><td>${ob.uomModel}</td>
</tr>
<tr>
   <th>DESCRIPTION</th><td>${ob.uomDesc}</td>
</tr>
</table>
</body>
</html>