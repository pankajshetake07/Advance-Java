package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/viewcart")
public class ViewcartServlet extends HttpServlet {
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
		List<Integer> plist = (List<Integer>)session.getAttribute("cart");
		if(plist == null) {
			out.print("Cart is empty");
		}
		else {
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement("select * from product where p_id = ?");
				out.print("<table border=1>");
				float total = 0;
				for(int pid : plist) {
					ps.setInt(1, pid);
					rs = ps.executeQuery();
					rs.next();
					out.print("<tr>");
					out.print("<td>"+rs.getString(2)+"</td>");
					out.print("<td>"+rs.getString(3)+"</td>");
					float pr = rs.getFloat(4);
					out.print("<td>"+pr+"</td>");
					out.print("<td> <a href='deletefromcart?pid="+pid+"'> delete </a> </td>");
					total += pr;
					out.print("</tr>");
				}
				out.print("<tr>");
				out.print("<td colspan='2'> Total Price </td>");
				out.print("<td>"+total+"</td>");
				out.print("</tr>");
				out.print("</table>");
				session.setAttribute("tprice", total);				
				out.print("<br/> <a href='home'> Go for further selection </a>");
				out.print("<br/> <a href='confirmcart'> Confirm Cart </a>");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally{
				try {
					if(rs != null)
						rs.close();
					if(ps != null)
						ps.close();
				}
				catch(Exception e) {
					
				}
			}
			
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
