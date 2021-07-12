package tester;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Add Box class into "com.app.core"
Create a tester class  : TestBoxArray : "com.app.tester"

Objective : Ask user(client) , how many boxes to make ?
Accept Box dims 

Store these details suitably.
1. Display using single for-each loop, box dims n volume
 */
import com.app.core.Box;

public class TestBoxArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Box[] boxes;// boxes : array type of a ref ---> an array object which can hold Box type
					// refs.
		System.out.println("How many boxes to make?");
		boxes=new Box[sc.nextInt()];//cls : [Lcom.app.core.Box
		System.out.println("loaded cls name for array "+boxes.getClass().getName());
		System.out.println("Contents "+Arrays.toString(boxes));
		for(int i=0;i<boxes.length;i++)
		{
			System.out.println("Enter Box dims w d h");
			boxes[i]=new Box(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
		}
		//Display using single for-each loop, box dims n volume
		for(Box b : boxes)//b=boxes[0],b=boxes[1]
		{
			System.out.println(b.getBoxDetails()+" volume "+b.getBoxVolume());			
		}
		System.out.println("Contents "+Arrays.toString(boxes));
		
		// Modifying width for boxes for volume > 100
		for (Box b: boxes) {
			if (b.getBoxVolume()>100) 
				b.setWidth(b.getWidth()*2);
		}
		
		for(Box b : boxes)//b=boxes[0],b=boxes[1]
		{
			System.out.println(b.getBoxDetails()+" volume "+b.getBoxVolume());			
		}
		System.out.println("Contents "+Arrays.toString(boxes));
		
		sc.close();

	}

}
