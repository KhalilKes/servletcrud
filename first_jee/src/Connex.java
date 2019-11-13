import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connex {
	
	public static Connection getConnected() throws ClassNotFoundException, SQLException {
		
		String host = "localhost";
		String db = "javatestbed";
		String user = "root";
		String password = "";
		
		return getConnected(host, db, user, password);
		
	}
	
	public static Connection getConnected(String host, String db, String user, String password) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String connectionURL = "jdbc:mysql://" + host + ":3306/" + db;
		
		Connection conn = DriverManager.getConnection(connectionURL, user, password);
		
		return conn;
		
	}

}
