package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.*;

import dao.StudentDaoImpl;
import pojos.Student;

public class StudentAdmission {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf();Scanner sc=new Scanner(System.in)) {
			StudentDaoImpl studentDao=new StudentDaoImpl();
			System.out.println("Enter student details : name email n course title");
			System.out.println(studentDao.admitNewStudent(new Student(sc.next(), sc.next()), sc.next()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
