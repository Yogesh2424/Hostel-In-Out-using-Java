package yogesh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {
	public static Statement connectDB()
	{
		Statement st = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Driver is registered");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_project_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
			//System.out.println("Connected to database");
			st = conn.createStatement();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return st;
	}
}
