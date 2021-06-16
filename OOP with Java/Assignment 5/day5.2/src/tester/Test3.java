package tester;

import inheritance.Faculty;
import inheritance.Person;
import inheritance.Student;

public class Test3 {

	public static void main(String[] args) {
		// create student class instance
		// super cls ref can DIECTLY (w/o type castin) refer to sub class instance : up
		// casting
		// Person p----> Faculty  class instance
		Person p =new Faculty("Raj", "Kulkarni", 10, "java REST angular");
				//new Student("Rama", "Seth", 2019, "eDAC", 12345, 78);// up casting
		// instanceof : keyword : checking RTTI (run time type information)
		if (p instanceof Faculty)// IS A testing @ run time
			((Faculty) p).teach();// fooling the compiler : no javac err, run time err : ClassCastException
		// Student can't be cast into Faculty
		else
			System.out.println("Invalid type : Not a faculty.....");

	}

}
