package data_structure.tree.bst;

import data_structure.tree.Node;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BinarySearchTreeTest {
	private static BinarySearchTree tree = null;
	private static String INORDER = "1 5 7 10 30 45 50 95 97 100 120 127";

	@Before
	public void setup() {
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
	public void should_return_node_value_if_node_exists_in_the_bst_tree() {
		assertEquals(97, tree.find(97).getData());
	}

	@Test
	public void should_return_null_if_node_does_not_exists_in_the_bst_tree() {
		assertNull(tree.find(11));
	}

	@Test
	public void should_return_node_which_has_minimum_value_of_the_bst_tree() {
		assertEquals(1, tree.findMin().getData());
	}

	@Test
	public void should_return_node_which_has_maximum_value_of_the_bst_tree() {
		assertEquals(127, tree.findMax().getData());
	}

	@Test
	public void should_traverse_bst_tree_in_inorder() {
		assertEquals(tree.inorderTraversal(), getBstTree(INORDER));
	}

	@Test
	public void should_delete_leaf_node_of_the_bst() {
		tree.delete(120);
		assertEquals(getBstTree(INORDER.replace("120 ", "")), tree.inorderTraversal());
	}

	@Test
	public void should_delete_node_when_it_has_only_one_child() {
		tree.delete(95);
		assertEquals(getBstTree(INORDER.replace("95 ", "")), tree.inorderTraversal());
	}

	@Test
	public void should_delete_node_when_it_has_two_child() {
		tree.delete(10);
		assertEquals(getBstTree(INORDER.replace("10 ", "")), tree.inorderTraversal());
	}

	private List<Node> getBstTree(String traversalOrder) {
		List<Node> nodes = new ArrayList<>();
		for (String nodeData : traversalOrder.split(" "))
			nodes.add(new Node(Integer.parseInt(nodeData)));
		return nodes;
	}
}
