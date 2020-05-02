package multithreading.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore maintains a set of permits. Each acquire() blocks if necessary
 * until a permit is available, and then takes it or wait indefinitely if no
 * permit available. Each release() adds a permit, potentially releasing a
 * blocking acquirer. However, no actual permit objects are used; the Semaphore
 * just keeps a count of the number available and acts accordingly.
 * 
 * Sample usage: Semaphores are often used to restrict the number of threads
 * than can access some (physical or logical) resource.
 */
public class SemaphoreUsage {

	public static void main(String[] args) throws InterruptedException {
		Semaphore semaphore = new Semaphore(1);
		semaphore.release();
		semaphore.acquire();
		System.out.println("Available permits: " + semaphore.availablePermits());

		ExecutorService executor = Executors.newCachedThreadPool();

		for (int i = 0; i < 50; i++) {
			executor.submit(new Runnable() {

				@Override
				public void run() {
					Connection.getInstance().connect();
				}
			});
		}

		executor.shutdown();
	}
}
