package facade.subsystem;

import java.sql.Connection;
import java.sql.SQLException;

public class HiveConnectionManager {

	public static Connection getHiveConnection(String type, String url,
			String userName, String password) throws SQLException,
			ClassNotFoundException {
		return null;
	}

	public void generateReport(String tableName, Connection connection) {

	}

}
