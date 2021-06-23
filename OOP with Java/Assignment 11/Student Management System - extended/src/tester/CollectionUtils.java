package tester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;

import exception.StudentHandlingException;
import main.Course;
import main.Student;
import static main.Student.sdf;
import java.text.ParseException;

public class CollectionUtils {
	
	//3.0
	public static ArrayList<Student> populateSampleData(){
		ArrayList<Student> students = new ArrayList<>();
		try {
			System.out.println("Unique PRN, Name, Email, Password,Course=[DBT,REACT,ANGULAR,REST,SPRING,HIBERNATE], GPA, DOB");
			students.add(new Student("1","Babu Rao","baburao@gmail.com","khopditod","react", 8, "1-4-1973"));
			students.add(new Student("3","Babu Rao","baburao@gmail.com","khopditod","angular", 9, "1-4-1980"));
			students.add(new Student("4","Babu Rao","baburao@gmail.com","khopditod","spring", 10, "1-4-2001"));
			students.add(new Student("5","Babu Rao","baburao@gmail.com","khopditod","react", 7, "1-4-2000"));
			students.add(new Student("2","Babu Rao","baburao@gmail.com","khopditod","react", 3, "1-4-1991"));
		} catch (StudentHandlingException e) {
			System.out.println("Error in sample data " + e);
		}
		return students;
	}
	
	//3.1
	public static void printStudents(String course, String beforeDate, ArrayList<Student> students) {
		try {
			Course c = Course.valueOf(course.toUpperCase());
			Date bd = sdf.parse(beforeDate);
			for (Student s: students) {
				if (s.getCourse().equals(c) && s.getDob().before(bd)) 
					System.out.println(s);
			}
		} catch (ParseException | IllegalArgumentException e) {
			System.out.println("Wrong data entered!");
		}
	}
	
	//3.2
	public static void sortPRN(ArrayList<Student> students) {
		students.sort(null);
		System.out.println("Sorted based on natural ordering on PRN");
	}
	
	//3.3
	public static void sortGPA(ArrayList<Student> students) {
		students.sort(new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return Double.compare(s1.getGpa(), s2.getGpa());
			}
		});
		System.out.println("Sorted based on GPA");
	}
	
	//3.4
	public static void sortCourseAndGPA(ArrayList<Student> students) {
		students.sort(new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				int comparison = s1.getCourse().toString().compareTo(s2.getCourse().toString());
				if (comparison == 0) 
					comparison = Double.compare(s1.getGpa(), s2.getGpa());
				return comparison;
			}
		});
		System.out.println("Sorted based on Course and GPA");
	}
	
	//3.5
	public static void removeFailedStudents(ArrayList<Student> students) {
		Iterator<Student> itr = students.iterator();
		while (itr.hasNext()) {
			if(itr.next().getGpa()<5)
				itr.remove();
		}
		System.out.println("Removed failed students");
	}
	
	//3.5
	public static void reverseOrder(ArrayList<Student> students) {
		students.sort(Collections.reverseOrder());
		for(Student s: students) 
			System.out.println(s);
	}
	
	
}
