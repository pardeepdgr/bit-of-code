package abstractfactory;

import abstractfactory.type.Circle;
import abstractfactory.type.Color;
import abstractfactory.type.Rectangle;
import abstractfactory.type.Shape;
import abstractfactory.type.Square;

public class ShapeFactory extends AbstractFactory{

	@Override
	public Shape getShape(String shape) {
		
		if ("circle".equals(shape))
			return new Circle();
		else if ("rectangle".equals(shape))
			return new Rectangle();
		else if ("square".equals(shape))
			return new Square();
		else
			return null;
	}

	@Override
	public Color getColor(String color) {
		return null;
	}
}
