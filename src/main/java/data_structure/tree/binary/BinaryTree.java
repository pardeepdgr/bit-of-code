package data_structure.tree.binary;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import data_structure.tree.Node;

public class BinaryTree {
	private Node root;

	public BinaryTree(int rootData) {
		root = new Node(rootData);
	}

	public Node getRoot() {
		return root;
	}

	public void add(int parent, int child, String orientation) {
		Node parentNode = find(parent);
		Node childNode = new Node(child);

		if (parentNode != null) {
			if ("left".equals(orientation)) {
				if (parentNode.getLeft() == null)
					parentNode.setLeft(childNode);
				else
					System.out.println(parentNode.getData() + " node already has left node");
			} else if ("right".equals(orientation)) {
				if (parentNode.getRight() == null)
					parentNode.setRight(childNode);
				else
					System.out.println(parentNode.getData() + " node already has right node");
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
		Node node;
		Queue<Node> queue = new LinkedList<>();
		List<Node> nodes = new ArrayList<>();

		if (root != null) {
			queue.offer(root);
			nodes.add(root);
			while (!queue.isEmpty()) {
				node = queue.poll();

				if (node.getLeft() != null) {
					queue.offer(node.getLeft());
					nodes.add(node.getLeft());
				}
				if (node.getRight() != null) {
					queue.offer(node.getRight());
					nodes.add(node.getRight());
				}
			}
		}
		return nodes;
	}

	public List<Node> preorderTraversal() {
		Stack<Node> stack = new Stack<>();
		List<Node> nodes = new ArrayList<>();

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
		Stack<Node> stack = new Stack<>();
		List<Node> nodes = new ArrayList<>();

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
		Stack<Node> stack = new Stack<>();
		List<Node> nodes = new ArrayList<>();

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

	public List<Node> spiralOrderTraversal() {
		List<Node> nodes = new ArrayList<>();
		Deque<Node> deque = new LinkedList<>();

		Node node;
		Node separator = null;
		deque.offer(separator);
		deque.offerFirst(root);

		while (deque.size() > 1) {

			while (deque.peekFirst() != separator) {
				node = deque.pollFirst();
				if (node.getLeft() != null)
					deque.offerLast(node.getLeft());
				if (node.getRight() != null)
					deque.offerLast(node.getRight());
				System.out.print(node.getData() + " ");
				nodes.add(node);
			}

			while (deque.peekLast() != separator) {
				node = deque.pollLast();
				if (node.getRight() != null)
					deque.offerFirst(node.getRight());
				if (node.getLeft() != null)
					deque.offerFirst(node.getLeft());
				System.out.print(node.getData() + " ");
				nodes.add(node);
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
