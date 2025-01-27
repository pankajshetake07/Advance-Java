package apps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedCall {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbcUrl = "jdbc:mysql://localhost:3306/knowitdb";
		Connection con = DriverManager.getConnection(jdbcUrl, "root", "root");

		String query = "select * from emp100 where sal between ? and ?";
		PreparedStatement ps = con.prepareStatement(query);
	   	ps.setFloat(1, 1000.0f);
	   	ps.setFloat(2, 5000.0f);
	   	
	   	ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" : "+rs.getFloat(6));
		}
		rs.close();
		ps.close();
		con.close();
				
	}

}
