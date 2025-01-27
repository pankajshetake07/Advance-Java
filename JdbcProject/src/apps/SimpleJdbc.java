package apps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleJdbc {

	public static void main(String[] args) {
		//1. loading driver class in memory
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//1. loading driver class in memory
			//register iteself with drivermanager(static block)
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbcurl = "jdbc:mysql://localhost:3306/knowitdb";
			//2. establishing the connection
			con = DriverManager.getConnection(jdbcurl, "root", "root");
			System.out.println("connection established");
			//DriverManager.registerDriver(null);
			stmt = con.createStatement();   //no query
			/*rs = stmt.executeQuery("select empno,mgr,deptno from emp");
			while(rs.next()) {
				/*System.out.print(rs.getInt(1) + ":");
				System.out.print(rs.getString(2)+" : ");
				System.out.print(rs.getString(3)+" : ");
				System.out.print(rs.getInt(4)+" : ");
				System.out.print(rs.getDate(5)+" : ");
				System.out.print(rs.getFloat(6)+" : ");
				System.out.print(rs.getFloat(7)+" : ");
				System.out.print(rs.getInt(8));
				System.out.print(rs.getInt(1) + ":");
				System.out.print(rs.getInt(2)+" : ");
				System.out.print(rs.getInt(3)+" : ");
				System.out.println();
			}*/
		    int n = stmt.executeUpdate("update emp set sal = 3333.0 where empno = 7521");
			System.out.println(n+ " records updated");
		
		} catch (ClassNotFoundException e) {			
			//e.printStackTrace();
			System.out.println("driver not loaded");
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("connection rejected");
		}
		finally {
			try {
				if(rs != null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(con!= null)
					con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}

}
