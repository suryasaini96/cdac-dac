package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.*;

import dao.StudentDaoImpl;
import pojos.Address;
import pojos.Student;

public class UpdateCity {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			StudentDaoImpl studentDao = new StudentDaoImpl();
			System.out.println("Update address details : student id & new city");
			System.out.println(
					studentDao.updateCity(sc.nextInt(), sc.next()));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
