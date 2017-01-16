package Singleton;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

	private Properties properties = null;
	private static Configuration config = null;
	private static final String CONFIG_FILE_NAME = "config.properties";

	private Configuration() {
		properties = new Properties();
		readFromPropertyFile();
	}

	private void readFromPropertyFile() {
		try {
			InputStream stream = getClass().getResourceAsStream(
					CONFIG_FILE_NAME);
			properties.load(stream);
		} catch (IOException e) {
			System.out
					.println("IOException occured while reading configuration file");
		}
	}

	public static Configuration getInstance() {
		if (config == null)
			synchronized (Configuration.class) {
				if (config == null)
					config = new Configuration();
			}
		return config;
	}

	public String getConfiguration(String key) {
		return properties.getProperty(key);
	}
	
	/*
	 * to deal with Serialization, ANY-ACCESS-MODIFIER can be used
	 */
	private Object readResolve() {
		return config;
	}
}
