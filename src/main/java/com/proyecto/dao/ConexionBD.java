package com.proyecto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
	 private static final String URL = "jdbc:mysql://localhost:3306/gestion_estudiantes";
	    private static final String USER = "root"; 
	    private static final String PASSWORD = ""; 

	    public static Connection getConnection() throws SQLException {
	        try {
	            
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            throw new SQLException("No se encontró el driver de MySQL.");
	        }
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }

}
