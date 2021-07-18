package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory factory;
	static {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SessionFactory getFactory() {
		return factory;
	}
}
