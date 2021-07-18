package utils;

import java.sql.*;

public class DBUtils {

	private static Connection cn;

	
	public static Connection fetchConnection() throws SQLException, ClassNotFoundException {

		if (cn == null) {
			// class loading of JDBC driver :optional currently in Java SE
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true";

			// get fixed DB connection
			cn = DriverManager.getConnection(url, "root", "akashandkd1");

		}
		return cn;
	}

	// add a static method to close DB connection
	public static void closeConnection() throws SQLException {
		if (cn != null)
			cn.close();

		System.out.println("Connection closed...");
	}
}
