package abstractfactory;

import org.junit.Assert;
import org.junit.Test;

import abstractfactory.type.Blue;
import abstractfactory.type.Circle;
import abstractfactory.type.Color;
import abstractfactory.type.Green;
import abstractfactory.type.Rectangle;
import abstractfactory.type.Red;
import abstractfactory.type.Shape;
import abstractfactory.type.Square;

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
