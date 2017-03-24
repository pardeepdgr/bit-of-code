package singleton;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum EnumConfiguration {

	INSTANCE;

	private Properties properties = null;
	private static final String CONFIG_FILE_NAME = "config.properties";

	private EnumConfiguration() {
		properties = new Properties();
		readFromPropertyFile();
	}

	private void readFromPropertyFile() {
		try {
			InputStream stream = getClass().getResourceAsStream(CONFIG_FILE_NAME);
			properties.load(stream);
		} catch (IOException e) {
			System.out.println("IOException occured while reading configuration file");
		}
	}

	public String getConfiguration(String key) {
		return properties.getProperty(key);
	}
}
