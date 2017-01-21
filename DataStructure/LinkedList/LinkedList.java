package linkedlist;

public class LinkedList<T> {

	private Node<T> head;
	private Node<T> tail;

	private int size = 0;

	public Node<T> getHead() {
		return head;
	}

	public Node<T> getTail() {
		return tail;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void add(T element) {
		Node<T> nextNode = new Node<T>();
		nextNode.setValue(element);

		if (head == null) {
			head = nextNode;
			tail = nextNode;
		} else {
			tail.setNext(nextNode);
			tail = nextNode;
		}
		size++;
	}

	public void addAfter(T element, T after) {
		Node<T> node = find(after);

		if (node == null)
			throw new NodeNotFoundException();

		Node<T> newNode = new Node<T>();
		newNode.setValue(element);
		newNode.setNext(node.getNext());
		node.setNext(newNode);
		size++;
	}

	public Node<T> find(T value) {
		Node<T> node = null;
		for (Node<T> current = head; current != null; current = current.getNext())
			if (current.compareTo(value) == 0)
				node = current;
		return node;
	}

	public void remove() {
		if (head == null)
			throw new UnderFlowException();
		unlinkFirst();
	}

	private void unlinkFirst() {
		Node<T> node = head.getNext();
		head = node;
		if (head == null)
			tail = null;
	}

	public void removeAfter(T element) {
		Node<T> node = find(element);
		if (node == null)
			throw new NodeNotFoundException();
		node.setNext(node.getNext());

	}

	public void print() {
		for (Node<T> tmpNode = head; tmpNode != null; tmpNode = tmpNode
				.getNext())
			System.out.print(tmpNode.getData() + " --> ");
		System.out.println("null");
	}

	/*********** Utility Methods ***********/

	public Node<T> getNthNodeFromEnd(int position) {
		Node<T> firstPointer = head;

		for (Node<T> secondPointer = getSecondPointer(position); 
				secondPointer != null; secondPointer = secondPointer.getNext())
			firstPointer = firstPointer.getNext();
		return firstPointer;
	}

	private Node<T> getSecondPointer(int position) {
		Node<T> secondPointer = head;
		for (int i = 0; i < position; i++)
			secondPointer = secondPointer.getNext();
		return secondPointer;
	}

	public void reverse() {
		Node<T> node = head;
		Node<T> current = null;
		Node<T> next = null;

		while (node != null) {
			next = node.getNext();
			node.setNext(current);
			current = node;
			node = next;
		}
		head = current;
	}

	public Node<T> reverseInGroup(Node<T> start, int groupSize) {
		Node<T> node = start;
		Node<T> current = null;
		Node<T> next = null;

		for (int count = 0; count < groupSize && node != null; count++) {
			next = node.getNext();
			node.setNext(current);
			current = node;
			node = next;
		}
		if (next != null)
			start.next = reverseInGroup(next, groupSize);
		head = current;
		return current;
	}
}

class UnderFlowException extends RuntimeException {}

class NodeNotFoundException extends RuntimeException {}
