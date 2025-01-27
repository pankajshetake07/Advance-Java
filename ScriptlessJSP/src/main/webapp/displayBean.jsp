<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="userinfo" class="beans.User" scope="request" />
	
	<h1> Welcome <jsp:getProperty property="fname" name="userinfo"/> 
	             <jsp:getProperty property="lname" name="userinfo"/> 
	 </h1>
	 <p> Email :  <jsp:getProperty property="email" name="userinfo"/>  </p>
</body>
</html>