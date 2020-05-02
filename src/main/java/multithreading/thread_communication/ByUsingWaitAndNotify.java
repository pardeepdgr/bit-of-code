package multithreading.thread_communication;

import java.util.Scanner;

public class ByUsingWaitAndNotify {

	public static void main(String[] args) {
		final Processor processor = new Processor();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					processor.write();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					processor.read();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
	}
}

class Processor {

	public void write() throws InterruptedException {
		synchronized (this) {
			System.out.println("Writter thread is running..");
			wait();
			System.out.println("Resumed");
		}
	}

	public void read() throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		Thread.sleep(1000);

		synchronized (this) {
			System.out.println("Waiting for return key..");
			scanner.nextLine();
			System.out.println("Return key is pressed");
			notify();
			/*
			 * Resumed will be printed only after execution completion of
			 * current synchronized block
			 */
			Thread.sleep(3000);
		}
	}

}