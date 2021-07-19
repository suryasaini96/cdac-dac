package tester;
import static utils.HibernateUtils.*;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.IVendorDao;
import dao.VendorDaoImpl;
import pojos.Vendor;

public class VendorDetailsByID {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory();Scanner sc = new Scanner(System.in)){
			IVendorDao vendorDao = new VendorDaoImpl();
			System.out.print("Enter vendor ID: ");
			Vendor v = vendorDao.vendorDetailsByID(sc.nextInt());
			System.out.println(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
