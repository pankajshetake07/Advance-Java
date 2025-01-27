<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	This is template text
	<br/>
	<h1> Welcome to JSP </h1>
	<br/>
	<!--  This is HTML comment -->
	<%-- This is JSP comment --%>
	<%
		int var = 0;
		out.print("Value of var : "+(++var));
	%>
	<br/>
	<%=  Calendar.getInstance().getTime()  %>
	<br/>
	<%! int n; %>
	<%=  "Value of n: "+(++n)  %>
</body>
</html>