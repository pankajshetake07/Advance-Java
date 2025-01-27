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
	<jsp:useBean id="currentuser" class="beans.User" scope="request"/>
	<h1> Welcome <jsp:getProperty name="currentuser"  property="fname"  /> </h1>
	
	<p> City : ${currentuser.address.city }  </p>
	<p> Email : ${currentuser.email }  </p>
	<%--  request param  --%>
	<p> request param : ${param.uid } </p>
	<p> first city selected : ${paramValues["workplace"][0] } </p>
	
	
	<%--  request header  --%>
	<p> request header : ${header.host } </p>
	<p> request header : ${ header["user-agent"]}  </p>
	
	<%--  cookie --%>
	<p> Cookie email : ${cookie.emailcookie.value }  </p>
	
	<br/>
	<%--  context params --%>
	<p> For more detail contact at ${initParam.adminemail} </p>
	
	<%-- scope of the bean --%>
	<p> name : ${requestScope.currentuser.fname }  </p>
	
	<hr/>
	
	<p> Workplace selected : ${workplaces["0"] }   </p>
	<p> Workplace selected : ${workplaces["1"] }   </p>
	<p> Workplace selected : ${workplaces["2"] }   </p>
	
	<hr/>
	<ul>
		<c:forEach var="workplace" items="${workplaces}">
			<li>${workplace} </li>
		</c:forEach>
	</ul>
</body>
</html>