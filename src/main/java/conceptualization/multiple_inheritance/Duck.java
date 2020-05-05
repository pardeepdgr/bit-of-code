package conceptualization.multiple_inheritance;

import conceptualization.multiple_inheritance.fly.Bird;
import conceptualization.multiple_inheritance.swim.Intercessor;
import conceptualization.multiple_inheritance.swim.Swimmable;

public class Duck extends Bird implements Swimmable {

	private static Swimmable duck;

	public static void main(String[] args) {
		duck = new Intercessor();
		duck.swim(); //prints swimming..
	}

	@Override
	public void swim() {
		System.out.println("Duck is swimming");
	}

}
