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
	<h2> Contact List </h2>
	<table border="1">
	   <c:forEach var="contact" items="${clist }">
			<tr>	
				<td> ${contact.cid } </td>
				<td> ${contact.uid } </td>
				<td> ${contact.password } </td>
				<td> ${contact.fname } </td>
				<td> ${contact.lname } </td>
				<td> ${contact.email } </td>
				<td> ${contact.contactno } </td>
				<td> <a href="editcontact?cid=${contact.cid }"> edit </a> </td>
				<td> <a href="deletecontact?cid=${contact.cid}"> delete </a> </td>
			</tr>
		</c:forEach>
	</table>
	
	<br/>
	<a href="create"> Create new contact </a>
	
</body>
</html>