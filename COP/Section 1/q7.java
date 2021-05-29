public class test {
    public static void main(String[] args) {

		float principal = Float.parseFloat(args[0]);
		float rate = Float.parseFloat(args[1]);
		float years = Float.parseFloat(args[2]);
		
		float SimpleInterest = (principal * rate * years)/100.0;
		System.out.println(SimpleInterest);
	}
}
