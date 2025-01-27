package apps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeSet;

import entities.Emp;

public class ResultSetToCollection {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Set<Emp> emps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/knowitdb","root","root");
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from emp100");
			emps = new TreeSet<>();
			while(rs.next()) {
				//reading one records - converting into Emp instance			
				/*Emp e = new Emp();
				e.setEmpno(rs.getInt(1));*/
				Emp e = new Emp(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDate(5),rs.getFloat(6),rs.getFloat(7),rs.getInt(8));
				emps.add(e);
			}
		}
		catch (ClassNotFoundException e) {			
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
		for(Emp e : emps) {
			System.out.println(e);
		}
		
		
		

	}

}
	
