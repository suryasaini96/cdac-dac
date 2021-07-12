package tester;

import com.app.shapes.BoundedShape;
import com.app.shapes.Circle;
import com.app.shapes.Rectangle;

public class TestShapes {

	public static void main(String[] args) {
		// circle1 : 10,20,10.5 , rect1 : 30 ,40, 12,13 , circle2 : 100,24,30 : hard
		// coded(sample data) : best for testing
		// Display info of shapes n compute are using loop (for-each)
		// dynamic init of array :
		// for prim types
		double[] nums = { 12.34, 1, 23, 45, 90 };
		// dyn init of array : ref types
		BoundedShape[] shapes = { new Circle(10, 20, 10.5),
				new Rectangle(30, 40, 12, 13), new Circle(100, 24, 30) };//1 st : array , c1,r1,c2
		for(BoundedShape s : shapes) 
			System.out.println(s+" Area "+s.area()); //DMD

	}

}
