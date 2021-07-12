package p2;

public class MyThread extends Thread {

	// add paramterized constr to ser thrd name
	public MyThread(String name) {
		super(name);// NEW : ONLY thread cls instance is created in java heap
		start();// inherited API from Thread class : RUNNABLE(rdy pool /running)
	}

	@Override
	public void run() {
		System.out.println("strted exec " + getName());
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("thrd " + getName() + " exec # " + i);
				Thread.sleep(500);// Blocked : on sleep
			}
		} catch (Exception e) {
			System.out.println("err in thrd " + getName() + " err " + e);
		}
		System.out.println(" exec over  " + getName());

	}//DEAD

}
