public class Subject {

	public Subject() {
		System.out.println("Inside constructor");
	}

	public String instanceMethod() {
		System.out.println("Inside instance method");
		return "instance";
	}

	public final String finalMethod() {
		System.out.println("Inside final method");
		return "final";
	}

	public static String staticMethod() {
		System.out.println("Inside static method");
		return "static";
	}

	private String privateMethod() {
		System.out.println("Inside private method");
		return "private";
	}
}
