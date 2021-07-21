package dao;

import java.util.List;

import pojos.Address;
import pojos.AdharCard;
import pojos.EducationalQualification;
import pojos.Student;

public interface IStudentDao {
//student admission
	String admitNewStudent(Student student, String courseTitle);

	// cancel student admission
	String cancelAdmission(String email, String courseTitle);
	//assign student address
	String assignStudentAddress(int studentId,Address address);
	//update city
	String updateCity(int studentId,String newCity);
	//add complete student details (adhar card , hobbies, qualifications)
	String addCompleStudentDetails(String email,AdharCard card,
			List<String> hobbies,List<EducationalQualification> qualifications);
}
