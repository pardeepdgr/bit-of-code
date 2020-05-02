package multithreading.custom_threadpool;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {

	private BlockingQueue<Runnable> queue;
	private List<TaskExecutor> tasks = new ArrayList<TaskExecutor>();
	private boolean isStopped = false;

	public ThreadPool(int queueSize, int numOfThread) {
		queue = new BlockingQueue<Runnable>(queueSize);

		for (int count = 0; count < numOfThread; count++)
			tasks.add(new TaskExecutor(queue));
		for (TaskExecutor task : tasks)
			task.start();
	}

	public synchronized void submitTask(Runnable task) throws InterruptedException {
		if(isStopped)
			throw new IllegalStateException("Threadpool is stopped");
		queue.enqueue(task);
	}

	public synchronized void stop(){
		isStopped=true;
		for (TaskExecutor task : tasks)
			task.doStop();
	}
}
