package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	// Singleton for making a JDBC connection
	private static Connection conn;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if (conn == null) {
			// Optional: Loading the class in method area
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Getting the connection
			String db = "bookshop";
			String url = "jdbc:mysql://localhost:3306/$db?useSSL=false&allowPublicKeyRetrieval=true".replace("$db", db);
			conn = DriverManager.getConnection(url, "root", "root");
			return conn;
		}
		return conn;	
	}
	
}
