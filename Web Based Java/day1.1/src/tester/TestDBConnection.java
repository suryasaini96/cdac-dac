package tester;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDBConnection {

	public static void main(String[] args) {
		try {
			// load Type IV JDBC Driver in method area
	//		Class.forName("com.mysql.cj.jdbc.Driver");
			// get fixed DB connection
			//test : DB name
			String url = "jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true";
//url userName password
			Connection connection = DriverManager.getConnection(url, "root", "root");
			System.out.println("Connected to DB " + connection);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
