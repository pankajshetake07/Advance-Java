package apps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class StoredProcedureCall {

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbcUrl = "jdbc:mysql://localhost:3306/knowitdb";
		Connection con = DriverManager.getConnection(jdbcUrl, "root", "root");
		
		CallableStatement cs = con.prepareCall("{call getSalary(?,?)}");
		System.out.println("Enter emp no ");
		int eno = Integer.parseInt(br.readLine());
		cs.setInt(1, eno);
		cs.registerOutParameter(2, Types.FLOAT);
		
		cs.execute();
		System.out.println("Salary : "+cs.getFloat(2));

		cs.close();
		con.close();

	}

}
