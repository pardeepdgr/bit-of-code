package design_pattern.creational.abstractfactory;

import design_pattern.creational.abstractfactory.type.Color;
import design_pattern.creational.abstractfactory.type.Shape;

public abstract class AbstractFactory {

	public abstract Color getColor(String color);

	public abstract Shape getShape(String shape);
}
