package tester;

import static utils.HibernateUtils.getSf;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.*;

import dao.UserDaoImpl;
import pojos.Role;
import pojos.User;

public class AddUserDetails {

	public static void main(String[] args) {
		// bootstrapping hib frmwork
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDaoImpl userDao = new UserDaoImpl();

			System.out.println(
					"Enter user details  name,  email,  password,  role,  confirmPassword,  regAmount,	 regDate(yyyy-MM-dd)");
			// create a transient instance
			User user = new User(sc.next(), sc.next(), sc.next(), 
					Role.valueOf(sc.next().toUpperCase()), sc.next(),
					sc.nextDouble(), LocalDate.parse(sc.next()));
			// invoke dao's method
			System.out.println("status " + userDao.saveUserDetails(user));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
