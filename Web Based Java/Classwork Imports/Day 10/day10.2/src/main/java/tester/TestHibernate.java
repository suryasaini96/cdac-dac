package tester;

import static utils.HibernateUtils.getSf;

import org.hibernate.*;

public class TestHibernate {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf()) {
			System.out.println("success !!!! " + sf);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
