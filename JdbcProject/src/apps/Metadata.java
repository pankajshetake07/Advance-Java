package apps;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;



public class Metadata {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbcUrl = "jdbc:mysql://localhost:3306/knowitdb";
		Connection con = DriverManager.getConnection(jdbcUrl, "root", "root");
		
		DatabaseMetaData dbmd = con.getMetaData();
		System.out.println("Major version : "+dbmd.getDatabaseMajorVersion());
		System.out.println("Ouetr joins : "+dbmd.supportsOuterJoins());
		System.out.println("Batch updates : "+dbmd.supportsBatchUpdates());
		System.out.println("Driver version : "+dbmd.getDriverMajorVersion());
		
		Statement stmt = con.createStatement();   //no query
		ResultSet rs = stmt.executeQuery("select empno,mgr,deptno from emp");
		
		ResultSetMetaData rsmd = rs.getMetaData();
		System.out.println(rsmd.getColumnCount());
		System.out.println(rsmd.getColumnName(2));
		System.out.println(rsmd.getColumnTypeName(1));

		int n = con.getTransactionIsolation();
		System.out.println("Isolation levels : "+n);
		con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
		n = con.getTransactionIsolation();
		System.out.println("Isolation levels : "+n);
		
		
		
		
		
	}

}
