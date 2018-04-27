package com.htcursos.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println("Erro ao importar driver de conexão");
			e1.printStackTrace();
		}
		
		String urlConnection = "jdbc:mysql://localhost:3306/jweb1";
		String user = "root";
		String password = "alison";
		
		try {
			return DriverManager.getConnection(urlConnection, user, password);
		} catch (SQLException e) {
			System.out.println("Erro ao conectar com o banco de dados");
			e.printStackTrace();
			return null;
		}
	}

}
