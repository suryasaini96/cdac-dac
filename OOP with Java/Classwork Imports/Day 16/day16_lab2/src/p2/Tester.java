package p2;

public class Tester {

	public static void main(String[] args) {
		try {
			System.out.println(Thread.currentThread());// Thread' toString : main 5 main
			// create child thrds n check concurrency!
			MyThread t1 = new MyThread("one");
			MyThread t2 = new MyThread("two");
			MyThread t3 = new MyThread("three");
			MyThread t4 = new MyThread("four");// Runnable : 1 + 4
			// dummy B.L for main
			for (int i = 0; i < 10; i++) {
				System.out.println("thrd " + Thread.currentThread().getName() + " exec # " + i);
				Thread.sleep(100);// Blocked : on sleep
			}
			System.out.println("t1 is alive "+t1.isAlive()+" t4 is alive "+t4.isAlive());//t t
			System.out.println("main is waiting for child thrds to finish exec....");
			// join
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			System.out.println("t1 is alive "+t1.isAlive()+" t4 is alive "+t4.isAlive());//f f
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main over....");
	}

}
