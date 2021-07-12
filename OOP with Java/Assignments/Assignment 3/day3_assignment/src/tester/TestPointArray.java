package tester;

import java.util.Scanner;

import com.geometry.Point2D;

public class TestPointArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many points to plot?");
		int n = sc.nextInt();
		Point2D[] points = new Point2D[n];
		for (int i=0; i<n; i++) {
			System.out.println("Enter X and Y: ");
			points[i] = new Point2D(sc.nextInt(), sc.nextInt());
		}
		for (Point2D point: points) 
			System.out.println(point.getDetails());
		
		sc.close();
	}

}
