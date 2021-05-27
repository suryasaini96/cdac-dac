public class Main {
	
	public static void main(String[] args) {
		
		String str = "Hello";
		int len=0;
		if (str == "" || str == null) {System.out.println("Length: " + len ); return;} 
		char c=str.charAt(len);
		while(c!='\0') {
			len++;
			try {
				c=str.charAt(len);
			} catch(StringIndexOutOfBoundsException e) {
				break;
			}
		}
		System.out.println("Length: " + len);	
	}		
}