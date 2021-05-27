public class Main {
	
	static int sum = 0;
	
	public static void main(String args[]) {
		int num = 6, div = 1;
		divisor(num,div);
		
		if(sum==num) System.out.println("Perfect number!");
		else System.out.println("Not a perfect number!");	
	}   
	
	static int divisor(int num, int div){
		if(div<=num/2) {
			if (num%div==0) sum+=div;
			divisor(num, ++div);
		}
		return sum;
	}
}