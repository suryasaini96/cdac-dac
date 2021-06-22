package tester;


import java.util.ArrayList;
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
				System.out.println("4. Cancel admission");
				System.out.println("5. Update GPA");
				System.out.println("6. Exit");
				System.out.println("Enter choice: ");
				ch = sc.nextInt();
				String prn;
				Student student;
				switch (ch) {
				case 1: System.out.println("Enter Student(String prn, String name, String email, String password, String course, double gpa, String dob) ");
						System.out.println("Unique PRN, Name, Email, Password,Course=[DBT,REACT,ANGULAR,REST,SPRING,HIBERNATE], GPA, DOB");
						prn = sc.next();
						student = new Student(prn);
						if (!students.contains(student)) {
							Student s = new Student(prn,sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next());
							students.add(s);
						}else 
							throw new StudentHandlingException("Invalid PRN!");
						break;
				case 2: System.out.println("Enter PRN to fetch details: ");
						prn = sc.next();
						student = new Student(prn);
						if (students.contains(student))
							System.out.println(students.get(students.indexOf(student)));
						else
							throw new StudentHandlingException("Invalid PRN!");
						break;
				case 3: for(Student s: students) 
								System.out.println(s);
						break;
				case 4: System.out.println("Enter PRN to remove student (cancel admission): ");
						prn = sc.next();
						student = new Student(prn);
						if (students.contains(student)) {
							students.remove(student);
							System.out.println("Student removed.");
						} else 
							throw new StudentHandlingException("Invalid PRN!");
						break;
				case 5: System.out.println("Enter PRN and GPA to update");
						prn = sc.next();
						student = new Student(prn);
						double gpa = sc.nextDouble();
						if (students.contains(student)) {
							int index = students.indexOf(student);
							students.get(index).setGpa(gpa);
							System.out.println("GPA updated.");
						}
						else 
							throw new StudentHandlingException("Invalid PRN!");
						break;
				default: ch=6;
						System.out.println("Exited.");
						break;
				}
			}while(ch!=6);
		} catch (StudentHandlingException e) {
			System.out.println(e.getMessage());
		}
	}
}
