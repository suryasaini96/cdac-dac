public class Main {
	
	public static void main(String args[]) {
		int num = -123;
		String s = Integer.toString(Math.abs(num));
		if (num<0) System.out.print("-");
		for(int i = s.length()-1; i>=0; i--) {
			System.out.print(s.charAt(i));
		}
	}
}