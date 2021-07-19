package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.*;

import dao.UserDaoImpl;
import static java.time.LocalDate.parse;
import static pojos.Role.*;

public class GetSelectedUsersNames {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter start end dates role");
			dao.getSelectedUserNames(parse(sc.next()), parse(sc.next()), valueOf(sc.next().toUpperCase()))
					.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
