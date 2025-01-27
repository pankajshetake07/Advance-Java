package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Address;
import beans.User;

@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//business logic
		//read request parameters
		//db dialog
		//data generate - bean - attribute
		//forward request - jsp
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		int age =  Integer.parseInt(request.getParameter("age"));
		String area = request.getParameter("area");
		String city = request.getParameter("city");
		String pincode = request.getParameter("pincode");
		
		User user = new User(uid,pwd,fname,lname,null,age,new Address(area,city,pincode));
		request.setAttribute("currentuser", user);
		
		Cookie cookie = new Cookie("emailcookie",email);
		response.addCookie(cookie);
		
		String [] workplaces = request.getParameterValues("workplace");
		request.setAttribute("workplaces", workplaces);
		
		RequestDispatcher rd = request.getRequestDispatcher("/view.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
