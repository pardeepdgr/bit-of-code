package data_structure.stack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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

	@Test
	public void sortStack() {
		stack.push(1);
		stack.push(41);
		stack.push(12);
		stack.push(25);
		stack.push(19);
		stack.sort();

		assertEquals(new Integer(41), stack.pop());
		assertEquals(new Integer(25), stack.pop());
		assertEquals(new Integer(19), stack.pop());
		assertEquals(new Integer(12), stack.pop());
		assertEquals(new Integer(1), stack.pop());
	}
}
