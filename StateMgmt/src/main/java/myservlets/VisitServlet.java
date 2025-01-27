package myservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visit")
public class VisitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int n = 0;
		Cookie [] allc = request.getCookies();
		if(allc != null) {
			for(Cookie c : allc) {
				if(c.getName().equals("visitcount")) {
					n = Integer.parseInt(c.getValue());
					break;
				}
			}
		}		
		n++;
		Cookie c = new Cookie("visitcount", ""+n);
		response.addCookie(c);
		out.print("<p> Visit count : "+n+"</p>");
		out.print("<a href='visit'> REFRESH </a>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
