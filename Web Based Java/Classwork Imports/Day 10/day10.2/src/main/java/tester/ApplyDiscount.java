package tester;

import static utils.HibernateUtils.getSf;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.*;

import dao.UserDaoImpl;

public class ApplyDiscount {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter date(yr-mon-day) discount");
			System.out.println(dao.applyDiscount(LocalDate.parse(sc.next()),sc.nextDouble()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
