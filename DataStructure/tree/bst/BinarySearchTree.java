package tree.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tree.Node;

public class BinarySearchTree {
	private Node root = null;

	public BinarySearchTree(int rootData) {
		root = new Node(rootData);
	}

	public void add(int data) {
		Node currentNode = root;
		Node node = new Node(data);

		while (true) {
			int currentNodeData = currentNode.getData();

			if (data < currentNodeData) {
				if (currentNode.getLeft() == null) {
					currentNode.setLeft(node);
					break;
				}
				currentNode = currentNode.getLeft();
			} else if (data > currentNodeData) {
				if (currentNode.getRight() == null) {
					currentNode.setRight(node);
					break;
				}
				currentNode = currentNode.getRight();
			} else {
				break;
			}
		}
	}

	public void delete(int data) {
		Node parent = null;
		Node node = root;

		while (node != null && node.getData() != data) {
			parent = node;
			if (data < node.getData())
				node = node.getLeft();
			else
				node = node.getRight();
		}

		if (node == null)
			throw new NodeNotFoundException();

		if (isLeafNode(node))
			deleteLeafNode(data, parent);
		else if (hasOnlyLeftChild(node))
			replaceNodeWithLeftChild(data, parent, node);
		else if (hasOnlyRightChild(node))
			replaceNodeWithRightChild(data, parent, node);
		else
			replaceNodeWithLargestNodeInLeftSubtree(node);
	}

	private void deleteLeafNode(int data, Node parent) {
		if (parent != null) {
			if (data < parent.getData())
				parent.setLeft(null);
			else
				parent.setRight(null);
		}
	}

	private void replaceNodeWithLeftChild(int data, Node parent, Node node) {
		Node child = node.getLeft();
		node.setLeft(null);
		setChildNode(data, parent, child);
	}

	private void replaceNodeWithRightChild(int data, Node parent, Node node) {
		Node child = node.getRight();
		node.setRight(null);
		setChildNode(data, parent, child);
	}

	private void replaceNodeWithLargestNodeInLeftSubtree(Node node) {
		Node parent = null;
		Node child = node.getLeft();
		while (child.getRight() != null) {
			parent = child;
			child = child.getRight();
		}
		parent.setRight(null);
		node.setData(child.getData());
		child = null;
	}

	private void setChildNode(int data, Node parent, Node child) {
		if (parent.getLeft().getData() == data)
			parent.setLeft(child);
		else
			parent.setRight(child);
	}

	private boolean isLeafNode(Node node) {
		return node.getLeft() == null && node.getRight() == null;
	}

	private boolean hasOnlyRightChild(Node node) {
		return node.getLeft() == null && node.getRight() != null;
	}

	private boolean hasOnlyLeftChild(Node node) {
		return node.getLeft() != null && node.getRight() == null;
	}

	public Node find(int data) {
		Node currentNode = root;

		while (true) {
			int currentNodeData = currentNode.getData();

			if (data < currentNodeData) {
				if (currentNode.getLeft() == null)
					return null;
				currentNode = currentNode.getLeft();
			} else if (data > currentNodeData) {
				if (currentNode.getRight() == null)
					return null;
				currentNode = currentNode.getRight();
			} else if (data == currentNodeData)
				return currentNode;
		}
	}

	public Node findMax() {
		Node currentNode = root;

		while (true) {
			if (currentNode.getRight() == null)
				return currentNode;
			currentNode = currentNode.getRight();
		}
	}

	public Node findMin() {
		Node currentNode = root;

		while (true) {
			if (currentNode.getLeft() == null)
				return currentNode;
			currentNode = currentNode.getLeft();
		}
	}

	public List<Node> inorderTraversal() {
		Stack<Node> stack = new Stack<Node>();
		List<Node> nodes = new ArrayList<Node>();

		while (true) {
			if (root != null) {
				stack.push(root);
				root = root.getLeft();
			} else if (stack.empty()) {
				break;
			} else {
				root = stack.pop();
				System.out.print(root.getData() + " ");
				nodes.add(root);
				root = root.getRight();
			}
		}
		return nodes;
	}

	public class NodeNotFoundException extends RuntimeException {
		private static final long serialVersionUID = -1584586717281494347L;
	}
}
