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
<h3>WELCOME TO ORDER METHOD VIEW PAGE</h3>
<table border="1">
<tr>
   <th>ORDER ID         </th><td>${ob.orderId}</td>
</tr>
<tr>
   <th>ORDER MODE       </th><td>${ob.orderMode}</td>
</tr>
<tr>
   <th>ORDER CODE       </th><td>${ob.orderCode}</td>
</tr>
<tr>
   <th>ORDER METHOD     </th><td>${ob.orderMethod}</td>
</tr>
<tr>
   <th>ORDER ACCEPT     </th><td>${ob.orderAccept}</td>
</tr>
<tr>
   <th>ORDER DESCRIPTION</th><td>${ob.orderDesc}</td>
</tr>
</table>
</body>
</html>