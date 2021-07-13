package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection conn;
	
	public static Connection fetchConnection() {
		if (conn == null) {
			try {
				// Loading the jdbc drivers in method area
				Class.forName("com.mysql.cj.jdbc.Driver");
				String db = "election";
				String url = "jdbc:mysql://localhost:3306/$db?useSSL=false&allowPublicKeyRetrieval=true".replace("$db",db);
				conn = DriverManager.getConnection(url, "root", "root");
				return conn;
			} catch(SQLException | ClassNotFoundException e) {
				System.out.println("Database access error!");
			}
		}
		return conn;
	}
	
	public static void closeConnection() {
		try {
			if (conn!=null)
				conn.close();
		} catch(SQLException e) {
			System.out.println("Database access error!");
		}
	}
}
