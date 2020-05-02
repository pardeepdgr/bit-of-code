package multithreading.custom_threadpool;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {

	private Queue<T> queue = new LinkedList<T>();
	private int maxTasks = 0;

	public BlockingQueue(int size) {
		maxTasks = size;
	}

	public synchronized void enqueue(T task) throws InterruptedException {
		while (queue.size() == maxTasks)
			wait();
		if (queue.size() == 0)
			notifyAll();
		queue.add(task);
	}

	public synchronized T dequeue() throws InterruptedException {
		while (queue.size() == 0)
			wait();
		if (queue.size() == maxTasks)
			notifyAll();
		return queue.remove();
	}
}
