package LRU;

public class DoublyLinkedList {

	private int size;
	private int currentSize = 0;
	private Node head = null;
	private Node tail = null;

	public DoublyLinkedList(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public int getCurrentSize() {
		return currentSize;
	}

	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}

	public Node addNode(int pageNumber) {
		Node node = new Node(pageNumber);
		if (head == null) {
			createHeadNode(node);
			return node;
		} else if (currentSize < size)
			currentSize++;
		else
			deleteNodeAtTail();

		addNodeAtHead(node);
		return node;
	}

	private void createHeadNode(Node node) {
		head = node;
		tail = head;
		currentSize++;
	}

	private void addNodeAtHead(Node node) {
		node.setNext(head);
		head.setPrevious(node);
		head = node;
	}

	private void deleteNodeAtTail() {
		tail = tail.getPrevious();
		tail.setNext(null);
	}

	public void moveNodeToHead(Node node) {
		if (node == null || node == head)
			return;
		if (node == tail)
			deleteNodeAtTail();

		createLinkBetweenPreviousAndNextNode(node);
		moveNodeToBegining(node);
	}

	private void createLinkBetweenPreviousAndNextNode(Node node) {
		Node previous = node.getPrevious();
		Node next = node.getNext();
		previous.setNext(next);
		if (next != null)
			next.setPrevious(previous);
	}

	private void moveNodeToBegining(Node node) {
		node.setPrevious(null);
		node.setNext(head);
		head.setPrevious(node);
		head = node;
	}

	public void print() {
		if (head == null)
			return;
		Node node = head;
		while (node != null) {
			System.out.print(node.getPageNumber() + " ");
			node = node.getNext();
		}
	}

}
