package tester;

import inheritance.Faculty;
import inheritance.Student;

public class Test1 {

	public static void main(String[] args) {
		//create student class instance
		Student s1=new Student("Rama","Seth", 2019, "eDAC",12345, 78);
		System.out.println(s1.toString());
		//create faculty class instance
		Faculty f1=new Faculty("Raj", "Kulkarni", 10, "java REST angular");
		System.out.println(f1);//how does it internally call f1.toString : Hint : PrintStream : println(Object ref)

	}

}
