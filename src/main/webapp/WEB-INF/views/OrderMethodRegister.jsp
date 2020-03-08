<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ORDER METHOD REGISTRATION PAGE</title>


</head>
<body  >
<h1>WELCOME TO ORDER METHOD REGISTRATION PAGE</h1>

<form:form action="save" method="post" modelAttribute="orderMethod" >
<pre>	
ORDER MODE        :  <form:radiobutton path="orderMode" value="Sale"/>Sale

                     <form:radiobutton path="orderMode" value="Purchase"/>Purchase   
			
			
ORDER CODE        :	 <form:input path="orderCode"/>
				
				
ORDER METHOD     :	<form:select path="orderMethod">
				
						<form:option value="">--SELECT--</form:option>
						<form:option value="FIFO">FIFO</form:option>
						<form:option value="LIFO">LIFO</form:option>
						<form:option value="FCFO">FCFO</form:option>
						<form:option value="FEFO">FEFO</form:option>
						
					</form:select>
				
ORDER ACCEPT      :	<form:checkbox path="orderAccept" value="Mutli-Model"/>Multi-Model
                    <form:checkbox path="orderAccept" value="AcceptReturn"/>AcceptReturn
				
				
ORDER DESCRIPTION :	<form:textarea path="orderDesc"/>
		          			
				
<input type="submit" value="CREATE" />
			
			
</pre> 
</form:form> 
	
${message}

</body>
</html>