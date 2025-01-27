package logic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WPServlet
 */
@WebServlet(
		urlPatterns = { "/wp" }, 
		initParams = { 
				@WebInitParam(name = "subject", value = "Web Programming")
		})
public class WPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// primary logic
		// config param
		//context param
		ServletConfig config = getServletConfig();
		String sub = config.getInitParameter("subject");
		ServletContext ctx = getServletContext();
		String provider = ctx.getInitParameter("center");
				
		PrintWriter out = response.getWriter();
		out.print("<h1> Training on "+sub+" by "+provider);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
