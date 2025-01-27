<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="controller">
		Enter uid :
		<input type="text" name="uid" />
		<br/>
		Enter pwd :
		<input type="text" name="pwd" />
		<br/>
		Enter fname :
		<input type="text" name="fname" />
		<br/>
		Enter lname :
		<input type="text" name="lname" />
		<br/>
		Enter email :
		<input type="text" name="email" />
		<br/>
		Enter age :
		<input type="number" name="age" />
		<br/>
		Enter area : 
		<input type="text" name="area" />
		<br/>
		Enter city : 
		<input type="text" name="city" />
		<br/>
		Enter pincode : 
		<input type="text" name="pincode" />
		<br/>
		Select workplace :
		<select name="workplace" multiple>
			<option value="pune">Pune</option>
			<option value="mumbai">Mumbai</option>
			<option value="delhi">Delhi</option>
			<option value="bangalore">Bangalore</option>			
		</select>
		
		<input type="submit" value="Submit Info" />
		
	</form>
</body>
</html>