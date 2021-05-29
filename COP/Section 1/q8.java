public class Main {
	
	public static void main(String[] args) {
		float C = Float.parseFloat(args[0]);
		float F = (9*C/5) + 32;
		System.out.println("Celsius: " + C + " in Fahrenheit: " + F);
	}

}
