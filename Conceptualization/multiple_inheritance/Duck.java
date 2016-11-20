package multiple_inheritance;
/**
 * class A extends B, C
 */
public class Duck extends Bird implements Swimmable {

	public static void main(String[] args) {
		Swimmable duck = new Intercessor();
		duck.swim();
	}

	@Override
	public void swim() {
		System.out.println("swiming");
	}
}
