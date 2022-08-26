package com.quintrix.huang.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

@SuppressWarnings("unused")
public class SqlTest {
	public static void TrySql() {
		System.out.println("Begin sql testing...");
		Connection conn = null;
		try {
			System.out.println("Forming connection...");
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String userName = "root";
			String password = "Matrix242944";
			String url = "jdbc:MySQL://localhost:3306";
			conn = DriverManager.getConnection(url, userName, password);

			System.out.println("Connection successful");
			System.out.println("Creating database...");
			try (Statement statem = conn.createStatement()){
				statem.executeUpdate("CREATE DATABASE IF NOT EXISTS `TEST`");
				System.out.println("Database created successfully");
			}
			catch (SQLException e) {
				System.out.println("A sql error has occured");
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("a connection error has occurred");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					System.out.println("Terminating connection");
					conn.close();
					System.out.println("Connection terminated");
				} catch (Exception e) {
					System.out.println("Termination error");
					e.printStackTrace();
				}
			}
		}
	}

	public static void InitSql() {
		Connection conn = null;
		try {
			System.out.println("Forming connection...");
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String userName = "root";
			String password = "Matrix242944";
			String url = "jdbc:MySQL://localhost:3306/TEST";
			conn = DriverManager.getConnection(url, userName, password);

			System.out.println("Connection successful");

			// initialize the database
			// init the department tables
			try (Statement statem = conn.createStatement()){
				statem.executeUpdate(Filer.readFile("sql/departments.sql"));
				statem.executeUpdate(Filer.readFile("sql/employees.sql"));
			}
			catch (SQLException e) {
				System.out.println("A sql error has occured");
				e.printStackTrace();
			}
			System.out.println(Filer.readFile("sql/departments.sql"));
			
			// init the employee tables
			System.out.println(Filer.readFile("sql/employees.sql"));

			// insert a few values
		} catch (Exception e) {
			System.out.println("a connection error has occurred");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					System.out.println("Terminating connection");
					conn.close();
					System.out.println("Connection terminated");
				} catch (Exception e) {
					System.out.println("Termination error");
					e.printStackTrace();
				}
			}
		}
	}

	public static void SqlQuery() {
		System.out.println("Begin sql query...");
		Connection conn = null;
		try {
			System.out.println("Forming connection...");
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String userName = "root";
			String password = "Matrix242944";
			String url = "jdbc:MySQL://localhost:3306/TEST";
			conn = DriverManager.getConnection(url, userName, password);

			System.out.println("Connection successful");
			
			String query = "SELECT employee_name, dept_name "
					+ "FROM employees "
					+ "JOIN departments "
					+ "WHERE (employees.department_id=departments.department_id);";
			// make the query using the provided arg
			try (Statement statem = conn.createStatement();
				ResultSet results = statem.executeQuery(query);){
				while (results.next())
				System.out.println("employee name: " + results.getString("employee_name") + ", from department: " + results.getString("dept_name"));
				
			}
			catch (SQLException e) {
				System.out.println("A sql error has occured");
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("a connection error has occurred");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					System.out.println("Terminating connection");
					conn.close();
					System.out.println("Connection terminated");
				} catch (Exception e) {
					System.out.println("Termination error");
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void SqlUpdate(String query) {
		System.out.println("Begin sql update...");
		Connection conn = null;
		try {
			System.out.println("Forming connection...");
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String userName = "root";
			String password = "Matrix242944";
			String url = "jdbc:MySQL://localhost:3306/TEST";
			conn = DriverManager.getConnection(url, userName, password);

			System.out.println("Connection successful");

			// make the query using the provided arg
			try (Statement statem = conn.createStatement()){
				statem.executeUpdate(query);
				System.out.println("sql update successful");
			}
			catch (SQLException e) {
				System.out.println("A sql error has occured");
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("a connection error has occurred");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					System.out.println("Terminating connection");
					conn.close();
					System.out.println("Connection terminated");
				} catch (Exception e) {
					System.out.println("Termination error");
					e.printStackTrace();
				}
			}
		}
	}
}
