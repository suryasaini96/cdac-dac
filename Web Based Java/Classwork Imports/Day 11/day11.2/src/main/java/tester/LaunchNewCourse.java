package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import static java.time.LocalDate.parse;

import org.hibernate.*;

import dao.CourseDaoImpl;
import pojos.Course;

public class LaunchNewCourse {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			CourseDaoImpl courseDao = new CourseDaoImpl();
			System.out.println("Enter course details title,  capacity,  fees,  startDate,  endDate ");
			System.out.println(courseDao.addNewCourse(
					new Course(sc.next(), sc.nextInt(), sc.nextDouble(), parse(sc.next()), parse(sc.next()))));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
