package multithreading.custom_threadpool;

public class TaskExecutor extends Thread{

	private BlockingQueue<Runnable> queue;
	private boolean isStopped = false;

	public TaskExecutor(BlockingQueue<Runnable> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (!isStopped) {
			try {
				Runnable task = queue.dequeue();
				task.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void doStop() {
		isStopped = true;
	}
}
