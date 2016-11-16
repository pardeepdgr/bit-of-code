package facade.subsystem;

import java.sql.Connection;
import java.sql.SQLException;

public class PostgreSQLConnectionManager {

	public static Connection getPostgreSQLConnection(String type, String url,
			String userName, String password) throws SQLException,
			ClassNotFoundException {
		return null;
	}

	public void generateReport(String tableName, Connection connection) {

	}

}
