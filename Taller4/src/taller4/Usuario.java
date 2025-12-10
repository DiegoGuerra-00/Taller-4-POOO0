package taller4;

public class Usuario {
	private String nombre;
	private String contraseña;
	private String rol;
	private String informacion;
	public Usuario(String nombre, String contraseña, String rol, String informacion) {
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.rol = rol;
		this.informacion = informacion;
	}
	public String getNombre() {
		return nombre;
	}
	public String getContraseña() {
		return contraseña;
	}
	public String getRol() {
		return rol;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}
	public String getInformacion() {
		return informacion;
	}
	

}
