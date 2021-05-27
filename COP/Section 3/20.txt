import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		System.out.println("Numbers: ");
		String[] str = sc.nextLine().split(" ");
		int n[] = new int[5];
		int j=0;
		
		for(String s:str) {
			n[j] = Integer.parseInt(s);
			j++;
		}
		
		int first,second;
		first=second=n[0];	
		for (int i:n) {
			if (i>first) {
				second = first;
				first = i;
			}
			else if(i>second && i<first) second = i;
		}
		
		System.out.println("Second largest: " + second);
		sc.close();
	}
}