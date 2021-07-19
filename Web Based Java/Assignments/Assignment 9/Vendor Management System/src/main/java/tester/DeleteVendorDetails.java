package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.IVendorDao;
import dao.VendorDaoImpl;

public class DeleteVendorDetails {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory();Scanner sc = new Scanner(System.in)){
			IVendorDao vendorDao = new VendorDaoImpl();
			System.out.println("Reg. amount is less than entered value and reg. date is greater than entered date.");
			System.out.print("Enter reg. amount and reg. date (yyyy-MM-dd): ");
			String msg = vendorDao.deleteVendorDetails(sc.nextDouble(), LocalDate.parse(sc.next()));
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
