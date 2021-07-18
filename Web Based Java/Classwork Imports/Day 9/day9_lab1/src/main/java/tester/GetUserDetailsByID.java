package tester;
import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.User;

public class GetUserDetailsByID {

	public static void main(String[] args) {
		//bootstrapping hib frmwork
		try(SessionFactory sf=getFactory();Scanner sc=new Scanner(System.in))
		{
			UserDaoImpl dao=new UserDaoImpl();
			System.out.println("Enter user id");
			User ref=dao.findByUserId(sc.nextInt());
			System.out.println(ref);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
