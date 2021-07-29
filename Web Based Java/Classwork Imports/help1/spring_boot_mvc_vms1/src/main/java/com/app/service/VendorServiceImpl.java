package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IVendorDao;
import com.app.pojos.Role;
import com.app.pojos.User;

@Service
@Transactional
public class VendorServiceImpl implements IVendorService {
	// dependency
	@Autowired
	private IVendorDao vendorDao;

	@Override
	public List<User> listVendors() {
		return vendorDao.listVendors();
	}

	@Override
	public String deleteVendorDetails(int vendorId) {
		//chk if vendor exists by a soecified id
		User vendor=vendorDao.getVendorDetails(vendorId);
		if(vendor != null)
			return vendorDao.deleteVendorDetails(vendor);
		return "Vendor details deletion failed : Invalid Vendor Id";
	}

	@Override
	public String registerNewVendor(User user) {
		// assign vendor role n then invoke dao's method for persistence
		user.setRole(Role.VENDOR);
		return vendorDao.registerNewVendor(user);
	}

	@Override
	public User getVendorDetails(int vendorId) {
		// TODO Auto-generated method stub
		return vendorDao.getVendorDetails(vendorId);
	}

	@Override
	public String updateVendorDetails(User user) {
		user.setRole(Role.VENDOR);
		return vendorDao.updateVendorDetails(user);
	}
	
	

}
