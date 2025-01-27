<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.text.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	   SimpleDateFormat sdf = new SimpleDateFormat("HH");
	   String hours = sdf.format(Calendar.getInstance().getTime());
	   int h = Integer.parseInt(hours);
	   if(h > 6 && h < 12) {  %>
		   <%= "<h1> Good Morning</h1>" %>
	  <% }
	   else if(h >= 12 && h < 16){  %>
		   <%= "<h1> Good Afternoon</h1>" %>
	   <%}
	   else if(h >= 16 && h <= 20){ %>
		   <%= "<h1> Good Evening</h1>" %>
	  <%}
	   else { %>
		   <%=  "<h1> Good Night</h1>" %>
	  <% }	   
	%>
</body>
</html>