import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter roll no: ");
		int r = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter name: ");
		String name = sc.nextLine();
		System.out.println("Enter marks in P C CS : ");
		String m = sc.nextLine();
		String[] marks = m.split(" ");
		int tmarks=0;
		
		for(String mk: marks) tmarks+= Integer.parseInt(mk);
		double p = tmarks/3.0;
		
		String div = (p>=60.0)?"First":((p>=50.0 && p<60.0)?"Second":((p>=30.0 && p<50.0)?"Third":"Fail"));                                    
		
		System.out.println("Roll No: " + r
				+ "\nName of Student : " + name
				+ "\nMarks in Physics : " + marks[0]
				+ "\nMarks in Chemistry : " + marks[1]
				+ "\nMarks in Computer Application : " + marks[2]
				+ "\nTotal Marks: " + tmarks
				+ "\nPercentage: " + p
				+ "\nDivision: " + div);
		
		sc.close();
		
		
	}

}
