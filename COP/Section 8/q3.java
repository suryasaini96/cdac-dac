public class Main {
	
	public static void main(String[] args) {
		
		int n[] = new int[] {3,4,4,5};
		int first,second;
		first=second=n[0];
		for (int i:n) {
			if (i>first) {
				second = first;
				first = i;
			}
			else if(i>second && i<first) second = i;
		}
		System.out.println("Largest: " + first);
		System.out.println("Second largest: " + second);
	}
}