public class Main {
	
	public static void main(String args[]) {
		int num = 153;
		int sum = 0;
		int temp = num;
		while (temp!=0) {
			int r = temp%10;
			sum+= Math.pow(r, 3);
			temp/=10;
		}
		if(sum==num) System.out.println("Armstrong!");
		else System.out.println("Not armstrong!");
		
	}   
}