package stack;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Categories.ExcludeCategory;

public class StackTest {

	private Stack<Integer> stack = new Stack<Integer>(5);

	@Test
	public void pushTwoElement_PopTwoElement() {
		stack.push(3);
		stack.push(2);
		assertEquals(new Integer(2), stack.pop());
		assertEquals(new Integer(3), stack.pop());
	}

	@Test(expected = StackOverflow.class)
	public void overflowStack() {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
	}

	@Test(expected = StackUnderflow.class)
	public void underflowStack() {
		stack.pop();
	}
}
