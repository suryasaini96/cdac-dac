package main;

import java.text.SimpleDateFormat;
import java.util.Date;

import exception.StudentHandlingException;
import java.text.ParseException;

public class Student implements Comparable<Student>{
	String prn;
	String name;
	String email;
	String password;
	Course course;
	double gpa;
	Date dob;
	
	public static SimpleDateFormat sdf;
	
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
	
	@Override
	public int compareTo(Student otherStudent) {
		return this.getPrn().compareTo(otherStudent.getPrn());
	}

	public String getPrn() {
		return prn;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Course getCourse() {
		return course;
	}

	public double getGpa() {
		return gpa;
	}

	public Date getDob() {
		return dob;
	}

	public static SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setPrn(String prn) {
		this.prn = prn;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}

	public static void setSdf(SimpleDateFormat sdf) {
		Student.sdf = sdf;
	}
	
	
}
