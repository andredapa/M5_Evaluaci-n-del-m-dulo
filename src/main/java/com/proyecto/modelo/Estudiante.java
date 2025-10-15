package com.proyecto.modelo;

public class Estudiante {
	
	 private int id;
	 private String nombreCompleto;
	 private String email;
	 private String carrera;
	 
	 public Estudiante() {
	 }

	    
	  public Estudiante( String nombreCompleto, String email, String carrera) {
	      this.nombreCompleto = nombreCompleto;
	      this.email = email;
	      this.carrera = carrera;
	  }

	    
	 public Estudiante(int id, String nombreCompleto, String email, String carrera) {
	      this.id = id;
	      this.nombreCompleto = nombreCompleto;
	      this.email = email;
	      this.carrera = carrera;
	 }

	 public int getId() {
		 return id;
	 }
	 public void setId(int id) {
		 this.id = id;
	 }
	 public String getNombreCompleto() {
		 return nombreCompleto;
	 }
	 public void setNombreCompleto(String nombreCompleto) {
		 this.nombreCompleto = nombreCompleto;
	 }
	 public String getEmail() {
		 return email;
	 }
	 public void setEmail(String email) {
		 this.email = email;
	 }
	 public String getCarrera() {
		 return carrera;
	 }
	 public void setCarrera(String carrera) {
		 this.carrera = carrera;
	 }

}
