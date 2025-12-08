package taller4;

public class Certificacion {
	private String id;
	private String nombre;
	private String descripcion;
	private int requisitos;
	private int validez;
	public Certificacion(String id, String nombre, String descripcion, int requisitos, int validez) {
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
	public int getRequisitos() {
		return requisitos;
	}
	public int getValidez() {
		return validez;
	}
	
	

}
