package tester;

import java.util.HashSet;

import com.app.core.Emp;

public class TestEmpSet2 {

	public static void main(String[] args) {
		// create empty HashSet to store emp details
		HashSet<Emp> empSet=new HashSet<>();
		Emp e1=new Emp(101, "abc", 1000);
		Emp e2=new Emp(10, "abc", 1000);
		Emp e3=new Emp(150, "abc23", 1000);
		Emp e4=new Emp(50, "abc", 1000);
		Emp e5=new Emp(101, "abc", 1000);
		System.out.println("Added "+empSet.add(e1));//t
		System.out.println("Added "+empSet.add(e2));//t
		System.out.println("Added "+empSet.add(e3));//t
		System.out.println("Added "+empSet.add(e4));//t
		System.out.println("Added "+empSet.add(e5));//f
	
		System.out.println("size "+empSet.size());//4
		System.out.println("HS "+empSet);//e1 ,e2,e3,e4
		

	}

}
