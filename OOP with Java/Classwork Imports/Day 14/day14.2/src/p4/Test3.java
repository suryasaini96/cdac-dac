package p4;

import static utils.CollectionUtils.*;

import java.util.ArrayList;
import java.util.function.Consumer;

import com.app.core.BankAccount;

public class Test3 {

	public static void main(String[] args) {
		// get populated list of accts
		ArrayList<BankAccount> list = populateSampleData();
		System.out.println("orig list ");
		list.forEach(a -> System.out.println(a));
		// remove the accts from the list having less balance : 5000
		/*
		 * default boolean removeIf​(Predicate<? super E> filter) Removes all of the
		 * elements of this collection that satisfy the given predicate
		 * 
		 * Predicate : func i/f can be replaced by lambda expr func method(SAM) : public
		 * boolean test(T o)
		 */
		list.removeIf(a -> a.getBalance() < 5000);// stateful op.
		// display list after removal : func style prog
		System.out.println(" list after remove ");
		list.forEach(a -> System.out.println(a));

	}

}
