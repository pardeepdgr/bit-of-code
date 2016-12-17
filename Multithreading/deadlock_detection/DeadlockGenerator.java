package deadlock_detection;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockGenerator {

	Lock lockA = new ReentrantLock();
	Lock lockB = new ReentrantLock();

	public void getResourcesforA() throws InterruptedException {

		lockA.lock();
		System.out.println("Lock A is acquired by " + Thread.currentThread().getName());
		Thread.sleep(2000);
		System.out.println(Thread.currentThread().getName() + " is waiting to get the lock B");
		lockB.lock();
		try {
			System.out.println("Secured the resource of first A and then B.");
		} finally {
			lockA.unlock();
			lockB.unlock();
		}
	}

	public void getResourcesforB() throws InterruptedException {
		lockB.lock();
		System.out.println("Lock B is acquired by " + Thread.currentThread().getName());
		Thread.sleep(2000);
		System.out.println(Thread.currentThread().getName() + " is waiting to get the lock A");
		lockA.lock();
		try {
			System.out.println("Secured the resource of first B and then A.");
		} finally {
			lockA.unlock();
			lockB.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final DeadlockGenerator generator = new DeadlockGenerator();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					generator.getResourcesforA();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					generator.getResourcesforB();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
		Thread.sleep(4000);
		DeadlockDetector.detectDeadlock();
	}
}
