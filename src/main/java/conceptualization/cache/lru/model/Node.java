package conceptualization.cache.lru.model;

import java.util.Objects;

public class Node {

	private int pageNumber;
	private Node previous;
	private Node next;

	public Node(int pageNumber) {
		this.pageNumber = pageNumber;
		previous = null;
		next = null;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Node node = (Node) o;
		return pageNumber == node.pageNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pageNumber);
	}

}
