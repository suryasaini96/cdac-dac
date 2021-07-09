package tester;

import static utils.DBUtils.fetchConnection;

import java.sql.*;
import java.util.Scanner;



public class TestPreparedStatement {

	public static void main(String[] args) {
		String sql="select empid,name,salary,join_date from my_emp where deptid=? and join_date between ? and ?";
		try (Scanner sc=new java.util.Scanner(System.in);
				//establish fixed db cn
				Connection cn = fetchConnection();
				//create pre parsed n pre compile stmt object : java.sql.PreparedStatement
				PreparedStatement pst=cn.prepareStatement(sql);
				
				) {
				System.out.println("Enter deptid n start n end date(year-mon-day)");
				//SET IN parameters
				//1 , 2, 3 : IN param index (placeholder pos , counted from left ---> right 1 onwards)
				pst.setString(1, sc.next());//deptid
				pst.setDate(2,Date.valueOf(sc.next()));//start date
				pst.setDate(3,Date.valueOf(sc.next()));//end date
				try(ResultSet rst=pst.executeQuery())
				{
					//cursor : before the 1st row
					while(rst.next())
						System.out.printf("Emp Id %d Name %s Salary %.1f Join date %s %n"
								,rst.getInt(1),rst.getString(2),rst.getDouble(3),rst.getDate(4));
				}
				
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
