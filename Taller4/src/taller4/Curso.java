package taller4;

public class Curso {
	private String nrc;
	private String nombreCurso;
	private int semestre;
	private int creditos;
	private 	String area;
	private String nrcPrerrequisito;
	public Curso(String nrc, String nombreCurso, int semestre, int creditos, String area, String nrcPrerrequisito) {
		this.nrc = nrc;
		this.nombreCurso = nombreCurso;
		this.semestre = semestre;
		this.creditos = creditos;
		this.area = area;
		this.nrcPrerrequisito = nrcPrerrequisito;
	}
	public String getNrc() {
		return nrc;
	}
	public String getNombreCurso() {
		return nombreCurso;
	}
	public int getSemestre() {
		return semestre;
	}
	public int getCreditos() {
		return creditos;
	}
	public String getArea() {
		return area;
	}
	public String getNrcPrerrequisito() {
		return nrcPrerrequisito;
	}
	
	
}
