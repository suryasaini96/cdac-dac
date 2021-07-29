package com.app.service;

import java.util.List;

import com.app.pojos.User;

public interface IVendorService {
	List<User> listVendors();
	String deleteVendorDetails(int vendorId);
	String registerNewVendor(User user);//user : TRANSIENT
	User getVendorDetails(int vendorId);
	String updateVendorDetails(User user);//user : DETACHED
}
