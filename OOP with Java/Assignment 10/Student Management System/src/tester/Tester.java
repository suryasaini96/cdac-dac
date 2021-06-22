package tester;


import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import exception.StudentHandlingException;
import main.Student;

public class Tester {
	 public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();
		int ch;
		try (Scanner sc = new Scanner(System.in)){
			do {
				System.out.println("1. Add student details");
				System.out.println("2. Fetch student details");
				System.out.println("3. Dispaly all student details");
				System.out.println("4. Dispaly all student details");
				System.out.println("5. Dispaly all student details");
				System.out.println("6. Exit");
				System.out.println("Enter choice: ");
				ch = sc.nextInt();
				switch (ch) {
				case 1: System.out.println("Enter Student(String prn, String name, String email, String password, String course, double gpa, String dob) ");
						System.out.println("Unique PRN, Name, Email, Password,Course=[DBT,REACT,ANGULAR,REST,SPRING,HIBERNATE], GPA, DOB");
						String prn = sc.next();
						Student unique = new Student(prn);
						if (!students.contains(unique)) {
							Student s = new Student(prn,sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next());
							students.add(s);
						}else 
							throw new StudentHandlingException("Invalid PRN!");
						break;
				case 2: System.out.println("Enter PRN to fetch details: ");
						String fetch = sc.next();
						Student student = new Student(fetch);
						if (students.indexOf(student) > -1)
							System.out.println(students.get(students.indexOf(student)));
						break;
				case 3: for(Student s: students) 
								System.out.println(s);
						break;
				default: ch=6;
						break;
				}
			}while(ch!=6);
		} catch (StudentHandlingException e) {
			System.out.println(e.getMessage());
		}
	}
}
