package main;

import java.text.SimpleDateFormat;
import java.util.Date;

import exception.StudentHandlingException;
import java.text.ParseException;

public class Student {
	String prn;
	String name;
	String email;
	String password;
	Course course;
	double gpa;
	Date dob;
	
	private static SimpleDateFormat sdf;
	
	static {
		sdf = new SimpleDateFormat("dd-MM-yyyy");
	}
	
	public Student(String prn, String name, String email, String password, String course, double gpa, String dob) throws StudentHandlingException{
		super();
		try {
			this.prn = prn;
			this.name = name;
			this.email = email;
			this.password = password;
			this.course = Course.valueOf(course.toUpperCase());
			this.gpa = gpa;
			this.dob = sdf.parse(dob);
		} catch (ParseException | IllegalArgumentException e) {
			throw new StudentHandlingException("Invalid details!");
		}
	}
	
	public Student(String prn) {
		super();
		this.prn = prn;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (prn == null) {
			if (other.prn != null)
				return false;
		} else if (!prn.equals(other.prn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [prn=" + prn + ", name=" + name + ", email=" + email + ", password=" + password + ", course="
				+ course + ", gpa=" + gpa + ", dob=" + sdf.format(dob) + "]";
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
}
