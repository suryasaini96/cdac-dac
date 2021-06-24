package generics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Test2 {

	public static void main(String[] args) {
		List<Emp> emps=new ArrayList<>();
		emps.add(new Emp());
		emps.add(new Mgr());
		emps.add(new SalesMgr());
		List<Mgr> mgrs=new ArrayList<>();
		mgrs.add(new Mgr());
	   Emp e=new Mgr();//up casting
	//   emps=mgrs;//in compatible : how to make it work ?????
	   // ? => wild card (un known type : it can be replaced by any type)
	   //? : un bounded wild card
	   //Object <-----List<?> <-----ArrayList<Emp>/LinkedList<Mgr>/Vector<Worker>/AL<Fruit>
	   List<?> anyList=new ArrayList<>();
	   anyList=emps;
	   anyList=mgrs;
	   Vector<Date> dates=new Vector<>();
	   anyList=dates;
	   //Business need : You should be allowed to assign lists of Emp type of hierarchy
	   //to add this restriction : bounded wild card (upper / lower)
	   //currently : upper bound : extends
	   //? extends Employee : Employee or it's sub type (narrowing : co variance)
	   List<? extends Emp> empList=new ArrayList<>();
	   empList=emps;
	   empList=mgrs;
	//   empList=dates;
	   
	   
	   
	   
	   
	   
	   

	}

}
