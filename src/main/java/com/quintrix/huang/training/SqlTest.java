package com.quintrix.huang.training;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
		} catch (Exception e) {
			System.out.println("a connection error has occurred");
			e.printStackTrace();
		}
		finally {
			if (conn != null) {
				try {
					System.out.println("Terminating connection");
					conn.close();
					System.out.println("Connection terminated");
				}catch(Exception e) {
					System.out.println("Termination error");
					e.printStackTrace();
				}
			}
		}
	}
}
