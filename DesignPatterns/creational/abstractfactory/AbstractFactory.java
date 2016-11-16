package abstractfactory;

import abstractfactory.type.Color;
import abstractfactory.type.Shape;

public abstract class AbstractFactory {

	public abstract Color getColor(String color);

	public abstract Shape getShape(String shape);
}
