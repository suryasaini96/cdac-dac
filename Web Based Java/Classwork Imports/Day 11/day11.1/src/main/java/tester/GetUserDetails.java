package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.*;

import dao.UserDaoImpl;

public class GetUserDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter user id  ,to get details");
			System.out.println(dao.getUserDetails(sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
