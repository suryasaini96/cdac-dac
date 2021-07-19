package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.IVendorDao;
import dao.VendorDaoImpl;

public class UpdateRegAmount {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory();Scanner sc = new Scanner(System.in)){
			IVendorDao vendorDao = new VendorDaoImpl();
			System.out.print("Enter vendor email and reg. amount offset: ");
			String msg = vendorDao.updateRegAmount(sc.next(), sc.nextDouble());
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
