package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.*;

import dao.CourseDaoImpl;
import dao.StudentDaoImpl;
import pojos.Student;

public class CancelCourse {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf();Scanner sc=new Scanner(System.in)) {
			CourseDaoImpl courseDao=new CourseDaoImpl();
			System.out.println("Enter course id cancelling the course");
			System.out.println(courseDao.cancelCourse(sc.nextInt()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
