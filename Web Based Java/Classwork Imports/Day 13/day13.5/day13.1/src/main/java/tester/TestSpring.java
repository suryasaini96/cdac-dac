package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependent.ATMImpl;

public class TestSpring {

	public static void main(String[] args) {
		//start SC : using xml based metadata instrs place in run time class path
		try(ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("bean-config.xml"))
		{
			System.out.println("SC booted !!!!");
			//BeanFactory i/f method public <T> T getBean(String beanId,Class<T> class) ....
			ATMImpl ref1=ctx.getBean("my_atm",ATMImpl.class);//1st demand 
			ref1.withdraw(1000);
			ATMImpl ref2=ctx.getBean("my_atm",ATMImpl.class);//2nd demand
			System.out.println(ref1==ref2);//true!
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
