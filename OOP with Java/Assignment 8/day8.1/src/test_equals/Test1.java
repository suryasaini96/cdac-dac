package test_equals;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.println("Enter details of the 1st vehicle");
			Vehicle v1=new Vehicle(sc.next(), sc.next(), sc.nextDouble());
			System.out.println("Enter details of the 2nd vehicle");
			Vehicle v2=new Vehicle(sc.next(), sc.next(), sc.nextDouble());
			System.out.println(v1==v2);//f
			System.out.println(v1.equals(v2));//using Object's equals  : ref equality : false
		}

	}

}
