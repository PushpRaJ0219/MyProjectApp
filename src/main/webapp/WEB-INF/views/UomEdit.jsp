<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UOM EDIT PAGE</title>
</head>
<body>
	<h3>WELCOME TO UOM EDIT PAGE</h3>
<form:form action="update" method="POST" modelAttribute="uom">
<pre>
Uom Id         : <form:input path="id" readonly="true"/>   
                 

Uom Type       : <form:select path="uomType">
                  <form:option value="">-SELECT-</form:option>
                  <form:option value="PACKAGING">PACKAGING</form:option>
                  <form:option value="NO">NO</form:option>
                  <form:option value="PACKING">PACKING</form:option>
                  <form:option value="">-NA-</form:option>
                 </form:select> 
    
Uom Model      : <form:input path="uomModel" />
                                           
Description   : <form:textarea path="uomDesc"/>
               
               
<input type="submit" value="UPDATE" />
</pre>
</form:form>
${message}
</body>
</html>