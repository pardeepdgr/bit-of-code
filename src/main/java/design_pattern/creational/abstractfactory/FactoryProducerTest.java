package design_pattern.creational.abstractfactory;

import org.junit.Assert;
import org.junit.Test;

import design_pattern.creational.abstractfactory.type.Blue;
import design_pattern.creational.abstractfactory.type.Circle;
import design_pattern.creational.abstractfactory.type.Color;
import design_pattern.creational.abstractfactory.type.Green;
import design_pattern.creational.abstractfactory.type.Rectangle;
import design_pattern.creational.abstractfactory.type.Red;
import design_pattern.creational.abstractfactory.type.Shape;
import design_pattern.creational.abstractfactory.type.Square;

public class FactoryProducerTest {

	@Test
	public void testColorProduction() {
		AbstractFactory colorFactory = FactoryProducer.getFactory("color");
		Assert.assertTrue(colorFactory instanceof ColorFactory);

		Color red = colorFactory.getColor("red");
		Assert.assertTrue(red instanceof Red);

		Color green = colorFactory.getColor("green");
		Assert.assertTrue(green instanceof Green);

		Color blue = colorFactory.getColor("blue");
		Assert.assertTrue(blue instanceof Blue);
	}

	@Test
	public void testShapeProduction() {
		AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
		Assert.assertTrue(shapeFactory instanceof ShapeFactory);

		Shape circle = shapeFactory.getShape("circle");
		Assert.assertTrue(circle instanceof Circle);

		Shape rectangle = shapeFactory.getShape("rectangle");
		Assert.assertTrue(rectangle instanceof Rectangle);

		Shape square = shapeFactory.getShape("square");
		Assert.assertTrue(square instanceof Square);
	}

}
