package pojos;
import javax.persistence.*;

@Embeddable
public class EducationalQualification {
	@Enumerated(EnumType.STRING)
	@Column(length = 20,unique = true)
	private EduType type;
	private int year;
	private int marks;
	public EducationalQualification() {
		// TODO Auto-generated constructor stub
	}
	public EducationalQualification(EduType type, int year, int marks) {
		super();
		this.type = type;
		this.year = year;
		this.marks = marks;
	}
	public EduType getType() {
		return type;
	}
	public void setType(EduType type) {
		this.type = type;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "EducationalQualification [type=" + type + ", year=" + year + ", marks=" + marks + "]";
	}
	
}
