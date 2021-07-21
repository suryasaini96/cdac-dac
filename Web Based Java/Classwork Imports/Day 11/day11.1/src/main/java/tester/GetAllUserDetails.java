package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.*;

import dao.UserDaoImpl;

public class GetAllUserDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf();) {
			// create dao instance
			UserDaoImpl dao = new UserDaoImpl();
			dao.getAllUsers().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
