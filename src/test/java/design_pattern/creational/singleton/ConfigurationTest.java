package design_pattern.creational.singleton;

import org.junit.Assert;
import org.junit.Test;

public class ConfigurationTest {

	@Test
	public void should_create_only_one_instance_of_configuration() {
		Configuration configOne = Configuration.getInstance();
		Configuration configTwo = Configuration.getInstance();

		Assert.assertEquals(configOne.hashCode(), configTwo.hashCode());
		Assert.assertEquals("mydb", configOne.getConfiguration("db.username"));
		Assert.assertEquals("password", configOne.getConfiguration("db.password"));
	}

	@Test
	public void should_create_only_one_instance_of_configuration_using_enum() {
		EnumConfiguration configOne = EnumConfiguration.INSTANCE;
		EnumConfiguration configTwo = EnumConfiguration.INSTANCE;

		Assert.assertEquals(configOne.hashCode(), configTwo.hashCode());
		Assert.assertEquals("mydb", configOne.getConfiguration("db.username"));
		Assert.assertEquals("password", configOne.getConfiguration("db.password"));
	}
}
