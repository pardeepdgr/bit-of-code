package  multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreeNumberPrinter {

	public static void main(String[] args) {
		Object lock = new Object();
		AtomicInteger number = new AtomicInteger(1);

		Thread t1 = new Thread(new Printer(1, 3, lock, number), "1");
		Thread t2 = new Thread(new Printer(2, 3, lock, number), "2");
		Thread t3 = new Thread(new Printer(0, 3, lock, number), "3");

		t1.start();
		t2.start();
		t3.start();
	}
}

class Printer implements Runnable {
	private Object lock;
	private AtomicInteger number;

	private int id;
	private int numberOfThreads;

	public Printer(int id, int numberOfThreads, Object lock,
			AtomicInteger number) {
		this.id = id;
		this.lock = lock;
		this.number = number;
		this.numberOfThreads = numberOfThreads;
	}

	@Override
	public void run() {
		try {
			print(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void print(int limit) throws InterruptedException {
		while (number.get() <= limit) {
			synchronized (lock) {
				if (number.get() % numberOfThreads != id) {
					lock.wait();
				} else {
					System.out.println(Thread.currentThread().getName() + " " + number);
					number.getAndIncrement();
					lock.notifyAll();
				}
			}
		}
	}
}