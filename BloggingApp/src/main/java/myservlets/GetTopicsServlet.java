package myservlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Topic;

@WebServlet("/getTopics")
public class GetTopicsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		con = (Connection)config.getServletContext().getAttribute("dbcon");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//business logic
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from topic");
			Set<Topic> topics = new HashSet<>();
			while(rs.next()) {
				Topic t = new Topic(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				topics.add(t);
			}
			request.getSession().setAttribute("tlist", topics);
			RequestDispatcher rd = request.getRequestDispatcher("/showTopics.jsp");
			rd.forward(request, response);
			
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
