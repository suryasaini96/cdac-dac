package tester;

import java.util.Scanner;

import inheritance.Faculty;
import inheritance.Person;
import inheritance.Student;

/*
 * Objective : Arrange an event to invite students n faculties
(eg : EventOrganizer app : tester --main / scanner)
Prompt user for event capacity.

Options 
1. Register Student : 
2. Register Faculty : 
3. Display  details of all registered participants
10. Exit
 */
public class EventOrganizer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter event capacity");
		Person[] participants = new Person[sc.nextInt()];// eg : 100
		boolean exit = false;
		int counter = 0;
		while (!exit) {
			System.out.println("Options 1. Register Student 2. Register Faculty 3. Display all "
					+ "4. Invoke additional functionality10.Exit");
			System.out.println("Choose");
			switch (sc.nextInt()) {
			case 1:// Register Student
				if (counter < participants.length) {
					System.out.println("Enter student details :  fn,  ln,  yr,  courseName,  fees,  marks");
					participants[counter++] = new Student(sc.next(), sc.next(), sc.nextInt(), sc.next(),
							sc.nextDouble(), sc.nextDouble());// up casting
				} else
					System.out.println("Event full!!!!");
				break;
			case 2: // register faculty
				if (counter < participants.length) {
					System.out.println("Enter Faculty details : fn,  ln, yrs, sme");
					participants[counter++] = new Faculty(sc.next(), sc.next(), sc.nextInt(), sc.next());// up casting
				} else
					System.out.println("Event full!!!!");

				break;
			case 3:
				System.out.println("Participant details");
				// for-each
				for (Person p : participants) // p=participants[0],p=participants[1],....
					// {s1,s2,s3,f1,s4,s5,f2,f3,null.....null}
					if (p != null)
						System.out.println(p);// javac : chk by type of the ref(Person : toString) , 1st itr : JVM
												// Student
				// 2nd n 3rd : Student's toString,Faculty's toString ....: run time polymorphism
				// (dynamic method dispatch)
				break;
			/*
			 * Option 4 : User i/p : seat no(1----n) Check if seat no is valid . In case of
			 * valid seat no --- If it's a Student , invoke study method , if it's a Faculty
			 * invoke teach method , o.w : invalid type
			 */
			case 4:
				System.out.println("Enter seat no");//10
				int index = sc.nextInt() - 1;
				if (index >= 0 && index < participants.length) {
					// valid index
					Person p = participants[index];
					// chkeck if it's a student
					if (p instanceof Student)
						((Student) p).study();// {s1,s2,f1,f2,f3.....} seat no : 3
					else if (p instanceof Faculty)
						((Faculty) p).teach();
					else
						System.out.println("Invalid type....");

				} else
					System.out.println("Invalid seat no!!!!!!");
				break;
			case 10:
				exit = true;
				break;
			}
		}

		sc.close();

	}

}
