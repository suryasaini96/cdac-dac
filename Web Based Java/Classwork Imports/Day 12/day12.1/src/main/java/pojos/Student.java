package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "students_tbl")
public class Student extends BaseEntity {
	@Column(length = 20)
	private String name;// built in data type : value type : Basic value type
	@Column(length = 20, unique = true)
	private String email;
	// many to one bi dir association
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id") // to specify name of the FK column
	private Course selectedCourse;
	// one to one asso between entity n value type , uni dir from entity ---> value
	// type
	@Embedded // optional , added only for clarity
	private AdharCard card;
	// one to many between entity(Student) ---> collection of basic value types (uni
	// , from entity ---> value)
	@ElementCollection // MANDATORY (otherwise hibernate throws Mapping Exc)
	@CollectionTable(name = "student_hobbies", joinColumns = @JoinColumn(name = "student_id")) // OPTIONAL BUT reco.
	@Column(length = 20,name="hobby")
	private List<String> hobbies = new ArrayList<>();
	//uni dir one to many asso between entity(Student) --->composite val type(Edu qualification)
	@ElementCollection
	@CollectionTable(name = "student_qualifications",joinColumns =@JoinColumn(name="student_id") )
	private List<EducationalQualification> qualifications=new ArrayList<>();

	public Student() {
		System.out.println("in student ctor");
	}

	public Student(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	// all setters n getters
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

	public AdharCard getCard() {
		return card;
	}

	public void setCard(AdharCard card) {
		this.card = card;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	

	public List<EducationalQualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<EducationalQualification> qualifications) {
		this.qualifications = qualifications;
	}

	@Override
	public String toString() {
		return "Student id=" + getId() + "[name=" + name + ", email=" + email + "]";
	}

}
