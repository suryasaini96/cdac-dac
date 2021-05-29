public class Main {
	
	public static void main(String[] args) {
		float a = Float.parseFloat(args[0]);
		float b = Float.parseFloat(args[1]);
		
		float add = a + b;
		float sub = a - b;
		float div = a/b;
		float mul = a*b;
		
		System.out.println("Add: " + add  + "\nSub: " + sub + 
				"Div: " + div + "Mul: " + mul);
		
	}

}
