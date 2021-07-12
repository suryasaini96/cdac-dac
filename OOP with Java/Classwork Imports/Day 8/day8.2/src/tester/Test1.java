package tester;

import java.util.Scanner;
import static utils.ValidationUtils.*;
import com.app.core.Vehicle;

public class Test1 {

	public static void main(String... args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter details of the  vehicle regno clr price date(day-mon-yr) category");
			Vehicle v1 = new Vehicle(sc.next(), sc.next(), sc.nextDouble(), convertDate(sc.next()),
					convertCategory(sc.next()));
			System.out.println(v1);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
