package pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="courses_tbl")
public class Course extends BaseEntity {
	@Column(length = 20,unique = true)
	private String title;
	private int capacity;
	private double fees;
	@Column(name = "start_date")
	private LocalDate startDate;
	@Column(name = "end_date")
	private LocalDate endDate;
	// one to many , bi-dir association between Course 1<------>* Student
	@OneToMany(mappedBy = "selectedCourse",
			cascade = CascadeType.ALL, orphanRemoval = true/* ,fetch = FetchType.EAGER */)//mappedBy : mandatory , MUST appear in inverse side,
	//value --- name of the property as it appears on the owning side.
	private List<Student> students = new ArrayList<>();

	public Course() {
		System.out.println("in course ctor");
	}

	public Course(String title, int capacity, double fees, LocalDate startDate, LocalDate endDate) {
		super();
		this.title = title;
		this.capacity = capacity;
		this.fees = fees;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	// all setters n getters

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	//add helper methods : to link n de-link
	public void addStudent(Student student)
	{
		//parent --> child
		students.add(student);
		//child --> parent
		student.setSelectedCourse(this);		
	}
	public void removeStudent(Student student)
	{
		//parent ----X  -----> child
		students.remove(student);
		//child --X--> parent
		student.setSelectedCourse(null);		
	}
	

	@Override
	public String toString() {
		return "Course id " + getId() + " [title=" + title + ", capacity=" + capacity + ", fees=" + fees
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}
