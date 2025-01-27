package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.User;

/**
 * Servlet implementation class HeaderServlet
 */
@WebServlet("/header")
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//primary logic
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loggedinuser");
		String name = "";
		if(user!=null) {
			 name = user.getFname()+" "+user.getLname();
		}
		else {
			name="GUEST";
		}
		out.print("<h1> Welcome "+name+"</h1>");
		out.print("<br/> <hr/>");		
		
	}

}
