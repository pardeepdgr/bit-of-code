package deadlock_detection;


import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class DeadlockDetector {

	public static void detectDeadlock() {
		ThreadMXBean bean = ManagementFactory.getThreadMXBean();
		long[] threadIds = bean.findDeadlockedThreads();
		int deadlockThreads = threadIds != null ? threadIds.length : 0;
		
		System.out.println("Number of deadlock threads: " + deadlockThreads);
	}
}
