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

@WebServlet(
		urlPatterns = { "/dbt" }, 
		initParams = { 
				@WebInitParam(name = "subject", value = "Database technologies")
		})
public class DbtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
