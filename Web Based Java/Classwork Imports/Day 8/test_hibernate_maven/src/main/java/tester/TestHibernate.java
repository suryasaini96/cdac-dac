package tester;

import static utils.HibernateUtils.getSf;

import org.hibernate.SessionFactory;

public class TestHibernate {

	public static void main(String[] args) {
		// tester invoking static method of HiebrnateUtils : first JVM has to invoke
		// static init block : singleton instance of SF
		try (SessionFactory sf = getSf()) {
			System.out.println("Hibernate frmwork up n running , sf : " + sf);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
