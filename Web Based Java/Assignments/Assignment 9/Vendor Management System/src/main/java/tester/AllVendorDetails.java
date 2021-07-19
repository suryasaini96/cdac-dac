package tester;

import static utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.SessionFactory;

import dao.IVendorDao;
import dao.VendorDaoImpl;
import pojos.Vendor;

public class AllVendorDetails {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory()){
			IVendorDao vendorDao = new VendorDaoImpl();
			List<Vendor> vendorList = vendorDao.allVendorDetails();
			System.out.println(vendorList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
