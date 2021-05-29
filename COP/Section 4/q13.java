public class Main {
	
	public static void main(String args[]) {
		int num = 0;
		boolean prime = true;
		
		for (int i=2; i<=num/2; i++) {
			if (num%i == 0) {
				prime = false;
				break;
			}		
		}
		
		if(num==0) System.out.println("Zero!");
		else if (prime) System.out.println("Prime!");
		else System.out.println("Not prime!");
	}   
}