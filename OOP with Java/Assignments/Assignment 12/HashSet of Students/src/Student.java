
public class Student {
	String prn;
	String name;
	String email;
	
	public Student(String prn, String name, String email) {
		super();
		this.prn = prn;
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [prn=" + prn + ", name=" + name + ", email=" + email + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Student)
			return this.prn == ((Student)o).prn;
		return false;
	}
	
	@Override
	public int hashCode() {
		return Integer.valueOf(this.prn);
	}
}
