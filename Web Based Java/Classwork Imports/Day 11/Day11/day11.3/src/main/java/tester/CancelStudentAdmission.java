package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.*;

import dao.StudentDaoImpl;
import pojos.Student;

public class CancelStudentAdmission {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf();Scanner sc=new Scanner(System.in)) {
			StudentDaoImpl studentDao=new StudentDaoImpl();
			System.out.println("Enter student email n course title for cancelling the admssion");
			System.out.println(studentDao.cancelAdmission(sc.next(), sc.next()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
