package com.app.dao;

import java.util.List;

import com.app.pojos.User;

public interface IVendorDao {
	List<User> listVendors();
	String deleteVendorDetails(User user);
	User getVendorDetails(int vendorId);
	String registerNewVendor(User user);//user : TRANSIENT
	String updateVendorDetails(User user);//user : DETACHED
}
