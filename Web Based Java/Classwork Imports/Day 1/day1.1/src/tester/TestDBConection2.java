package tester;

import static utils.DBUtils.fetchConnection;
import java.sql.*;

public class TestDBConection2 {

	public static void main(String[] args) {
		try (Connection cn = fetchConnection()) {
			System.out.println("cn success "+cn);//toString of Connection impl class : 
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
