package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static final String DRIVERNAME = "com.mysql.jdbc.Driver";   
	private static final String DBURL = "jdbc:mysql://localhost:3306/salarymanage?characterEncoding=UTF-8";   
	private static final String USER = "root";   
	private static final String PWD = "root"; 
	private static Connection conn = null; 
	
	public static Connection getConnection() {
		try {
			Class.forName(DRIVERNAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		try {
			conn = DriverManager.getConnection(DBURL,USER, PWD);
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		return conn;
	}
}
