package dao;

import java.util.List;

import pojos.Vendor;

public interface IVendorDao {
	String addVendorDetails(Vendor v);
	Vendor vendorDetails(long vendorId);
	List<Vendor> allVendorDetails();
	void updateRegAmount(double regAmount);
}
