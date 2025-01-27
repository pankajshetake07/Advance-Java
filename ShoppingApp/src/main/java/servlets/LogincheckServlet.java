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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.User;

@WebServlet("/logincheck")
public class LogincheckServlet extends HttpServlet {
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
		//out object
				PrintWriter out = response.getWriter();
				
				//read request parameters
				String uid = request.getParameter("uid");
				String pwd = request.getParameter("pwd");
				
				//step 3 and 4 for jdbc
				PreparedStatement ps = null;
				ResultSet rs = null;
				try {
					ps = con.prepareStatement("select * from users where u_id = ? and password = ?");
					ps.setString(1, uid);
					ps.setString(2, pwd);
					rs = ps.executeQuery();
					if(rs.next()) {
						//login success
						//out.print("<h1> Welcome "+rs.getString(3)+" </h1>");
						
						//loginerror cookie is present - delete the cookie
						Cookie [] allc = request.getCookies();
						if(allc != null) {
							for(Cookie c : allc) {
								if(c.getName().equals("loginerror")){
				    				c.setMaxAge(0);
				    				response.addCookie(c);
				    				break;
				    			}
							}
						}
						
						//set seesion level attribute
						User user = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
						HttpSession session = request.getSession();
						session.setAttribute("loggedinuser", user);
						
						//forwarding						
						RequestDispatcher rd = request.getRequestDispatcher("/home");
						rd.forward(request, response);
					}
					else {
						//login failed
						Cookie c = new Cookie("loginerror","Wrong_ID/password");
						response.addCookie(c);
						response.sendRedirect("/ShoppingApp/login.jsp");
					}
					
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

}
