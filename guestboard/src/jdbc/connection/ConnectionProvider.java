/*
 * 커넥션을 구할 때 사용할 ConnectionProvider
 * JDBC URL = web.xml에서 지정한 poolName값인 board
 */

package jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:apache:commons:dbcp:board");
	}
}
