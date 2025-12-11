package taller4;

public interface Sistema {
	
	
// VALIDACIONES DE USUARIO
	public String validarUsuario(String contraseña);
	public String validarEstudiante(String rut);
	public String validarCoordinador(String nombre);
	public void mostrar();
	
	public String devolverTipoUsuario(String contraseña);
	
	
// RELLENO DE LISTAS	
	public void rellenarlistacursos(String nrc, String nombreCurso, int semestre, int creditos, String area, String nrcPrerrequisito);
	public void rellenarlistaAsignaturaCertificacion(String id, String nrc);
	public void rellenarlistaCertificacion(String id, String nombre, String descripcion, int requisitos, int validez);
	public void rellenarlistaEstudiante(String rut, String nombre, String carrera, int semestre, String correoElectronico, String contraseña);
	public void rellenarlistaNota(String rutEstudiante, String nrcAsignatura, double calificaion, String estadoasing, String semestreAsing);
	public void rellenarlistaRegristro(String rut, String idCertificado, String fecha, String estado, int pogreso);
	public void rellenarlistaUsuario(String nombre, String contraseña, String rol, String informacion);
	
	
//	MENÚ ADMIN
	
	// Gestión de Usuarios
	void crearCuentaDeEstudiante(String rut,String nombre, String carrera, int semestre, String correo, String contraseña);
	void crearCuentaDeCoordinador(String nombre,String contraseña,String rol, String infoAdicional);
	String modificarCuentaDeEstudiante(String rut);
	String modificarCuentaDeCoordinador(String nombre);
	void eliminarCuentaDeEstudiante(String rut);
	void eliminarCuentaDeCoordinador(String nombre);
	String restablecerContraseña(String contraseñaNueva,String contraseñavieja);
//	String existeEstudianteoCoordinador(String valor);
//	boolean existeCoordinador(String nombre);
//	String devolverEstudiante(String rut);
//	String contraseñaEstudiante(String rut);
	String contraseñaAdmin(String contraseña);
	

// MENÚ COORDINADOR
	
	//Gestión de Certificaciones
	void modificarLineaDeCertificación(Certificacion certif);
	void generarCertificadosDeEstudiantesAprobados();
	
	//Panel de Métricas y Análisis
	void mostrarEstadísticasDeInscripcionesDeLinea();
	void analisisDeAsignaturasCriticasDeLaLinea();
	
	//Gestión de Estudiantes
	void consultarPerfilesCompletosDeEstudiantesEnLaLinea();
	void revisarYValidarAvancesAcadémicos();
	
	
//MENÚ ESTUDIANTE
	
	//Perfil del Estudiante
	String visualizarInformaciónPersonalCompleta(String rut);
	String mostrarMallaCurricularConEstadoDeAsignatura(String rut);
	void calcularYMostrarPromedioGeneralYPorSemestre();
	
	//Malla Curricular Interactiva
	void visualizacionGraficaDeLaMallaCurricularPorSemestre();
	void indicadoresVisualesDeEstadoDeAsignaturas();
	void infoDetalladaDeCadaAsignatura();
	
	//Inscripción a Certificaciones
	void listarLineasDeCertificacionDisponibles();
	void mostrarRequisitosYDescripciónDeCadaLinea();
	void procesoDeInscripciónConValidaciones();
	void verificarPrerrequesitosAcadémicos();
	
	//Seguimiento de Proceso
	void dashboardPersonalConProgresoEnCertifiacionesInscritas();
	void aplicaciónVisitorParaAccionesSegúnTipoCertificación();
	void mostrarAsignaturasPendientesParaCompletarCertificaciones();
	
// CAMBIAR DATOS
	void cambiarEstudiante(String rut, StrategyCambiodatos datos, String val);
	void cambiarCoordinador(String nombre, StrategyCambiarDatosCoord datos, String valor);

}
