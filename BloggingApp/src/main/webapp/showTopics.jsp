<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    
	<c:forEach var="topic" items="${sessionScope.tlist}" >
		<a href="getComments?tid=${topic.topicid}"> ${ topic.name} </a>
		<br/>
	</c:forEach>
	
	<br/>
	<a href="insertTopic.jsp"> Add new topic </a>
</body>
</html>