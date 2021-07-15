package utils;

import java.sql.*;

public class DBUtils {
//singleton instance of DB connection
	private static Connection cn;

	public static void openConnection(String drvrClass, String dbURL, String user, String password)
			throws ClassNotFoundException, SQLException {
		if (cn == null) {
			// class loading of JDBC driver :optional currently in Java SE
			Class.forName(drvrClass);
			cn = DriverManager.getConnection(dbURL, user, password);
		}
	}

	public static Connection fetchConnection() {

		return cn;

	}

	// add a static method to close db connection
	public static void closeConnection() throws SQLException {
		if (cn != null)
			cn.close();
	}

}
