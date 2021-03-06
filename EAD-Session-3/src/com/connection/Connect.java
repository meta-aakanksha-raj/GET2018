package com.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Connect {
	/**
 	 * method to create a connection with the database
 	 * @return connection 
 	 */
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/employee_forum";
			String admin = "root";
			String password = "root";
			connection = (Connection) DriverManager.getConnection(url, admin, password);
		}
		catch (ClassNotFoundException exception) {
			exception.printStackTrace();
			System.exit(1);
		}
		catch (SQLException exception) {
			exception.printStackTrace();
			System.exit(2);
		}
		return connection;
	}
}
