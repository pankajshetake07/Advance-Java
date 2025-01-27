<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,java.util.*"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1> View Cart JSP </h1>
     <%
       Connection con = (Connection)application.getAttribute("dbcon");
       List<Integer> plist = (List<Integer>)session.getAttribute("cart");
       if(plist == null){ %>
    	   <h2> Cart is empty </h2>
       <% }
       else {
    	   PreparedStatement ps = null;
		   ResultSet rs = null;
		   ps = con.prepareStatement("select * from product where p_id = ?"); %>
		   <table border="1">
		   <%
		   float total = 0;
		   for(int pid : plist){
			    ps.setInt(1, pid);
			    rs = ps.executeQuery();
			    rs.next(); %>
			    <tr>
			       <td>  <%= rs.getString(2) %> </td>
			       <td> <%= rs.getString(3) %> </td>
			       <td>  <%= rs.getFloat(4) %> </td>
			    </tr>
		   <%
		        total += rs.getFloat(4);
		      }
		   %>
		   <tr> 	
		   		<td colspan="2"> Total price </td>
		   		<td>  <%= total %></td>
		   </tr>
		   </table>
       <%}
     %>
     <br/> <a href='home'> Go for further selection </a>
     <br/> <a href='confirmcart'> Confirm Cart </a>
</body>
</html>