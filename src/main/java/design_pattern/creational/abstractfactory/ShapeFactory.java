package design_pattern.creational.abstractfactory;

import design_pattern.creational.abstractfactory.type.Circle;
import design_pattern.creational.abstractfactory.type.Color;
import design_pattern.creational.abstractfactory.type.Rectangle;
import design_pattern.creational.abstractfactory.type.Shape;
import design_pattern.creational.abstractfactory.type.Square;

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
