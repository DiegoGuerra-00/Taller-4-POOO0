package taller4;

public class Estudiante {
	private String rut;
	private String nombre;
	private String carrera;
	private int semestre;
	private String correoElectronico;
	private String contraseña;
	public Estudiante(String rut, String nombre, String carrera, int semestre, String correoElectronico,
			String contraseña) {
		this.rut = rut;
		this.nombre = nombre;
		this.carrera = carrera;
		this.semestre = semestre;
		this.correoElectronico = correoElectronico;
		this.contraseña = contraseña;
	}
	public String getRut() {
		return rut;
	}
	public String getNombre() {
		return nombre;
	}
	public String getCarrera() {
		return carrera;
	}
	public int getSemestre() {
		return semestre;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	

}
