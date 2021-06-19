package test_dates;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.println("Enter vehicle details : regno clr price date");
			Vehicle v1=new Vehicle(sc.next(), sc.next(),sc.nextDouble(), null);
			//no ready made parsing func exists in Scanner.
		}

	}

}
