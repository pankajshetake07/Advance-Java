package listeners;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class ShoppingAppListener implements ServletContextListener {
	Connection con;
	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	try {
    		con.close();    		
    	}
    	catch(Exception e) {
        	e.printStackTrace();
        }
    }

    public void contextInitialized(ServletContextEvent sce)  { 
        try {
        	//jar file - build path - deployment assembly
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		String jdbcurl = sce.getServletContext().getInitParameter("jdbcurl");
    		String user = sce.getServletContext().getInitParameter("user");
    		String pwd = sce.getServletContext().getInitParameter("password");
    		con = DriverManager.getConnection(jdbcurl, user, pwd ); 
    		System.out.println("con established");
    		sce.getServletContext().setAttribute("dbcon", con);
    		System.out.println("con is set as ctx level attribure");
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
    }
	
}
