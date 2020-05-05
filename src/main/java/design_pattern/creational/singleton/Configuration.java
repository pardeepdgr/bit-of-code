package design_pattern.creational.singleton;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
	private Properties properties;
	private static Configuration config = null;
	private static final String CONFIG = "/design_pattern/creational/singleton/config.properties";

	private Configuration() {
		properties = new Properties();
		readFromPropertyFile();
	}

	private void readFromPropertyFile() {
		try {
			InputStream stream = getClass().getResourceAsStream(CONFIG);
			properties.load(stream);
		} catch (IOException e) {
			e.printStackTrace();
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
	
	/**
	 * to deal with Serialization
	 * Any ACCESS MODIFIER can be used
	 */
	private Object readResolve() {
		return config;
	}
}
