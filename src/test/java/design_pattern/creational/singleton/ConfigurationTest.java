package design_pattern.creational.singleton;

import org.junit.Assert;
import org.junit.Test;

public class ConfigurationTest {

	private final static String USERNAME = "db.username";
	private final static String PASSWORD = "db.password";

	private final static String USERNAME_VAL = "mydb";
	private final static String PASSWORD_VAL = "password";

	@Test
	public void testSingletonBehavior() {
		Configuration configOne = Configuration.getInstance();
		Configuration configTwo = Configuration.getInstance();
		Assert.assertEquals(configOne.hashCode(), configTwo.hashCode());
	}

	@Test
	public void verifyConfigValues() {
		Configuration config = Configuration.getInstance();

		Assert.assertEquals(USERNAME_VAL, config.getConfiguration(USERNAME));
		Assert.assertEquals(PASSWORD_VAL, config.getConfiguration(PASSWORD));
	}

	/* Enum Version */
	@Test
	public void testEnumSingletonBehavior() {
		EnumConfiguration configOne = EnumConfiguration.INSTANCE;
		EnumConfiguration configTwo = EnumConfiguration.INSTANCE;
		Assert.assertEquals(configOne.hashCode(), configTwo.hashCode());
	}

	@Test
	public void verifyEnumConfigValues() {
		EnumConfiguration config = EnumConfiguration.INSTANCE;

		Assert.assertEquals(USERNAME_VAL, config.getConfiguration(USERNAME));
		Assert.assertEquals(PASSWORD_VAL, config.getConfiguration(PASSWORD));
	}
}
