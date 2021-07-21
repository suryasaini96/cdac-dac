package pojos;
import javax.persistence.*;

@Entity
@Table(name="students_tbl")
public class Student extends BaseEntity {
	@Column(length = 20)
	private String name;
	@Column(length = 20,unique = true)
	private String email;
	//many to one bi dir association
	@ManyToOne
	@JoinColumn(name = "course_id") //to specify name of the FK column
	private Course selectedCourse;
	public Student() {
		System.out.println("in student ctor");
	}
	public Student(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	//all setters n getters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Course getSelectedCourse() {
		return selectedCourse;
	}
	public void setSelectedCourse(Course selectedCourse) {
		this.selectedCourse = selectedCourse;
	}
	@Override
	public String toString() {
		return "Student id="+getId()+"[name=" + name + ", email=" + email + "]";
	}
	
	
	

}
