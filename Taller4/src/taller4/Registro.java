package taller4;

public class Registro {
	private String rut;
	private String idCertificado;
	private String fecha;
	private String estado;
	private int pogreso;
	public Registro(String rut, String idCertificado, String fecha, String estado, int pogreso) {
		this.rut = rut;
		this.idCertificado = idCertificado;
		this.fecha = fecha;
		this.estado = estado;
		this.pogreso = pogreso;
	}
	public String getRut() {
		return rut;
	}
	public String getIdCertificado() {
		return idCertificado;
	}
	public String getFecha() {
		return fecha;
	}
	public String getEstado() {
		return estado;
	}
	public int getPogreso() {
		return pogreso;
	}
	
	

}
