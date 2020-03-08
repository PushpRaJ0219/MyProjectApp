<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WhUserType Registration Page</title>

</head>
<body  >
<h1>Welcome to WhUserType Registration Page</h1>


<form action="save" method="post">
<pre> 	
			
<h4>USER TYPE :</h4>   <input type="radio" name="userType" value="Vendor"> Vendor  <input type="radio" name="userType" value="Customer"> Customer
					   
<h4>USER CODE :</h4>   <input type="text" name="userCode" placeholder="Enter User Code" />
					
<!-- <h4>USER FOR :</h4>    <input type="text" name="userFor" placeholder="Purchase/Sale" readOnly="readonly" />
 -->								
<h4>USER MAIL :</h4>   <input type="text" name="userMail" placeholder="Enter User eMail" />
									
<h4>USER CONTACT :</h4> <input type="text" name="userContact" placeholder="Enter User Contact No." />
											
<h4>USER ID TYPE :</h4>	<select name="userIdType">
						   <option>--SELECT--</option>
						   <option>PAN CARD</option>
						   <option>ADHAR CARD</option>
						   <option>VOTER ID</option>
						   <option>OTEHR</option>
					    </select>	
								
					
<h4>* IF OTHER :</h4>	<input type="text" name="otherIdType" placeholder="Enter OTHER " />
										
<h4>ID Number :</h4>	<input type="text" name="IDNumber" placeholder="ID Number" />
							
<input type="submit" value="CREATE USER" >
											
</pre> 
</form> 
	<h5>${message }</h5>

</body>
</html>