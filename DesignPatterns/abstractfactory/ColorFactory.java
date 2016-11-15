package abstractfactory;

import abstractfactory.type.Blue;
import abstractfactory.type.Color;
import abstractfactory.type.Green;
import abstractfactory.type.Red;
import abstractfactory.type.Shape;

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
