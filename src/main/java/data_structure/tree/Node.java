package data_structure.tree;

public class Node {

	private int data;
	private Node left, right;

	public Node() {

	}

	public Node(int data) {
		this.data = data;
		left = right = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public boolean equals(Object node) {
		if (node instanceof Node)
			return this.data == (((Node) node).data);
		return false;
	}
}
