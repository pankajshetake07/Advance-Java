package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class GetProductsServlet
 */
@WebServlet("/getProducts")
public class GetProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	    con = (Connection)config.getServletContext().getAttribute("dbcon");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// primary logic
		PrintWriter out = response.getWriter();
		
		RequestDispatcher rd = request.getRequestDispatcher("/header");
		rd.include(request, response);
		
		int cid =  Integer.parseInt(request.getParameter("catid"));
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("select * from product where cat_id = ?");
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			out.print("<form action='addtocart'>");
			out.print("Select product : ");
			out.print("<select name='selectedP'>");
			while(rs.next()) {
				out.print("<option value='"+rs.getInt(1)+"'>"+rs.getString(2)+"</option>");
			}			
			out.print("</select> <br/>");
			out.print("<input type='submit' value='Add to cart' />");
			out.print("</form>");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!= null)
					rs.close();
				if(ps != null)
					ps.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
