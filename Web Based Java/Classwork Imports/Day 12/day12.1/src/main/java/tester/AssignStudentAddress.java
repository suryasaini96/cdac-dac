package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.*;

import dao.StudentDaoImpl;
import pojos.Address;
import pojos.Student;

public class AssignStudentAddress {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			StudentDaoImpl studentDao = new StudentDaoImpl();
			System.out.println("Enter student id & address details : city,  state,  country");
			System.out.println(
					studentDao.assignStudentAddress(sc.nextInt(), new Address(sc.next(), sc.next(), sc.next())));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
