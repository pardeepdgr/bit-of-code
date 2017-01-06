package countdown_latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A CountDownLatch is initialized with a given count. The await methods block
 * until the current count reaches zero due to invocations of the countDown()
 * method. This is a one-shot phenomenon (the count cannot be reset). If you
 * need a version that resets the count, consider using a CyclicBarrier.
 * 
 * A CountDownLatch is a versatile synchronization tool and can be used to make
 * one thread wait until N threads have completed some action, or some action
 * has been completed N times.
 * 
 * Sample usage: Main thread creates N database connections and creates N
 * different threads for each connection. But the Main thread must wait until
 * all N threads finish their DB Operation.
 */
public class CountDownLatchUsage {
	private static final int COUNT = 3;

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(COUNT);
		ExecutorService executor = Executors.newFixedThreadPool(2);

		for (int id = 0; id < COUNT; id++) {
			executor.submit(new Processor(latch, id));
		}
		System.out.println("Main thread is waiting for countdown to be zero..");

		try {
			latch.await();
			System.out.println("Countdown has reached zero");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		/* Another tasks can be performed here after countdown reaches zero */
	}
}

class Processor implements Runnable {
	CountDownLatch latch;
	int id;

	public Processor(CountDownLatch latch, int id) {
		this.latch = latch;
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Thread " + id + " has started");
		try {
			/* Suppose creating DB connection here */
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread " + id + " is completed");
		latch.countDown();
	}
}
