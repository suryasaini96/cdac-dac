package tester;

import java.util.HashSet;

import com.app.core.Emp;

public class TestEmpSet {

	public static void main(String[] args) {
		// create empty HashSet to store emp details
		HashSet<Emp> empSet=new HashSet<>();
		Emp e1=new Emp(101, "abc", 1000);
		Emp e2=new Emp(101, "abc", 1000);
		System.out.println("Added "+empSet.add(e1));//true
		System.out.println("Added "+empSet.add(e2));//false => dup is  detected
		System.out.println("size "+empSet.size());//1
		System.out.println("HS "+empSet);//e1 
		System.out.println(e1.equals(e2));//true
		System.out.println(e1.hashCode()+" "+e2.hashCode()); //100 (same)

	}

}
