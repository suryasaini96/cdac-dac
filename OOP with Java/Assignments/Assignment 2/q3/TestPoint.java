package q3;

import java.util.Scanner;

public class TestPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Point1");
        System.out.println("Enter x & y coordinates: ");
        Point2D p1 = new Point2D(sc.nextInt(), sc.nextInt());
        System.out.println("Point2");
        System.out.println("Enter x & y coordinates: ");
        Point2D p2 = new Point2D(sc.nextInt(), sc.nextInt());
        System.out.println("Point1: " + p1.getDetails());
        System.out.println("Point2: " + p2.getDetails());
        System.out.println("Is point1 equal to point2? : " + p1.isEqual(p2));
        Point2D p3 = p1.createNewPoint(p1.x, p1.y);
        System.out.println("Point3: " + p3.getDetails());
        System.out.println("Distance between Point1 and Point3: " + p1.calculateDistance(p3));
    }
}
