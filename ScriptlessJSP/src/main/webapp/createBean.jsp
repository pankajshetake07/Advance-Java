<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="userinfo" class="beans.User" scope="request"/>
	<%-- 
	<jsp:setProperty  name="userinfo" property="uid" value='<%= request.getParameter("uid") %>' />
	--%>
	<%--
	<jsp:setProperty  name="userinfo" property="uid"  />
	<jsp:setProperty  name="userinfo" property="pwd"  />
	<jsp:setProperty  name="userinfo" property="fname" />
	<jsp:setProperty  name="userinfo" property="lname"  />
	<jsp:setProperty  name="userinfo" property="email" param="emailid" />
	<jsp:setProperty  name="userinfo" property="age"  />
	 --%>
	 <jsp:setProperty  name="userinfo" property="*"  />
	 
	<jsp:forward page="displayBean.jsp" />
	
	
</body>
</html>