package dao;

import pojos.Course;

public interface ICourseDao {
//launch net course
	String addNewCourse(Course course);

	// cancel course
	String cancelCourse(int courseId);

	// get course details
	Course getCourseDetails(String title);

	// get course n details details
	Course getCourseStudentDetails(String title);

	// get course n details details
	Course getCourseStudentDetailsJoinQuery(String title);
}
