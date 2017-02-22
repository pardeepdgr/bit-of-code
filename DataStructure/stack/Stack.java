package stack;

public class Stack<T> {

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

	public boolean isEmpty() {
		return size == 0;
	}

	public T top() {
		return (T) backedArray[size];
	}

	public void print() {
		for (int i = backedArray.length - 1; i >= 0; i--)
			System.out.println(backedArray[i]);
		System.out.println();
	}
}

class StackOverflow extends RuntimeException {
}

class StackUnderflow extends RuntimeException {
}
