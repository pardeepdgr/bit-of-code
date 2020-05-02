package design_pattern.structural.decorator;

public class ShapeShadowDecorator extends ShapeDecorator {

	public ShapeShadowDecorator(Shape shape) {
		super(shape);
	}

	@Override
	public void draw() {
		decoratedShape.draw();
		setShadowBorder(decoratedShape);
	}

	private void setShadowBorder(Shape decoratedShape) {
		System.out.print(" with shadowed border.");
	}
}
