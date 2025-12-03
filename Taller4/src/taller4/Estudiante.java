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
	

}
