package beans;

import java.util.List;

import dao.CourseDaoImpl;

public class CourseManagementBean {
	private CourseDaoImpl courseDao;

	public CourseManagementBean() {
		System.out.println("course bean created");
		courseDao = new CourseDaoImpl();
	}

	// B.L method to access all course titles
	public List<String> fetchAllTitles() {
		return courseDao.getAllCourseTitles();
	}

}
