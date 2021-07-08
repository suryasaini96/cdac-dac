package tester;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import static utils.DBUtils.*;

public class UserUtils {
	
	public static void userLogin(String email, String password) {
		String sql = "select * from customers where email=? and password=?";
		try (
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		){
			ps.setString(1, email);
			ps.setString(2, password);
			try(ResultSet rs = ps.executeQuery();){
				while(rs.next()) {
					System.out.println("Welcome " + rs.getString(2));
					System.out.println("Your details are: ");
					System.out.println("ID:" + rs.getString(1) + " Email:" + rs.getString(3) + " Reg.Amt: " + rs.getDouble(5) + " Reg.Date: " + rs.getDate(6) + " Type: " + rs.getString(7));
				}
					
			}catch(SQLException e) {
				System.out.println("Wrong details!");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void userRegistration(String name, String email, String password, double reg_amt, String reg_date, String role) {
		String sql1 = "insert into customers(name,email,password,reg_amt,reg_date,role) "
				+ "values(?,?,?,?,?,?)";
		
		String sql = "insert into customers(name,email,password,reg_amt,reg_date,role) "
				+ "values('$name','$email','$password',$reg_amt,'$reg_date','$role')"
				.replace("$name", name).replace("$email", email).replace("$password", password)
				.replace("$reg_amt", Double.toString(reg_amt)).replace("$reg_date", reg_date)
				.replace("$role", role);
		try(
			Connection conn = getConnection();
			Statement st = conn.createStatement();
			//PreparedStatement ps = conn.prepareStatement(sql);
		){
//			ps.setString(1, name);
//			ps.setString(2, email);
//			ps.setString(3, password);
//			ps.setDouble(4, reg_amt);
//			ps.setDate(5, Date.valueOf(reg_date));
//			ps.setString(6, role);
			
			try {
				//if(ps.executeUpdate(sql)!=0) {
				if (st.executeUpdate(sql)!=0) {
					System.out.println("Data added successfully");
				}
			}catch(SQLException e) {
				System.out.println("Wrong details!");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
