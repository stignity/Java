package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB implements AutoCloseable {
	Connection con;
	
	public ConnectToDB(String server, String database, String user, String password) throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database, user, password);
	}
	
	public void close() throws SQLException {
		con.close();
	}
	
	public Connection getConnection() {
		return con;
	}
}
