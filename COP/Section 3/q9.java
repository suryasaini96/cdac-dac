public class Main {
	
	public static void main(String[] args) {

		int a=30,b=30,c=30,l=0;
		
		if (a>b && a>c) l = a;
		else if (b>a && b>c) l = b;
		else if (c>a && c>b) l = c;
		
		else if (c>a && a==b ) l = c;
		else if (b>a && a==c ) l = b;
		else if (a>c && b==c ) l = a;
		
		else if (a==b && b==c) l = a;
		
		System.out.println("Largest: " + l);
	}

}