package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "123456");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Driver JDBC MySQL não encontrado.", e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
