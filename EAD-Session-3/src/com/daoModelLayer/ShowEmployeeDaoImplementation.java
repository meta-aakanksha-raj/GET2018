package com.daoModelLayer;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.connection.Connect;
import com.dao.DAO;
import com.model.Employees;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;

public class ShowEmployeeDaoImplementation implements DAO<Employees> {
	private List<Employees> resultList = new ArrayList<Employees>();
	String strSelect = "Select * From Employees";

	@Override
	public List<Employees> getAll() {
		try (
			// Step 1: Allocate a database 'Connection' object
			Connection conn = Connect.getConnection();
			// In MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"

			// Step 2: Allocate a 'Statement' object in the Connection
			PreparedStatement stmt = conn.prepareStatement(strSelect);) {
			
				// Step 3: Execute a SQL SELECT query, the query result
				ResultSet rset = (ResultSet) stmt.executeQuery();
			
			// Move the cursor to the next row, return false if no more row
			while (rset.next()) {
				String firstName = rset.getString("firstName");
				String lastName = rset.getString("lastName");
				String email = rset.getString("email");
				int age = rset.getInt("age");
				Employees object = new Employees(firstName, lastName, email, age);
				resultList.add(object);
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	@Override
	public List<Employees> get(Employees emp) {
		return null;
	}

	@Override
	public boolean add(Employees t) {
		return false;
	}
}
