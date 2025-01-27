package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.User;

@WebServlet("/confirmcart")
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	    con = (Connection)config.getServletContext().getAttribute("dbcon");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//primary logic
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		PreparedStatement ps = null;
		//insert - shopping
		User user = (User)session.getAttribute("loggedinuser");
		String uid = user.getUid();
		
		Date cdate = new java.util.Date();		
		
		float tprice = (Float)session.getAttribute("tprice");
		
		String query = "insert into shopping(user_id, shoppingDate,totalprice) values(?,?,?)";
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, uid);
			ps.setTimestamp(2,  new Timestamp(cdate.getTime()));
			ps.setFloat(3,tprice);
			int n = ps.executeUpdate();
			if(n == 1) {
				out.print("<p> Order is confirmed </p>");
				out.print("<p> Bill will be mailed at "+user.getEmail()+" </p>");
				out.print("<p> You will recive the meassage on "+user.getContact()+"before order delivery </p>");
				out.print("<br/> <a href='logout'> LOGOUT </a>");
			}
			else {
				out.print("<p> Order is not confirmed </p>");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(ps != null)
					ps.close();
			}
			catch(Exception e) {
				
			}
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
