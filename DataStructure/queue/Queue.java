package queue;

import java.util.NoSuchElementException;

public class Queue {

	int[] myQueue;
	int len, front, rear, size;

	public Queue(int size) {
		myQueue = new int[size];
		len = 0;
		front = -1;
		rear = -1;
		this.size = size;
	}

	public boolean enqueue(int element) {
		if (rear == -1) {
			front = 0;
			rear = 0;
			myQueue[rear] = element;
			System.out.println("First element added : " + element);
		} else if (rear < size - 1) {
			myQueue[++rear] = element;
			System.out.println("Element added : " + element);
		} else if (rear >= size - 1) {
			throw new IndexOutOfBoundsException("Overflow");
		}
		len++;
		return true;
	}

	public int dqueue() {
		if(isEmpty()){
			throw new NoSuchElementException("Underflow");
		}else{
			int element = myQueue[front];
			if(front == rear){
				front = -1;
				rear = -1;
			}else{
				front++;
			}
			System.out.println("Element removed : " + element);
			return element;
		}
		
	}

	public int front() {
		return front;
	}

	public int size() {
		return len;
	}

	public boolean isEmpty() {
		return front == -1;
	}
}
