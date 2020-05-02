package data_structure.tree.binary;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import data_structure.tree.Node;

public class BinaryTreeTest {

	private static final String PREORDER = "15 8 2 6 3 7 11 10 12 14 20 27 22 30";
	private static final String INORDER = "2 3 6 7 8 10 11 12 14 15 20 22 27 30";
	private static final String POSTORDER = "3 7 6 2 10 14 12 11 8 22 30 27 20 15";
	private static final String SPIRALORDER = "15 20 8 2 11 27 30 22 12 10 6 3 7 14";

	private static BinaryTree tree = null;

	@BeforeClass
	public static void setup() {
		plantBinaryTree();
	}

	private static void plantBinaryTree() {
		tree = new BinaryTree(15);
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
		assertEquals(27, tree.find(27).getData());
	}

	@Test
	public void findNode_WhenItDoesnotExistInTree() {
		assertNull(tree.find(1));
	}

	@Test
	public void testPreorderTraversal() {
		assertEquals(getTraversalOrder(PREORDER), tree.preorderTraversal());
	}

	@Test
	public void testInorderTraversal() {
		assertEquals(getTraversalOrder(INORDER), tree.inorderTraversal());
	}

	@Test
	public void testPostorderTraversal() {
		assertEquals(getTraversalOrder(POSTORDER), tree.postorderTraversal());
	}

	@Test
	public void testSpiralOrderTraversal() {
		assertEquals(getTraversalOrder(SPIRALORDER), tree.spiralOrderTraversal());
	}

	@Test
	public void testHeightOfTree() {
		assertEquals(4, tree.height());
	}

	@Test
	public void testDiameterOfTree() {
		assertEquals(8, tree.diameter());
	}

	@Test
	public void testIfTreeIsBST() {
		assertTrue(Trees.isBinarySearchTree(tree.getRoot()));
	}

	private List<Node> getTraversalOrder(String traversalOrder) {
		System.out.println();
		List<Node> nodes = new ArrayList<Node>();
		for (String nodeData : traversalOrder.split(" "))
			nodes.add(new Node(Integer.parseInt(nodeData)));
		return nodes;
	}

}
