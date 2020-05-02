package conceptualization.cache.lru;

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
			createHeader(node);
			return node;
		} else if (currentSize < size)
			currentSize++;
		else
			deleteTailNode();

		addNodeAtHead(node);
		return node;
	}

	private void createHeader(Node node) {
		head = node;
		tail = head;
		currentSize++;
	}

	private void addNodeAtHead(Node node) {
		node.setNext(head);
		head.setPrevious(node);
		head = node;
	}

	private void deleteTailNode() {
		tail = tail.getPrevious();
		tail.setNext(null);
	}

	public void moveNodeToHead(Node node) {
		if (node == null || node == head)
			return;
		if (node == tail)
			deleteNodeAtTail();

		linkPreviousAndNextNode(node);
		moveNodeToBegining(node);
	}

	private void linkPreviousAndNextNode(Node node) {
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
