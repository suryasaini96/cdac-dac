package com.app.service;

import java.util.List;

import com.app.pojos.User;

public interface IUserService {
	User validateUser(String email, String password);

	// add a method for listing all vendors
	List<User> getAllVendors();

	// delete vendor details
	String deleteVendorDetails(int vendorId);

	// register new vendor
	String registerVendor(User vendor);

}
