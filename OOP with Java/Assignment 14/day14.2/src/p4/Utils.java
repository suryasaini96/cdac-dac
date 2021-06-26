package p4;

public class Utils {
//add a static method , which will accept 2 double args n 
	//3rd arg : operation to be performed 
	//ret double 
	//higher order function(method)
	public static double testCompute(double d1,double d2,Computable operation)
	{
		return operation.compute(d1, d2);
	}
}
