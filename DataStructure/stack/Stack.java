package stack;

import java.util.Arrays;

public class Stack<T extends Comparable<T>> {

	Object[] backedArray;
	int size = 0;

	public Stack(int size) {
		backedArray = new Object[size];
	}

	public void push(T element) {
		if (size + 1 > backedArray.length)
			throw new StackOverflow();
		backedArray[size++] = element;
	}

	public T pop() {
		if (size - 1 < 0)
			throw new StackUnderflow();
		T element = (T) backedArray[--size];
		backedArray[size] = null;
		return element;
	}

	public T peek() {
		return (T) backedArray[size - 1];
	}

	public T top() {
		return (T) backedArray[size];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void sort() {
		Stack<T> auxStack = new Stack<T>(backedArray.length);
		auxStack.push(this.pop());
		T current = null;

		while (!this.isEmpty() || current != null) {

			while (current != null && auxStack.size() > 0 && current.compareTo(auxStack.peek()) < 0)
				this.push(auxStack.pop());

			if (current != null) {
				auxStack.push(current);
				current = null;
			}

			if (!this.isEmpty())
				current = this.pop();
		}
		copyFrom(auxStack);
	}

	private void copyFrom(Stack<T> stack) {
		this.backedArray = Arrays.copyOf(stack.backedArray, stack.backedArray.length);
		this.size = this.backedArray.length;
	}

	public void print() {
		for (int i = backedArray.length - 1; i >= 0; i--)
			System.out.print(backedArray[i] + " ");
		System.out.println();
	}

}

class StackOverflow extends RuntimeException {
}

class StackUnderflow extends RuntimeException {
}
