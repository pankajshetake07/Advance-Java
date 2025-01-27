package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addtocart")
public class AddtocartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//primary logic
		PrintWriter out = response.getWriter();
		int pid = Integer.parseInt(request.getParameter("selectedP"));
		//cart is available?
		HttpSession session = request.getSession();
		List<Integer> plist = (List<Integer>)session.getAttribute("cart");
		if(plist == null) {
			plist = new ArrayList();
		}
		plist.add(pid);  //0 to 1 - first time,   previous - previous+1 - subsequent 
		session.setAttribute("cart", plist);
		
		out.print("<br/>Selcted product "+ pid+" is added to the cart");
		out.print("<br/>There are "+plist.size()+" product(s) in the cart");
		out.print("<br/> <a href='home'> Go for further selection </a>");
		out.print("<br/> <a href='viewcart.jsp'> View Cart </a>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
