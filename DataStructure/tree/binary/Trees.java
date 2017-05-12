package tree.binary;

import java.util.Deque;
import java.util.LinkedList;

import tree.Node;

public class Trees {

	public static boolean isBinarySearchTree(Node root) {
		int current;
		int previous = Integer.MIN_VALUE;
		Deque<Node> stack = new LinkedList<Node>();

		do {
			if (root != null) {
				stack.addFirst(root);
				root = root.getLeft();
			} else {
				root = stack.pollFirst();
				current = root.getData();
				if (current < previous)
					return false;
				previous = current;
				root = root.getRight();
			}
		} while (stack.isEmpty());
		return true;
	}

}
