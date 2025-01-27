package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.result.UpdatableResultSet;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		con = (Connection)config.getServletContext().getAttribute("dbcon");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//primary logic
		PrintWriter out = response.getWriter();
		
		RequestDispatcher rd = request.getRequestDispatcher("/header");
		rd.include(request, response);
		
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from category");
			while(rs.next()) {
				out.print("<a href='http://localhost:8080/ShoppingApp/getProducts?catid="+rs.getInt(1)+"'> "+rs.getString(2)+"</a>");
				out.print("<br/>");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null)
					rs.close();
				if(stmt != null)
					stmt.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
