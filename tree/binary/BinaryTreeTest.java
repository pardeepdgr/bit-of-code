package tree.binary;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import tree.Node;

public class BinaryTreeTest {

	private static final String PREORDER = "15 8 2 6 3 7 11 10 12 14 20 27 22 30";
	private static final String INORDER = "2 3 6 7 8 10 11 12 14 15 20 22 27 30";
	private static final String POSTORDER = "3 7 6 2 10 14 12 11 8 22 30 27 20 15";

	private static BinaryTree tree = null;

	@BeforeClass
	public static void setup() {
		plantBinaryTree();
	}

	private static void plantBinaryTree() {
		tree = new BinaryTree(new Node(15));
		tree.add(15, 8, "left");
		tree.add(15, 20, "right");
		tree.add(8, 2, "left");
		tree.add(8, 11, "right");
		tree.add(2, 6, "right");
		tree.add(6, 3, "left");
		tree.add(6, 7, "right");
		tree.add(11, 10, "left");
		tree.add(11, 12, "right");
		tree.add(12, 14, "right");
		tree.add(20, 27, "right");
		tree.add(27, 22, "left");
		tree.add(27, 30, "right");
	}

	@Test
	public void findNode_WhenItExistInTree() {
		assertEquals(new Node(27), tree.find(27));
	}

	@Test
	public void findNode_WhenItDoesnotExistInTree() {
		assertNull(tree.find(1));
	}

	@Test
	public void testPreorderTraversal() {
		assertEquals(tree.preorderTraversal(), getTraversalOrder(PREORDER));
	}

	@Test
	public void testInorderTraversal() {
		assertEquals(tree.inorderTraversal(), getTraversalOrder(INORDER));
	}

	@Test
	public void testPostorderTraversal() {
		assertEquals(tree.postorderTraversal(), getTraversalOrder(POSTORDER));
	}

	private List<Node> getTraversalOrder(String traversalOrder) {
		System.out.println();
		List<Node> nodes = new ArrayList<Node>();
		for (String nodeData : traversalOrder.split(" "))
			nodes.add(new Node(Integer.parseInt(nodeData)));
		return nodes;
	}

}
