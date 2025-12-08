package taller4;

public interface Sistema {
	
	
	public String validarUsuario(String contraseña);
	public void mostrar();
	
	public String devolverTipoUsuario(String contraseña);
	
	public void rellenarlistacursos(String nrc, String nombreCurso, int semestre, int creditos, String area, String nrcPrerrequisito);
	public void rellenarlistaAsignaturaCertificacion(String id, String nrc);
	public void rellenarlistaCertificacion(String id, String nombre, String descripcion, int requisitos, int validez);
	public void rellenarlistaEstudiante(String rut, String nombre, String carrera, int semestre, String correoElectronico,
			String contraseña);
	public void rellenarlistaNota(String rutEstudiante, String nrcAsignatura, double calificaion, String estadoasing,
			String semestreAsing);
	public void rellenarlistaRegristro(String rut, String idCertificado, String fecha, String estado, int pogreso);
	public void rellenarlistaUsuario(String nombre, String contraseña, String rol, String informacion);
	

}
