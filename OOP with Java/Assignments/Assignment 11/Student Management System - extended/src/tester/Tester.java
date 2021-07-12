package tester;


import java.util.ArrayList;
import java.util.Scanner;

import exception.StudentHandlingException;
import main.Student;
import static tester.CollectionUtils.*;

public class Tester {
	 public static void main(String[] args) {
		 ArrayList<Student> students = new ArrayList<Student>();
		try (Scanner sc = new Scanner(System.in)){
		boolean exit = false;
		while(!exit) {
			System.out.println("1. Add student details");
			System.out.println("2. Fetch student details");
			System.out.println("3. Display all student details");
			System.out.println("4. Cancel admission");
			System.out.println("5. Update GPA");
			System.out.println("6. Print names of students in a specific course with DOB before a specific date");
			System.out.println("7. Sort in asc. order of PRN");
			System.out.println("8. Sort student details as per GPA ");
			System.out.println("9. Sort student details as per Course & GPA");
			System.out.println("10. Remove details of failed students (GPA<5)");
			System.out.println("11. Display details of the student in reverse order.");
			System.out.println("12. Exit");
			System.out.println("Enter choice: ");
			try {
				String prn;
				Student student;
				switch (sc.nextInt()) {
					case 1: students = populateSampleData();
							System.out.println("Added sample student details");
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
							
					case 6: System.out.println("Enter course and before date: ");
							printStudents(sc.next(),sc.next(),students);
							break;
					case 7: sortPRN(students);
							break;
					case 8: sortGPA(students);
							break;
					case 9: sortCourseAndGPA(students);
							break;
					case 10: removeFailedStudents(students);
							break;
					case 11: reverseOrder(students);
							break;
					case 12:
					default: exit=true;
							System.out.println("Exited.");
							break;
					}
				}catch (StudentHandlingException e) {
					System.out.println(e.getMessage());
				}
				sc.nextLine();
			} 
		}
	 }	
}
