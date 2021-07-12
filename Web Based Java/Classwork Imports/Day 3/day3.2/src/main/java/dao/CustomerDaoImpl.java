package dao;

import java.sql.*;

import pojos.Customer;
import static utils.DBUtils.fetchConnection;

public class CustomerDaoImpl implements ICustomerDao {
	// state
	private Connection cn;
	private PreparedStatement pst1;

	// def ctor
	public CustomerDaoImpl() throws ClassNotFoundException, SQLException {
		cn = fetchConnection();
		// pst : for customer authentication query
		pst1 = cn.prepareStatement("select * from customers where email=? and password=?");
		System.out.println("customer dao created....");

	}

//int id, String name, String email, String password, double regAmount, Date regDate, String role) {
	@Override
	public Customer authenticateCustomer(String email, String pwd) throws SQLException {
		// set IN params
		pst1.setString(1, email);
		pst1.setString(2, pwd);
		try (ResultSet rst = pst1.executeQuery()) {
			if (rst.next())
				return new Customer(rst.getInt(1), rst.getString(2), email, pwd, rst.getDouble(5), rst.getDate(6),
						rst.getString(7));
		}
		return null;
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		System.out.println("customer dao cleaned up!");
	}

}
