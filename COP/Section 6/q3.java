import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Snack {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int c,q=0,bill=0;
		Map<String, List<Integer>> map = new HashMap<String,List<Integer>>();
		
		do {
			System.out.println("\n**** Welcome to Snack Center ****"
					+ "\n1. Tea (Rs. 10)"
					+ "\n2. Green Tea (Rs. 15)"
					+ "\n3. Samosa (Rs. 20)"
					+ "\n4. Sandwitch (Rs. 50)"
					+ "\n5. Generate Bill & Exit"
					+ "\nEnter your choice : ");
			c = sc.nextInt();
			sc.nextLine();
			if (c!=5) { System.out.println("Enter quantity : "); q = sc.nextInt();} 
			
			switch (c) {
			case 1: bill+= 10*q; map.put("Tea", Arrays.asList(new Integer[]{q, q*10})); break;
			case 2: bill+= 15*q; map.put("Green Tea", Arrays.asList(new Integer[]{q, q*15})); break;
			case 3: bill+= 20*q; map.put("Samosa", Arrays.asList(new Integer[]{q, q*20})); break;
			case 4: bill+= 50*q; map.put("Sandwich", Arrays.asList(new Integer[]{q, q*50})); break;
			default: c=5; break;
			}
		} while(c!=5);
		
		System.out.println("\n**** BILL ****");
		for(Map.Entry<String, List<Integer>> entry: map.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue().get(0) + "\t" + entry.getValue().get(1));        
		}
		System.out.println("-------------");
		System.out.println("Total = " + bill);
		
		sc.close();

	}		
}