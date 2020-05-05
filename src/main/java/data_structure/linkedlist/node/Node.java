package data_structure.linkedlist.node;

public class Node<T> implements Comparable<T> {

	T data;
	public Node<T> next;

	public T getData() {
		return data;
	}

	public void setValue(T element) {
		this.data = element;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> ref) {
		this.next = ref;
	}

	public int compareTo(T val) {
		if (this.getData() == val)
			return 0;
		else
			return 1;
	}

}