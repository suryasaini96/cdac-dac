package dao;

import pojos.Student;

public interface IStudentDao {
//student admission
	String admitNewStudent(Student student, String courseTitle);

	// cancel student admission
	String cancelAdmission(String email, String courseTitle);
}
