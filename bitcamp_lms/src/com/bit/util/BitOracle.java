package com.bit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BitOracle {
	
	private static Connection conn;                                         
	private final static String driver = "oracle.jdbc.OracleDriver";        
	private final static String url = "jdbc:oracle:thin:@192.168.3.8:1521:xe";
	private final static String user = "hr";                             
	private final static String password = "hr";                         
	
	public BitOracle() {
	}
	
	public static Connection getConnection() {
		try {
			if (conn == null || conn.isClosed()) {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
