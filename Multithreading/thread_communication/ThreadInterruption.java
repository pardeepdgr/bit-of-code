package thread_communication;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Don't stop a thread, interrupt it.
 * 
 * Because stopping a thread causes it to unlock all the monitors that it has
 * locked. If any of the objects previously protected by these monitors were in
 * an inconsistent state, other threads may now view these objects in an
 * inconsistent state. Such objects are said to be damaged. When threads operate
 * on damaged objects, arbitrary behavior can result. This behavior may be
 * subtle and difficult to detect
 * */
public class ThreadInterruption {

	public static void main(String[] args) throws InterruptedException {
		interruptSingleThread();
		interruptThreadPool();
	}

	private static void interruptSingleThread() throws InterruptedException {
		System.out.println("Started");
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				Random random = new Random();
				for (int i = 0; i < 1E8; i++) {
					if (Thread.interrupted()) {
						System.out.println("interupted");
						break;
					}
					Math.sin(random.nextDouble());
				}
			}
		});

		t.start();
		Thread.sleep(500);

		t.interrupt();

		t.join();
		System.out.println("finished");
	}

	private static <T> void interruptThreadPool() throws InterruptedException {
		System.out.println("Started");
		ExecutorService executor = Executors.newCachedThreadPool();
		Future<T> future = executor.submit(new Callable<T>() {

			@Override
			public T call() throws Exception {
				Random random = new Random();
				for (int i = 0; i < 1E8; i++) {
					if (Thread.interrupted()) {
						System.out.println("interupted");
						break;
					}
					Math.sin(random.nextDouble());
				}
				return null;
			}
		});

		executor.shutdown();
		Thread.sleep(500);

		executor.shutdownNow();
		/* or */
		// future.cancel(true);

		executor.awaitTermination(1, TimeUnit.HOURS);
		System.out.println("finished");
	}

}
