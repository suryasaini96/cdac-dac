package test_equals2;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.println("Enter details of the 1st vehicle");
			Object v1=new Vehicle(sc.next(), sc.next(), sc.nextDouble());//up casting
			System.out.println("Enter details of the 2nd vehicle");
			Object v2=new Vehicle(sc.next(), sc.next(), sc.nextDouble());
			System.out.println(v1.equals(v2));//using Object's equals  : ref equality : false
			String s="hello";
			System.out.println(v1.equals(s));//String IS A Object (up casting)
		}

	}

}
