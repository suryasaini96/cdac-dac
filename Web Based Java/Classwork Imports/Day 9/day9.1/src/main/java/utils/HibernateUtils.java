package utils;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory factory;
	static {
		try {
			System.out.println("in static init block");
			// build singleton instance of SF (SessionFactory)
			factory = new Configuration().configure().buildSessionFactory();
			System.out.println("SF created....");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SessionFactory getFactory() {
		return factory;
	}
	
}
