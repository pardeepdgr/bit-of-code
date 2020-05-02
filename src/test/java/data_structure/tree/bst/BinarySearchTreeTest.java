package data_structure.tree.bst;

import data_structure.tree.Node;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BinarySearchTreeTest {

	private static BinarySearchTree tree = null;
	private static String INORDER = "1 5 7 10 30 45 50 95 97 100 120 127";

	@BeforeClass
	public static void setup() {
		plantBinarySearchTree();
	}

	private static void plantBinarySearchTree() {
		tree = new BinarySearchTree(50);
		tree.add(10);
		tree.add(100);
		tree.add(5);
		tree.add(127);
		tree.add(95);
		tree.add(45);
		tree.add(30);
		tree.add(1);
		tree.add(7);
		tree.add(97);
		tree.add(120);
	}

	@Test
	public void findNode_WhenItExistInTree() {
		assertEquals(97, tree.find(97).getData());
	}

	@Test
	public void findNode_WhenItDoesnotExistInTree() {
		assertNull(tree.find(11));
	}

	@Test
	public void findMinNodeInTree() {
		assertEquals(1, tree.findMin().getData());
	}

	@Test
	public void findMaxNodeInTree() {
		assertEquals(127, tree.findMax().getData());
	}

	@Test
	public void testInorderTraversal() {
		assertEquals(tree.inorderTraversal(), getExpectedOrder(INORDER));
	}

	@Test
	public void testDeletionOfANode_WhenNodeIsLeafNode() {
		tree.delete(120);
		assertEquals(tree.inorderTraversal(), getExpectedOrder(INORDER.replace("120 ", "")));
	}

	@Test
	public void testDeletionOfANode_WhenNodehasOnlyOneChildNode() {
		tree.delete(95);
		assertEquals(tree.inorderTraversal(), getExpectedOrder(INORDER.replace("95 ", "")));
	}

	@Test
	public void testDeletionOfANode_WhenNodehasTwoChildNode() {
		tree.delete(10);
		assertEquals(tree.inorderTraversal(), getExpectedOrder(INORDER.replace("10 ", "")));
	}

	private List<Node> getExpectedOrder(String traversalOrder) {
		System.out.println();
		List<Node> nodes = new ArrayList<Node>();
		for (String nodeData : traversalOrder.split(" "))
			nodes.add(new Node(Integer.parseInt(nodeData)));
		return nodes;
	}
}
