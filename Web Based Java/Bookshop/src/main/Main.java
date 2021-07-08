package main;

import java.util.Scanner;
import static tester.UserUtils.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to the Bookshop!");
		boolean exit = false;
		try (Scanner sc = new Scanner(System.in)){
			while(!exit) {
				System.out.println("1. User Login");
				System.out.println("2. New User Registration");
				System.out.println("3. Exit");
				switch(sc.nextInt()) {
				case 1: System.out.print("Enter email and password: ");
						userLogin(sc.next(),sc.next());
						break;
				case 2: System.out.println("Enter new user details:");
						System.out.println("(String name, String email, String password, double reg_amt, String reg_date, String role) :");
						userRegistration(sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next());
						break;
				case 3: System.out.println("Exited");
				default: exit = true;
						break;
				}
			}
		}
	}
}
