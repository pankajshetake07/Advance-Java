<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
    	Cookie [] allc = request.getCookies();
    	if(allc != null){
    		for(Cookie c : allc){
    			if(c.getName().equals("loginerror")){
    				out.print("<p style='color:red'>"+c.getValue()+"</p>");
    				break;
    			}
    		}
    	}
    %>
    <!--  <p style='color:red'> ${cookie.loginerror.value } </p> -->
    
	<form action="http://localhost:8080/ShoppingApp/logincheck" method="post">
	   Enter uid : 
	   <input type="text" name="uid" />
	   <br/>
	   Enter pwd : 
	   <input type="password" name="pwd" />
	   <br/>
	   <input type="submit" value="LOGIN" />
	</form>
	<br/>
	<a href="http://localhost:8080/FirstWeb/register.html"> New User? Register here</a>
	<br/>
</body>
</html>