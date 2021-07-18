package tester;
import static utils.HibernateUtils.getFactory;
import org.hibernate.*;

public class TestHibernate {

	public static void main(String[] args) {
		//bootstrapping hib frmwork
		try(SessionFactory sf=getFactory())
		{
			System.out.println("hibernate up n running! "+sf);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
