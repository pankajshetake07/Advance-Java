package apps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollableUpdatableDemo {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbcUrl = "jdbc:mysql://localhost:3306/knowitdb";
		Connection con = DriverManager.getConnection(jdbcUrl, "root", "root");
		
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery("select * from emp100");
		rs.afterLast();
		while(rs.previous()) {
			System.out.println(rs.getInt(1)+" : "+rs.getFloat(6));
		}
		System.out.println("**************");
		rs.absolute(5);
		System.out.println(rs.getInt(1)+" : "+rs.getString(2));
		rs.relative(3);
		System.out.println(rs.getInt(1)+" : "+rs.getString(2));
		
		rs.updateFloat(7, 800.0f);    //
		rs.updateRow();  //changes reflected in database
		System.out.println("Row updated");
		
		rs.close();
		stmt.close();
		con.close();

	}

}
