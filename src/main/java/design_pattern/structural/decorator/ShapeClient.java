package design_pattern.structural.decorator;

/**
 * Decorators attach additional responsibilities to an object dynamically. It
 * provides a flexible alternative to subclassing for extending functionality.
 * 
 * Application: When it is required to add behavior or state to individual
 * objects at run-time. Inheritance is not feasible because it is static and
 * applies to an entire class.
 * 
 * The disadvantage of decorator design pattern is that it uses a lot of similar
 * kind of objects (decorators).
 * 
 * Decorator pattern is used a lot in Java IO classes, such as FileReader,
 * BufferedReader etc.
 */
public class ShapeClient {

	public static void main(String[] args) {
		Shape circle = new Circle();
		Shape rectangle = new Rectangle();
		circle.draw();
		System.out.println();
		rectangle.draw();
		System.out.println("\n");

		Shape coloredCircle = new ShapeColorDecorator(circle);
		Shape coloredRectangle = new ShapeColorDecorator(rectangle);
		coloredCircle.draw();
		System.out.println();
		coloredRectangle.draw();
		System.out.println("\n");

		Shape shadowedColoredCircle = new ShapeShadowDecorator(coloredCircle);
		Shape shadowedColoredRectangle = new ShapeShadowDecorator(coloredRectangle);
		shadowedColoredCircle.draw();
		System.out.println();
		shadowedColoredRectangle.draw();
		System.out.println("\n");
	}
}
