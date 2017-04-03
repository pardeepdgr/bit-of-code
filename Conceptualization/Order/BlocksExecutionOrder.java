
/**
 * Parent-Static-Block 
 * Child-Static-Block 
 * Parent-Instance-Block
 * Parent-Constructor 
 * Child-Instance-Block 
 * Child-Constructor
 */
public class BlocksExecutionOrder {

	public static void main(String[] args) {
		Super object = new Sub();
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
