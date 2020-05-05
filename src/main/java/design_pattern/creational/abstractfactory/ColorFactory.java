package design_pattern.creational.abstractfactory;

import design_pattern.creational.abstractfactory.type.Blue;
import design_pattern.creational.abstractfactory.type.Color;
import design_pattern.creational.abstractfactory.type.Green;
import design_pattern.creational.abstractfactory.type.Red;
import design_pattern.creational.abstractfactory.type.Shape;

public class ColorFactory extends AbstractFactory{

	@Override
	public Color getColor(String color) {
		
		if ("red".equals(color))
			return new Red();
		else if ("green".equals(color))
			return new Green();
		else if ("blue".equals(color))
			return new Blue();
		else
			return null;
	}

	@Override
	public Shape getShape(String shape) {
		return null;
	}
}
