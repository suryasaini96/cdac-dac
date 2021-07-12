package com.app.tester;

import java.util.Scanner;

import com.app.org.*;

public class TestOrganization{
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Number of employees: ");
		int n = sc.nextInt();
		Emp[] employees = new Emp[n];
		int i=0,ch=5;
		do {
			System.out.println("1. Hire Manager");
			System.out.println("2. Hire Worker");
			System.out.println("3. Display information");
			System.out.println("4. Update performance bonus or hourly rate");
			System.out.println("5. Exit");
			System.out.println("Enter choice: ");
			if (sc.hasNextInt()) 
				{ch = sc.nextInt(); sc.nextLine();}
			else {System.out.println("Wrong choice! Exited!"); sc.close(); return;}	
			switch (ch) {
			case 1: System.out.println("Mgr(int id, String name, String deptId, double basic, double performanceBonus)");
					Emp mgr = new Mgr(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble(), sc.nextDouble());
					if (i<n) employees[i++] = mgr;
					else System.out.println("No more employees!");
					break;
			case 2: System.out.println("Worker(int id, String name, String deptId, double basic, double hoursWorked, double hourlyRate)");
					Emp worker = new Worker(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
					if (i<n) employees[i++] = worker;
					else System.out.println("No more employees!");
					break;
			case 3: for (Emp employee: employees) { 
						if (employee instanceof Mgr) 
							System.out.println(((Mgr)employee).toString());
						else if (employee instanceof Worker) 
							System.out.println(((Worker)employee).toString());
					}
					break;		
			case 4: System.out.println("Enter performance bonus and hourly rate: ");
					double pb = sc.nextDouble();
					double hr = sc.nextDouble();
					for (Emp employee: employees) { 
						if (employee instanceof Mgr) 
							((Mgr) employee).setPerformanceBonus(pb);
						else if (employee instanceof Worker) 
							((Worker) employee).setHourlyRate(hr);
					}
					break;
			
			case 5: System.out.println("Exited.");
					ch=5; break;
			default: System.out.println("Wrong choice!");
					break;	
			}
		}while(ch!=5);
		sc.close();
	}
}