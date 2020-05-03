package data_structure.tree.binary;

import data_structure.tree.Node;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeTest {
	private static final String LEVELORDER = "15 8 20 2 11 27 6 10 12 22 30 3 7 14";
	private static final String PREORDER = "15 8 2 6 3 7 11 10 12 14 20 27 22 30";
	private static final String INORDER = "2 3 6 7 8 10 11 12 14 15 20 22 27 30";
	private static final String POSTORDER = "3 7 6 2 10 14 12 11 8 22 30 27 20 15";
	private static final String SPIRALORDER = "15 20 8 2 11 27 30 22 12 10 6 3 7 14";
	private static final String LEFT = "left";
	private static final String RIGHT = "right";

	private static BinaryTree tree = null;

	@Before
	public void setup() {
		plantBinaryTree();
	}

	private static void plantBinaryTree() {
		tree = new BinaryTree(15);
		tree.add(15, 8, LEFT);
		tree.add(15, 20, RIGHT);
		tree.add(8, 2, LEFT);
		tree.add(8, 11, RIGHT);
		tree.add(2, 6, RIGHT);
		tree.add(6, 3, LEFT);
		tree.add(6, 7, RIGHT);
		tree.add(11, 10, LEFT);
		tree.add(11, 12, RIGHT);
		tree.add(12, 14, RIGHT);
		tree.add(20, 27, RIGHT);
		tree.add(27, 22, LEFT);
		tree.add(27, 30, RIGHT);
	}

	@Test
	public void should_return_node_value_if_node_exists_in_the_tree() {
		assertEquals(27, tree.find(27).getData());
	}

	@Test
	public void should_return_null_if_node_exists_in_the_tree() {
		assertNull(tree.find(1));
	}

	@Test
	public void should_traverse_tree_in_level_order() {
		assertEquals(getTree(LEVELORDER), tree.levelOrderTraversal());
	}

	@Test
	public void should_traverse_tree_in_preorder() {
		assertEquals(getTree(PREORDER), tree.preorderTraversal());
	}

	@Test
	public void should_traverse_tree_in_inorder() {
		assertEquals(getTree(INORDER), tree.inorderTraversal());
	}

	@Test
	public void should_traverse_tree_in_postorder() {
		assertEquals(getTree(POSTORDER), tree.postorderTraversal());
	}

	@Test
	public void should_traverse_tree_in_spiral_order() {
		assertEquals(getTree(SPIRALORDER), tree.spiralOrderTraversal());
	}

	@Test
	public void should_return_height_of_the_tree() {
		assertEquals(4, tree.height());
	}

	@Test
	public void should_return_diameter_of_the_tree() {
		assertEquals(8, tree.diameter());
	}

	@Test
	public void should_return_true_if_tree_is_bst() {
		assertTrue(Trees.isBinarySearchTree(tree.getRoot()));
	}

	private List<Node> getTree(String traversalOrder) {
		List<Node> nodes = new ArrayList<>();
		for (String nodeData : traversalOrder.split(" "))
			nodes.add(new Node(Integer.parseInt(nodeData)));
		return nodes;
	}

}
