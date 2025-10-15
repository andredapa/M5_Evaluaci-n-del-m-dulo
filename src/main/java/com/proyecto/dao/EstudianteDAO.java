package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.modelo.Estudiante;

public class EstudianteDAO {
	
	    public void create(Estudiante estudiante) throws SQLException {
	        String SQL = "INSERT INTO estudiantes (nombre, email, carrera) VALUES (?, ?, ?)";
	        try (Connection conn = ConexionBD.getConnection();
	             PreparedStatement ps = conn.prepareStatement(SQL)) {
	            
	            ps.setString(1, estudiante.getNombreCompleto());
	            ps.setString(2, estudiante.getEmail());
	            ps.setString(3, estudiante.getCarrera());
	            ps.executeUpdate();
	        }
	    }

	  
	    public List<Estudiante> readAll() throws SQLException {
	        List<Estudiante> lista = new ArrayList<>();
	        String SQL = "SELECT id, nombre, email, carrera FROM estudiantes";
	        try (Connection conn = ConexionBD.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(SQL)) {
	            
	            while (rs.next()) {
	                Estudiante est = new Estudiante();
	                est.setId(rs.getInt("id"));
	                est.setNombreCompleto(rs.getString("nombre"));
	                est.setEmail(rs.getString("email"));
	                est.setCarrera(rs.getString("carrera"));
	                lista.add(est);
	            }
	        }
	        return lista;
	    }

	 
	    public Estudiante readById(int id) throws SQLException {
	        Estudiante est = null;
	        String SQL = "SELECT id, nombre, email, carrera FROM estudiantes WHERE id = ?";
	        try (Connection conn = ConexionBD.getConnection();
	             PreparedStatement ps = conn.prepareStatement(SQL)) {
	            
	            ps.setInt(1, id);
	            try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    est = new Estudiante();
	                    est.setId(rs.getInt("id"));
	                    est.setNombreCompleto(rs.getString("nombre"));
	                    est.setEmail(rs.getString("email"));
	                    est.setCarrera(rs.getString("carrera"));
	                }
	            }
	        }
	        return est;
	    }

	    // ---------------------- UPDATE ----------------------
	    public void update(Estudiante estudiante) throws SQLException {
	        String SQL = "UPDATE estudiantes SET nombre = ?, email = ?, carrera = ? WHERE id = ?";
	        try (Connection conn = ConexionBD.getConnection();
	             PreparedStatement ps = conn.prepareStatement(SQL)) {
	            
	            ps.setString(1, estudiante.getNombreCompleto());
	            ps.setString(2, estudiante.getEmail());
	            ps.setString(3, estudiante.getCarrera());
	            ps.setInt(4, estudiante.getId());
	            ps.executeUpdate();
	        }
	    }

	
	    public void delete(int id) throws SQLException {
	        String SQL = "DELETE FROM estudiantes WHERE id = ?";
	        try (Connection conn = ConexionBD.getConnection();
	             PreparedStatement ps = conn.prepareStatement(SQL)) {
	            
	            ps.setInt(1, id);
	            ps.executeUpdate();
	        }
	    }
	}




