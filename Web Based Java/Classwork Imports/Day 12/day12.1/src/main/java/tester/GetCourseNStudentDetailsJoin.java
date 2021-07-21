package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImpl;
import pojos.Course;

public class GetCourseNStudentDetailsJoin {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf();Scanner sc=new Scanner(System.in)) {
			CourseDaoImpl courseDao=new CourseDaoImpl();
			System.out.println("Enter course title to get details");
			Course courseDetails = courseDao.getCourseStudentDetailsJoinQuery(sc.next());
			//course : detached
			System.out.println(courseDetails);
			//display enrolled student details
			System.out.println("Student details");
			courseDetails.getStudents().forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
