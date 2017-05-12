package tree.binary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import tree.Node;

public class BinaryTree {
	private Node root = null;

	public BinaryTree(int rootData) {
		root = new Node(rootData);
	}

	public void add(int parent, int child, String orientation) {
		Node parentNode = find(parent);
		Node childNode = new Node(child);

		if (parentNode != null) {
			if ("left".equals(orientation)) {
				if (parentNode.getLeft() == null)
					parentNode.setLeft(childNode);
				else
					System.out.println(parentNode.getData()
							+ " node already has left node");
			} else if ("right".equals(orientation)) {
				if (parentNode.getRight() == null)
					parentNode.setRight(childNode);
				else
					System.out.println(parentNode.getData()
							+ " node already has right node");
			}
		}
	}

	public Node find(int data) {
		if (root != null) {
			List<Node> nodes = levelOrderTraversal();
			for (Node node : nodes) {
				if (node != null && data == node.getData())
					return node;
			}
		}
		return null;
	}

	public List<Node> levelOrderTraversal() {
		Node tempNode = new Node();
		Queue<Node> queue = new LinkedList<Node>();
		List<Node> nodes = new ArrayList<Node>();

		if (root != null) {
			queue.offer(root);
			while (!queue.isEmpty()) {
				tempNode = queue.poll();
				nodes.add(tempNode);
				// System.out.print(tempNode.getData() + " ");

				if (tempNode.getLeft() != null) {
					queue.offer(tempNode.getLeft());
					nodes.add(tempNode.getLeft());
				}
				if (tempNode.getRight() != null) {
					queue.offer(tempNode.getRight());
					nodes.add(tempNode.getLeft());
				}
			}
		}
		return nodes;
	}

	public List<Node> preorderTraversal() {
		Stack<Node> stack = new Stack<Node>();
		List<Node> nodes = new ArrayList<Node>();

		while (true) {
			if (root != null) {
				System.out.print(root.getData() + " ");
				nodes.add(root);
				stack.push(root);
				root = root.getLeft();
			} else if (stack.empty()) {
				break;
			} else {
				root = stack.pop();
				root = root.getRight();
			}
		}
		return nodes;
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

	public List<Node> postorderTraversal() {
		Stack<Node> stack = new Stack<Node>();
		List<Node> nodes = new ArrayList<Node>();

		while (true) {
			if (root != null) {
				stack.push(root);
				root = root.getLeft();
			} else if (stack.empty()) {
				break;
			} else {
				if (stack.peek().getRight() != null) {
					root = stack.peek().getRight();
				} else {
					root = stack.pop();
					System.out.print(root.getData() + " ");
					nodes.add(root);
					while (!stack.empty() && root == stack.peek().getRight()) {
						root = stack.pop();
						System.out.print(root.getData() + " ");
						nodes.add(root);
					}
					root = stack.empty() ? null : stack.peek().getRight();
				}
			}
		}
		return nodes;
	}

	public int height() {
		return height(root) - 1;
	}

	private int height(Node node) {
		if (node == null)
			return 0;
		return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
	}

	public int diameter() {
		return diameter(root);
	}

	private int diameter(Node node) {
		if (node == null)
			return 0;
		
		int lHeight = height(node.getLeft());
		int rHeight = height(node.getRight());
		int lDiameter = diameter(node.getLeft());
		int rDiameter = diameter(node.getRight());
		return Math.max((lHeight + rHeight + 1), Math.max(lDiameter, rDiameter));
	}
}
