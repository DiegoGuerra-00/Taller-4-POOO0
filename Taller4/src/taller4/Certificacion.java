package taller4;

public class Certificacion {
	private String id;
	private String nombre;
	private String descripcion;
	private String requisitos;
	private String validez;
	public Certificacion(String id, String nombre, String descripcion, String requisitos, String validez) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.requisitos = requisitos;
		this.validez = validez;
	}
	public String getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public String getRequisitos() {
		return requisitos;
	}
	public String getValidez() {
		return validez;
	}
	
	

}
