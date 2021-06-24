import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		HashSet<Student> students = new HashSet<>();
		students.add(new Student("1","Babu Rao","baburao@gmail.com"));
		students.add(new Student("1","Babu Rao","baburao@gmail.com"));
		students.add(new Student("1","Babu Rao","baburao@gmail.com"));
		System.out.println(students);
	}
}
