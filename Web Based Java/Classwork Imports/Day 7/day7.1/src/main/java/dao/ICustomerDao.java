package dao;

import java.sql.SQLException;

import pojos.Customer;

public interface ICustomerDao {
	// method for customer login
	Customer authenticateCustomer(String email, String pwd) throws SQLException;

}
