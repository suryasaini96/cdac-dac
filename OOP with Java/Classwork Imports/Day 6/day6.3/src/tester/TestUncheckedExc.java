package tester;

public class TestUncheckedExc {

	public static void main(String[] args) {
		try {
			int a = 100;
			int b = 0;
			System.out.println("res " + (a / b));// AE : un chked exc
			String s = "1234";
			System.out.println("Parsed int " + Integer.parseInt(s)); // NFE : un chked
			s = null;
			System.out.println("1st char " + s.charAt(0));// NPE : un chked (throw new NPE())
			System.out.println("end of try...");
		}
		// catch (ArithmeticException e) {
//			System.out.println("in AE");
//		} catch (NumberFormatException e) {
//			System.out.println("in NFE");
//		} 
		catch (Exception e) {// up casting
			System.out.println("in catch-all");
		//	System.out.println(e.getMessage());
		//	System.out.println(e);//e.toString : name + err mesg
			e.printStackTrace();
			
		}
		System.out.println("main contd....");

	}

}
