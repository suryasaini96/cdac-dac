package Fruit;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Basket capacity: ");
		int n = sc.nextInt();
		Fruit[] basket = new Fruit[n];
		int i=0,ch;
		do {
			System.out.println("1. Apple");
			System.out.println("2. Orange");
			System.out.println("3. Mango");
			System.out.println("4. Display basket");
			System.out.println("5. Exit");
			System.out.println("Enter choice: ");
			ch = sc.nextInt();
			String name,taste;
			switch (ch) {
			case 1: System.out.println("Name and taste: ");
					name = sc.next(); sc.nextLine();
					taste = sc.next();
					Fruit apple = new Apple(name,taste);
					if (i<n) basket[i++] = apple;
					else {System.out.println("Basket is full!"); ch=5;}
					break;
			case 2: System.out.println("Name and taste: ");
					name = sc.next(); sc.nextLine();
					taste = sc.next();
					Fruit orange = new Orange(name, taste);
					if (i<n) basket[i++] = orange;
					else {System.out.println("Basket is full!"); ch=5;}
					break;
			case 3: System.out.println("Name and taste: ");
					name = sc.next(); sc.nextLine();
					taste = sc.next();
					Fruit mango = new Mango(name, taste);
					if (i<n) basket[i++] = mango;
					else {System.out.println("Basket is full!"); ch=5;}
					break;
			case 4: for (Fruit fruit: basket) 
						System.out.println(fruit.toString());
					break;
			case 5: System.out.println("Exited.");
					ch=5; break;
			default: System.out.println("Wrong choice!");
					ch=5; break;	
			}
		}while(ch!=5);
	}
	
	

}
