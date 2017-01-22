

public class BlockExecutionOrder {

	/* Compilation: The blank final field i may not have been initialized */
	private final static int i;

	private static int init() {
		// throw new IllegalArgumentException();
		return 7;
	}

	static {
		j = 5;

		try {
			i = init();
		} catch (IllegalArgumentException e) {
			/* Compilation: The final field i may already have been assigned */
			//i = 10;
		}
	}
	
	private final static int j;

	public static void main(String[] args) {
		System.out.println("main-1");
		Super object = new Sub();
		System.out.println("main-2");
	}
}

class Super {
	{
		System.out.println("Parent-Instance-Block");
	}

	static {
		System.out.println("Parent-Static-Block");
	}

	public Super() {
		System.out.println("Parent-Constructor");
	}
}

class Sub extends Super {
	{
		System.out.println("Child-Instance-Block");
	}

	static {
		System.out.println("Child-Static-Block");
	}

	public Sub() {
		System.out.println("Child-Constructor");
	}
}