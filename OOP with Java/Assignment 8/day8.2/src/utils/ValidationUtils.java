package utils;

import java.text.ParseException;
import java.util.Date;
import static com.app.core.Category.valueOf;

import com.app.core.Category;

import static com.app.core.Vehicle.sdf;

public class ValidationUtils {
//add static method to parse string --> Date
	public static Date convertDate(String date) throws ParseException
	{
		return sdf.parse(date);
	}
	//add static method to parse string --> enum
	public static Category convertCategory(String category)
	{
		return valueOf(category.toUpperCase());//IllegalArgumentException : un chked
	}
}
