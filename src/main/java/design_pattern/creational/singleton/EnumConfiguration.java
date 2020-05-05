package design_pattern.creational.singleton;

import java.io.IOException;
import java.util.Properties;

public enum EnumConfiguration {

	INSTANCE;

	private Properties properties = null;
	private static final String CONFIG = "/design_pattern/creational/singleton/config.properties";

	private EnumConfiguration() {
		properties = new Properties();
		readFromPropertyFile();
	}

	private void readFromPropertyFile() {
		try {
			properties.load(this.getClass().getResourceAsStream(CONFIG));
		} catch (IOException e) {
			System.out.println("IOException occured while reading configuration file");
		}
	}

	public String getConfiguration(String key) {
		return properties.getProperty(key);
	}
}
