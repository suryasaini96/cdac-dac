package p4;
import static utils.CollectionUtils.*;

import java.util.ArrayList;
import java.util.function.Consumer;

import com.app.core.BankAccount;

public class Test2 {

	public static void main(String[] args) {
		// get populated list of accts
		ArrayList<BankAccount> list = populateSampleData();
		//display all acct details : using higher order func
		//Iterable<T> : public default void forEach(Consumer<? super T> consumer)
		//imerative style
		list.forEach(new Consumer<BankAccount>() {

			@Override
			public void accept(BankAccount t) {
				System.out.println(t);
				
			}
			
		});
		//OR functional / declarative
		list.forEach(a -> System.out.println(a));
		
		
		

	}

}
