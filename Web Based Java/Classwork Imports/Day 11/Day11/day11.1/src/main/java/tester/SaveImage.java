package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.*;

import dao.UserDaoImpl;

public class SaveImage {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter email n file path");
			System.out.println(dao.saveImage(sc.next(), sc.next()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
