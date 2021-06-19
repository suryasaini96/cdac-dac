package test_dates;

import java.util.Date;

public class Test1 {

	public static void main(String[] args) {
		Date currentDate=new Date();
		System.out.println(currentDate);
		Date earlierDate=new Date(0);
		System.out.println(earlierDate);
		System.out.println(currentDate.before(earlierDate));//false
		System.out.println(currentDate.compareTo(earlierDate));//+1
		

	}

}
