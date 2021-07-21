package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-bean-config.xml")) {
			System.out.println("SC booted.....");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
