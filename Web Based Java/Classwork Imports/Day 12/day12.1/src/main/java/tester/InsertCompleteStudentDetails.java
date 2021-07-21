package tester;

import static utils.HibernateUtils.getSf;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.*;

import dao.StudentDaoImpl;
import pojos.AdharCard;
import pojos.EduType;
import pojos.EducationalQualification;
import pojos.Student;

public class InsertCompleteStudentDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf();Scanner sc=new Scanner(System.in)) {
			StudentDaoImpl studentDao=new StudentDaoImpl();
			System.out.println("Enter student email");
			String email=sc.nextLine();
			System.out.println("Enter adhar card details : cardNumber,  creationDate,  location");
			AdharCard card=new AdharCard(sc.next(), LocalDate.parse(sc.next()), sc.next());
			System.out.println("Enter 2 hobbies");
			List<String> hobbies=new ArrayList<>();
			for(int i=0;i<2;i++)
				hobbies.add(sc.next());
			System.out.println("Enter 2 important qualifications");
			List<EducationalQualification> quals=new ArrayList<>();
			for(int i=0;i<2;i++) {
				System.out.println("Enter edu qualifiation details : type,  year,  marks");
				quals.add(new EducationalQualification(EduType.valueOf(sc.next()),sc.nextInt(), sc.nextInt()));
			}
			System.out.println(studentDao.addCompleStudentDetails(email, card, hobbies, quals));
			
			
			
			
				
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
