package tester;

import inheritance.Faculty;
import inheritance.Person;
import inheritance.Student;

public class Test4 {

	public static void main(String[] args) {
		//super cls ref, super cls object , sub cls ref, sub class object (Person <-----Student , Faculty)
		//create student class instance
		Student s1=new Student("Rama","Seth", 2019, "eDAC",12345, 78);//direct referencing
		System.out.println(s1.toString());
		//create faculty class instance
		Faculty f1=new Faculty("Raj", "Kulkarni", 10, "java REST angular");//direct referencing
		System.out.println(f1);//how does it internally call f1.toString : Hint : PrintStream : println(Object ref)
		Object p;//super cls ref
	//	System.out.println(p);//un inited 
		p=s1;//Student IS - A Person : up casting (Student ---> Person--->Object) : implicitly done by javac
		System.out.println(p);//p.toString() : javac resolves method binding by type of reference
		//JVM resolves method binding by type of object(instance) it's referring to : run time polymorphism 
		p=f1;//Faculty IS A Person (extends) --up casting
		System.out.println(p);//javac chks : if there is toString method in the Person class ? YESS 
		//JVM : toString() of Faculty : run time polymorphism 
		
	}

}
