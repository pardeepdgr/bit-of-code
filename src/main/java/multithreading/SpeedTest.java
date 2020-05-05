package  multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class SpeedTest {

	private static int normalInt = 0;
	private static volatile int volatileInt = 0;
	private static AtomicInteger atomicInt = new AtomicInteger();
	private static int synchronizedInt = 0;

	public static void main(String[] args) {

		normalIncrement();

		volatileIncrement();

		atomicIncrement(); /* atomic uses volatile variable for operation */

		synchronizedIncrement();
	}

	private static void normalIncrement() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1E8; i++) {
			normalInt++;
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	private static void volatileIncrement() {
		long start4 = System.currentTimeMillis();
		for (int i = 0; i < 1E8; i++) {
			volatileInt++;
		}
		long end4 = System.currentTimeMillis();
		System.out.println(end4 - start4);
	}

	private static void atomicIncrement() {
		long start2 = System.currentTimeMillis();
		for (int i = 0; i < 1E8; i++) {
			atomicInt.addAndGet(1);
		}
		long end2 = System.currentTimeMillis();
		System.out.println(end2 - start2);
	}

	private static void synchronizedIncrement() {
		long start3 = System.currentTimeMillis();
		for (int i = 0; i < 1E8; i++) {
			synchronized (SpeedTest.class) {
				synchronizedInt++;
			}
		}
		long end3 = System.currentTimeMillis();
		System.out.println(end3 - start3);
	}

}
