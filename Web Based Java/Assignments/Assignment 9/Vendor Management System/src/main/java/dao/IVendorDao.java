package dao;

import java.time.LocalDate;
import java.util.List;

import pojos.Vendor;

public interface IVendorDao {
	String addVendorDetails(Vendor v);
	Vendor vendorDetailsByID(long vendorId);
	List<Vendor> allVendorDetails();
	String updateRegAmount(String email, double regAmountOffset);
	Vendor vendorLogin(String email, String password);
	String deleteVendorDetails(double regAmount, LocalDate regDate);
}
