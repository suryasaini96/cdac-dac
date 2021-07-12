package tester;

import inheritance.Faculty;
import inheritance.Person;
import inheritance.Student;

public class Test2 {

	public static void main(String[] args) {
		//create student class instance
		//super cls ref can DIECTLY  (w/o type castin) refer to sub class instance : up casting
		//Person p----> Student class instance
		Person p=new Student("Rama","Seth", 2019, "eDAC",12345, 78);//up casting
		//JVM invokes the method using type of the object (Student) : overriding form (sub class)
		System.out.println(p);//dyn method dispatch
//		p.study();
		((Student)p).study();//down casting is done to satisfy javac 
		p=new Faculty("Raj", "Kulkarni", 10, "java REST angular");//up casting
		System.out.println(p);//JVM : Faculty's toString : DMD(dyn method dispatch)
		((Faculty)p).teach();//since javac resolves by type of the ref (ie. Person) : no teach()
		//use explicit type casting : down casting
		
	}

}
