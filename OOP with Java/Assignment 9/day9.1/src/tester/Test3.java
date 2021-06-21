package tester;

import java.util.Scanner;

import com.app.core.Vehicle;
import static utils.ValidationUtils.*;

public class Test3 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// init
			System.out.println("Enter capacity of warehouse");
			Vehicle[] vehicleArr = new Vehicle[sc.nextInt()];
			boolean exit = false;
			int counter = 0;
			while (!exit) {
				System.out.println("Options 1. Add a Vehicle 2. Display All 3.Purchase a vehicle 10.Exit");
				try {
					switch (sc.nextInt()) {
					case 1: //add boundary chking here....
						System.out.println("Enter vehicle details : regno clr price date(day-mon-yr) category");
						Vehicle v=new Vehicle(checkForDuplication(sc.next(), vehicleArr),sc.next(),
								sc.nextDouble(),convertValidateDate(sc.next()),convertCategory(sc.next()));
						//=> valid details
						vehicleArr[counter++]=v;
						System.out.println("Vehicle added....");
						break;
					case 2:
						System.out.println("All vehicle details");
						for(Vehicle v1 : vehicleArr)
							if(v1 != null )
								System.out.println(v1);

						break;
					case 3 :
						System.out.println("Enter reg no to purchase");
						String regNo=sc.next();
						//chk if it exists!!!!!
						Vehicle existingVehicle = checkIfExists(regNo,vehicleArr);
						//vehicle ref . assign address
						System.out.println("Enter delivery address :  city,  state,  zipCode,  phoneNo");
						existingVehicle.linkDeliveryAddress(sc.next(), sc.next(), sc.next(), sc.next());
						System.out.println("purchasing complete for "+existingVehicle);
						break;			
						
					case 10:
						exit = true;

						break;

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				//to clear buffer of scanner till new line
				sc.nextLine();

			}
		}

	}

}
