package Fruit;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Basket capacity: ");
		int n = sc.nextInt();
		Fruit[] basket = new Fruit[n];
		int i=0,ch=5;
		do {
			System.out.println("1. Apple");
			System.out.println("2. Orange");
			System.out.println("3. Mango");
			System.out.println("4. Display basket");
			System.out.println("5. Exit");
			System.out.println("Enter choice: ");
			if (sc.hasNextInt()) 
				{ch = sc.nextInt(); sc.nextLine();}
			else {System.out.println("Wrong choice! Exited!"); sc.close(); return;}	
			switch (ch) {
			case 1: System.out.println("Name and taste: ");
					Fruit apple = new Apple(sc.next(),sc.next());
					if (i<n) basket[i++] = apple;
					else System.out.println("Basket is full!");
					break;
			case 2: System.out.println("Name and taste: ");
					Fruit orange = new Orange(sc.next(),sc.next());
					if (i<n) basket[i++] = orange;
					else System.out.println("Basket is full!");
					break;
			case 3: System.out.println("Name and taste: ");
					Fruit mango = new Mango(sc.next(),sc.next());
					if (i<n) basket[i++] = mango;
					else System.out.println("Basket is full!");
					break;
			case 4: for (Fruit fruit: basket) 
						if(fruit!=null)
							System.out.println(fruit.toString());
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
