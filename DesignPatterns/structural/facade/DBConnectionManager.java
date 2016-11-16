package facade;

import java.sql.Connection;
import java.sql.SQLException;

import facade.subsystem.HiveConnectionManager;
import facade.subsystem.PostgreSQLConnectionManager;

/**
 * Provide a unified interface to a set of interfaces in a subsystem.
 * Facade Pattern defines a higher-level interface that makes the subsystem easier to use.
 * 
 * A Facade shields the user from the complex details of the system 
 * and provides them with a simplified view of it which is easy to use.
 * 
 * Drawback of it is hardwiring subsystems. 
 * This is fine if the subsystem never changes, but if it does, your Facade could be broken. 
 */
public class DBConnectionManager {

	public static Connection getConnection(Type type, String url,
			String userName, String password) throws ClassNotFoundException,
			SQLException {
		Connection connection = null;
		switch (type) {

		case POSTGRESQL:
			connection = PostgreSQLConnectionManager.getPostgreSQLConnection(
					"POSTGRESQL", url, userName, password);
			break;

		case HIVE:
			connection = HiveConnectionManager.getHiveConnection("HIVE", url,
					userName, password);
			break;
		}
		return connection;
	}

}

enum Type {
	POSTGRESQL, HIVE;
}
