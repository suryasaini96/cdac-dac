package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.IVendorDao;
import dao.VendorDaoImpl;
import pojos.Vendor;

public class VendorLogin {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory();Scanner sc = new Scanner(System.in)){
			IVendorDao vendorDao = new VendorDaoImpl();
			System.out.print("Enter vendor email and password: ");
			Vendor v = vendorDao.vendorLogin(sc.next(), sc.next());
			if (v!=null)
				System.out.println(v);
			else
				System.out.println("Wrong email or password.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
