package decorator;

public class ShapeColorDecorator extends ShapeDecorator {

	public ShapeColorDecorator(Shape shape) {
		super(shape);
	}

	@Override
	public void draw() {
		setColorBorder(decoratedShape);
		decoratedShape.draw();

	}

	private void setColorBorder(Shape decoratedShape) {
		System.out.print("Colored ");
	}
}
