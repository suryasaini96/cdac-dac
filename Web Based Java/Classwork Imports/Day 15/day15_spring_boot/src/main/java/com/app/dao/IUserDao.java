package com.app.dao;

import java.util.List;

import com.app.pojos.User;

public interface IUserDao {
	//add a method for user login
	User validateUser(String email,String password);
	//add a method for listing all vendors
	List<User> getAllVendors();
	//delete vendor details
	String deleteVendorDetails(User vendor);
	//get vendor details from it's PK
	User findByUserId(int userId);
	//register new vendor
	String registerVendor(User vendor);

}
