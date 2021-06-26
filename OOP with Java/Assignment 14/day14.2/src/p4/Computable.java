package p4;

/*
 * 1. Create your own functional interface n use it in lambda expression
eg : Perform ANY arithmetic operation on 2 double values & return the result
eg --add/multiply/subtract/divide....
 */
@FunctionalInterface
public interface Computable {
//public abstract : SAM
	double compute(double a, double b);
}
