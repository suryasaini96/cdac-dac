package tester;

import static utils.DBUtils.fetchConnection;
import java.sql.*;

public class TestStatement {

	public static void main(String[] args) {
		try (// get fixed db connection
				Connection cn = fetchConnection();
				// create empty statement
				Statement st = cn.createStatement();
				// execute query : executeQuery(sql)
				ResultSet rst = st.executeQuery("select * from my_emp");) {
			// iterate over RST n display details
			System.out.println("All emp's details");
			while(rst.next())
				System.out.printf("EmpId %d Name %s Salary %.1f Joined on %s %n"
						,rst.getInt(1),rst.getString(2),rst.getDouble(4),rst.getDate(6));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
