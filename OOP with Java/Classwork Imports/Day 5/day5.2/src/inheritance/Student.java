package inheritance;

public class Student extends Person {
	// add state of the Student
	// Student --firstName,lastName,grad year,course,fees,marks
	private int gradYear;
	private String courseName;
	private double fees;
	private double marks;

	// add paramterized constr , to init COMPLETE state of the student
	public Student(String fn, String ln, int yr, String courseName, double fees, double marks) {
		// explicitly invoke MATCHING super cls constr
		super(fn, ln);
		System.out.println("in student constr...");
		gradYear = yr;
		this.courseName = courseName;
		this.fees = fees;
		this.marks = marks;

	}

	// override toString : inherited from Person class
	@Override
	public String toString() {
		// complete state of the student
		return "Student " +super.toString() + " passed in " + gradYear + " course " + courseName + " fees " + fees
				+ " marks " + marks;

	}
	//additional functionality 
	
	public void study()
	{
		//firstName studying in coursename
		System.out.println(getFirstName()+" studying in course "+courseName);
		
	}

}
