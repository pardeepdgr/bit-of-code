package cyclic_barrier;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier allows a set of threads to all wait for each other to reach a
 * common barrier point. The barrier is called cyclic because it can be re-used
 * after the waiting threads are released.
 * 
 * CyclicBarriers are useful in programs involving a fixed sized party of
 * threads that must occasionally wait for each other, where all threads arrive
 * and then wait for the last to arrive.
 */
public class CyclicBarrierUsage {

	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3);

		Thread t1 = new Thread(new PrimaryParty(barrier));
		Thread t2 = new Thread(new SecondaryParty(barrier));
		System.out.println("Job-0 is starting both parties at " + new Date());

		t1.start();
		t2.start();

		System.out.println("Job-0 is completed. Waiting at barrier for other parties..");
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println("Job-0 is compeleted at " + new Date());
	}
}

class PrimaryParty implements Runnable {

	private CyclicBarrier barrier;

	public PrimaryParty(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		System.out.println("Job-1 has started");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Job-1 is completed. Waiting at barrier for other parties..");

		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}

		System.out.println("Exiting Job-1");
	}
}

class SecondaryParty implements Runnable {

	private CyclicBarrier barrier;

	public SecondaryParty(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		System.out.println("Job-2 has started");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out
				.println("Job-2 is completed. Waiting at barrier for other parties..");

		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}

		System.out.println("Exiting Job-2");
	}
}
