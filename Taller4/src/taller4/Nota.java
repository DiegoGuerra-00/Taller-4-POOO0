package taller4;

public class Nota {
	private String rutEstudiante;
	private String nrcAsignatura;
	private double calificaion;
	private String estadoasing;
	private String semestreAsing;
	public Nota(String rutEstudiante, String nrcAsignatura, double calificaion, String estadoasing,
			String semestreAsing) {
		this.rutEstudiante = rutEstudiante;
		this.nrcAsignatura = nrcAsignatura;
		this.calificaion = calificaion;
		this.estadoasing = estadoasing;
		this.semestreAsing = semestreAsing;
	}
	public String getRutEstudiante() {
		return rutEstudiante;
	}
	public String getNrcAsignatura() {
		return nrcAsignatura;
	}
	public double getCalificaion() {
		return calificaion;
	}
	public String getEstadoasing() {
		return estadoasing;
	}
	public String getSemestreAsing() {
		return semestreAsing;
	}
	
	
	
}
