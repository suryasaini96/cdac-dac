package tester;

import java.util.Scanner;

import com.geometry.Point2D;

public class TestPointArrayMenuDriven {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many points to plot?");
		int n=0;
		if (sc.hasNextInt()) 
			n = sc.nextInt();
		else 
			{ System.out.println("Invalid input"); sc.close(); return; }
		Point2D[] points = new Point2D[n];
		int ch;
		do {
			System.out.println("1. Plot a new point");
			System.out.println("2. Display all points plotted so far");
			System.out.println("3. Test equality of 2 points");
			System.out.println("4. Calculate distance");
			System.out.println("10. Exit");
			System.out.println("Enter choice: ");
			if (sc.hasNextInt()) 
				ch = sc.nextInt();
			else 
				{ System.out.println("Invalid input"); ch=10;}
			int index,i1,i2;
			switch (ch) {
			case 1: System.out.println("Enter index,x,y");
					index = checkIndex(sc.nextInt(), n);
					if (index!=-1) {
						points[index] = new Point2D(sc.nextInt(), sc.nextInt());
					}else {
						System.out.println("Invalid index!");
						ch = 10;
					}
					break;
			case 2: int i = 0;
					for(Point2D point: points) {
						if(point!=null)
							System.out.println("Point" + ++i + ": " + point.getDetails());
					}
					break;
			case 3: System.out.println("Enter indexes of points:");
					i1 = checkIndex(sc.nextInt(), n);
					i2 = checkIndex(sc.nextInt(), n);
					if (points[i1]!=null && points[i2]!=null) {
						boolean eq = points[i1].isEqual(points[i2]);
						System.out.println("Are they equal?: " + eq);
					}else {
						System.out.println("Invalid indexes!");
						ch = 10;
					}
					break;
			case 4: System.out.println("Enter indexes of points:");
					i1 = checkIndex(sc.nextInt(), n);
					i2 = checkIndex(sc.nextInt(), n);
					if (points[i1]!=null && points[i2]!=null) {
						double d = points[i1].calculateDistance(points[i2]);
						System.out.printf("%.2f", d); System.out.println();
					} else {
						System.out.println("Invalid indexes!");
						ch = 10;
					}
					break;
			case 10: System.out.println("Exited.");
					 break;
			default: ch=10; break;	
			}		
			
		}while(ch!=10);
		
		sc.close();

	}
	
	static int checkIndex(int i, int n) {
		if (i>=0 && i<n) return i;
		return -1;
	}

}
