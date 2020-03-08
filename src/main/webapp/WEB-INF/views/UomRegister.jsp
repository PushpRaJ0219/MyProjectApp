<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Uom Registration Page</title>


</head>
<body>
	<h3>WELCOME TO UOM REGISTER PAGE</h3>
<form:form action="save" method="POST" modelAttribute="uom">

<pre> 
Uom Type       :  <form:select path="uomType">
                    <form:option value="">--SELECT--</form:option>
                    <form:option value="PACKAGING">PACKAGING</form:option>
                    <form:option value="NO">NO</form:option>
                    <form:option value="PACKING">PACKING</form:option>
                    <form:option value="">--NA--</form:option>
                  </form:select> 
    
Uom Model      :  <form:input path="uomModel" />
                
                              
Description    :  
                  <form:textarea path="uomDesc" />
               
               
<input type="submit" value="CREATE UOM" />
			
			
</pre>
</form:form>
<h5>${msg}</h5>

</body>
</html>