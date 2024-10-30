package connectDB;

import java.sql.*;

import javax.swing.JOptionPane;

public class ConnectDB {	
	// THAITINH: ten thiet bi
	// 1433: port number
	private static final String url = "jdbc:sqlserver://THAITINH:1433;databaseName=QUAN_CAFE_DATABASE;encrypt=true;trustServerCertificate=true";
	private static final String username = "sa";
	private static final String password = "admin";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}
