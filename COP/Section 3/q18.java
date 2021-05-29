import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		System.out.println("Char: ");
		char c = Character.toLowerCase(sc.next().charAt(0));
		
		Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
	
		if (c>='a' && c<='z') {
			if (vowels.contains(c)) System.out.println("Vowel");
			else System.out.println("Consonant");
		} else System.out.println("Other character");	
		
		
		sc.close();
	}
}