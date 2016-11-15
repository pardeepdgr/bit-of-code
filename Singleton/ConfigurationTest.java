package Singleton;

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
		Assert.assertEquals(configOne, configTwo);
	}

	@Test
	public void verifyConfigValues() {
		Configuration config = Configuration.getInstance();

		Assert.assertEquals(USERNAME_VAL, config.getConfiguration(USERNAME));
		Assert.assertEquals(PASSWORD_VAL, config.getConfiguration(PASSWORD));
	}
}
