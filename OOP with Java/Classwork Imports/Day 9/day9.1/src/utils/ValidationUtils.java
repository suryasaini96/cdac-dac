package utils;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import static com.app.core.Category.*;

import com.app.core.Category;
import com.app.core.Vehicle;

import custom_exception.VehicleHandlingException;

import static com.app.core.Vehicle.sdf;

//manufacture date not before 1st Jan 2010
public class ValidationUtils {
//add static method to parse string --> Date
	private static Date testDate;
	static {
		try {
			testDate = sdf.parse("1-1-2010");
		} catch (ParseException e) {
			System.out.println("Error in static init block " + e);
		}
	}

	public static Date convertValidateDate(String date) throws ParseException, VehicleHandlingException {
		Date d1 = sdf.parse(date);// conversion
		if (d1.before(testDate))
			throw new VehicleHandlingException("Invalid Date...");
		// valid date => return parsed n validated date to the caller
		return d1;

	}

	// add static method to parse string --> enum
	public static Category convertCategory(String category) throws VehicleHandlingException {
		try {
			return valueOf(category.toUpperCase());// IllegalArgumentException : un chked
		} catch (IllegalArgumentException e) {
			StringBuilder sb = new StringBuilder("Invalid Category chosen!!!!!\n Available Categories : ");
			sb.append(Arrays.toString(Category.values()));
			// re throw the exc as custom exc
			throw new VehicleHandlingException(sb.toString());
		}
	}
	//no dup vehicle : based upon regNo --
	//add a static method to chk for duplication : in case of a dup => throw custom exc 
	//or ret non dup validated reg no
	public static String checkForDuplication(String inputRegNo,Vehicle[] vehicles) throws VehicleHandlingException
	{
		//create a vehicle wrapping regNO (Primary Key : unique id)
		Vehicle testVehicle=new Vehicle(inputRegNo);//abc-1234
		for(Vehicle v : vehicles) //v=vehicles[0]
			if(v != null)
				if (v.equals(testVehicle))
					throw new VehicleHandlingException("Dup reg no detected!!!!!!");
		return inputRegNo;
	}
	//Suppose u have vehicle array with reg nos : abc-1234,def-1234,xyz-1234 
	//if user adds another vehicle with abcd-123 , what will happen ? : rets input reg no
	//if user adds another vehicle with abc-1234 , what will happen ?
	//: rets input reg no => will NOT detect it as the dup.
	
	//add a static method to chk if vehicle exists by specified reg no
	//checkIfExists(regNo,vehicleArr);
	public static Vehicle checkIfExists(String regNo,Vehicle[] vehicles) throws VehicleHandlingException
	{
		//based upon equals : Vehicle 
		//create a vehicle instance just wrapping PK
		Vehicle testVehicle=new Vehicle(regNo);
		for(Vehicle v : vehicles)
			if(v != null)
				if(v.equals(testVehicle))
					return v;
		throw new VehicleHandlingException("Invalid reg no : Vehicle not found!!!!!!");
		
		
	}
	
	
}
