
/**
 * Static block and variables execution happens in textual order. 
 * Static variables can(only) be initialized in static block even though it comes before declaration. 
 */
public class ExecutionOrder {

	private static int four = method("four");
	
	static {
		two = 87;
		System.out.println(ExecutionOrder.one);
		// System.out.println(two); /* compilation error: Cannot reference a field before it is defined */
	}

	private static int one;
	private static int two;
	private static int three = 89;

	static {
		one = 19;
		System.out.println(one + ", " + two + ", " + three);
	}

	{
		one = 20;
	}

	private static int five = method("five");
	
	public static void main(String[] args) {
		System.out.println("main");
	}

	private static int method(String name) {
		System.out.println(name);
		return 0;
	}
	
	static {
		System.out.println("last");
	}
}

/* Output:
 * four
 * 0
 * 19, 87, 89 
 * five
 * last
 * main
 */