package taller4;

import java.util.ArrayList;

public class SistemaIMPL implements Sistema{
	
	private ArrayList<String> listaContraseñas  = new ArrayList<>();
	private ArrayList<Curso> listaCursos = new ArrayList<>();
	private ArrayList<AsignaturaCertificacion> listaAsignaturCert = new ArrayList<>();
	private ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
	private ArrayList<Certificacion> listaCertificaciones = new ArrayList<>();
	private ArrayList<Nota> listaNotas = new ArrayList<>();
	private ArrayList<Registro> listaRegistros = new ArrayList<>();
	private ArrayList<Usuario> listaUsuarios = new ArrayList<>();



	private static SistemaIMPL instance; // para singleteon
	
	private SistemaIMPL() {} // para singleteon
	
	
	public void mostrar() {
		for(String contraseñas : listaContraseñas) {
			System.out.println(contraseñas);
		}
	}
	
	public static  SistemaIMPL getInstance() {  // creacion singleteon
		if(instance == null) {
			instance = new SistemaIMPL();
		}
		return instance;
	}

	
	@Override
	public String validarUsuario(String contraseña) {
		String mensaje = "Usuario no encontrado";
		
		for(String contraseñas : listaContraseñas) {
			if(contraseñas.equals(contraseña)) {//si no contiene una contraseña
			mensaje = "Encontrado";
			}
			
		}
		
		return mensaje;
	}

	@Override
	public void rellenarlistacursos(String nrc, String nombreCurso, int semestre, int creditos, String area,
			String nrcPrerrequisito) {
		Curso curso = new Curso(nrc, nombreCurso, semestre, creditos, area, nrcPrerrequisito);
		listaCursos.add(curso);
		
	}

	@Override
	public void rellenarlistaAsignaturaCertificacion(String id, String nrc) {
		AsignaturaCertificacion asignaturaCertificacion = new AsignaturaCertificacion(id, nrc);
		listaAsignaturCert.add(asignaturaCertificacion);
	}

	@Override
	public void rellenarlistaCertificacion(String id, String nombre, String descripcion, int requisitos,
			int validez) {
		Certificacion certificacion = new Certificacion(id, nombre, descripcion, requisitos, validez);
		listaCertificaciones.add(certificacion);
		
	}

	@Override
	public void rellenarlistaEstudiante(String rut, String nombre, String carrera, int semestre,
			String correoElectronico, String contraseña) {

		Estudiante estudiante =  new Estudiante(rut, nombre, carrera, semestre, correoElectronico, contraseña);
		listaEstudiantes.add(estudiante);
		String contraseñas = estudiante.getContraseña();
		listaContraseñas.add(contraseñas); //añade contraseñas de los estudiantes 
		
	}

	@Override
	public void rellenarlistaNota(String rutEstudiante, String nrcAsignatura, double calificaion, String estadoasing,
			String semestreAsing) {
		Nota nota = new Nota(rutEstudiante, nrcAsignatura, calificaion, estadoasing, semestreAsing);
		listaNotas.add(nota);
		
	}

	@Override
	public void rellenarlistaRegristro(String rut, String idCertificado, String fecha, String estado, int pogreso) {
		Registro  registro = new Registro(rut, idCertificado, fecha, estado, pogreso);
		listaRegistros.add(registro);
	}

	@Override
	public void rellenarlistaUsuario(String nombre, String contraseña, String rol, String informacion) {
		Usuario usuario = new Usuario(nombre, contraseña, rol, informacion);
		listaUsuarios.add(usuario);
		String contraseñaUsuarios =  usuario.getContraseña();
		listaContraseñas.add(contraseñaUsuarios);
		
	}


	@Override
	public String devolverTipoUsuario(String contraseña) {
		String usuarioTIpo = "";
	
			
		for(Usuario usuario : listaUsuarios) {
			if(usuario.getContraseña().equals(contraseña)) {
				
				if(usuario.getRol().equalsIgnoreCase("Coordinador")) {
					usuarioTIpo = "Coordinador";
				}else {
					usuarioTIpo = "Admin";

				}
			}
			
		}//---
		for(Estudiante estudiante : listaEstudiantes) {
			if(estudiante.getContraseña().equals(contraseña)) {
				usuarioTIpo = "Estudiante";
			}
		}//----
		
		
			

		
		 
		
		return usuarioTIpo;
	}

	
	
	//------------------------------------------------------------------------------------------------------------------
	
	//MÉTODOS PARA LOS REQUERIMIENTOS DE CADA MENÚ
	

	@Override
	public void crearCuentaDeEstudiante(String rut, String nombre, String carrera, int semestre, String correo,
			String contraseña) {
		Estudiante estudiante = new Estudiante(rut, nombre, carrera, semestre, correo, contraseña);
		listaEstudiantes.add(estudiante);
	}

	@Override
	public void crearCuentaDeCoordinador(String nombre, String contraseña, String rol, String infoAdicional) {
		Usuario usuario = new Usuario(nombre, contraseña, rol, infoAdicional);
		listaUsuarios.add(usuario);
	}


	@Override
	public String modificarCuentaDeEstudiante(String rut) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String modificarCuentaDeCoordinador(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	
	public void eliminarCuentaDeEstudiante(String rut) {
		Estudiante estudianteEliminado = null;
		for(Estudiante estudiante : listaEstudiantes) {
			if(estudiante.getRut().equalsIgnoreCase(rut)) {
				estudianteEliminado = estudiante;
				break;
			}
		}
		listaEstudiantes.remove(estudianteEliminado);

	}


	@Override
	public void eliminarCuentaDeCoordinador(String nombre) {
		Usuario usuarioEliminado = null;
		for(Usuario usuario : listaUsuarios) {
			if(usuario.getNombre().equalsIgnoreCase(nombre)) {
				usuarioEliminado = usuario;
			}
		}
		listaUsuarios.remove(usuarioEliminado);
		
	}


	@Override
	public String restablecerContraseña(String contraseñaNueva,String contraseñaVieja) {
		String mensaje = "Contraseña restablecida!";
		for(Usuario usuario : listaUsuarios) {
			if(usuario.getContraseña().equalsIgnoreCase(contraseñaVieja)) {
				usuario.setContraseña(contraseñaNueva);
			}
		}
		return mensaje;
	}


	@Override
	public void modificarLineaDeCertificación(Certificacion certif) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void generarCertificadosDeEstudiantesAprobados() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mostrarEstadísticasDeInscripcionesDeLinea() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void analisisDeAsignaturasCriticasDeLaLinea() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void consultarPerfilesCompletosDeEstudiantesEnLaLinea() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void revisarYValidarAvancesAcadémicos() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String visualizarInformaciónPersonalCompleta(String rut) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String mostrarMallaCurricularConEstadoDeAsignatura(String rut) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void calcularYMostrarPromedioGeneralYPorSemestre() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void visualizacionGraficaDeLaMallaCurricularPorSemestre() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void indicadoresVisualesDeEstadoDeAsignaturas() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void infoDetalladaDeCadaAsignatura() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void listarLineasDeCertificacionDisponibles() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mostrarRequisitosYDescripciónDeCadaLinea() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void procesoDeInscripciónConValidaciones() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void verificarPrerrequesitosAcadémicos() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void dashboardPersonalConProgresoEnCertifiacionesInscritas() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void aplicaciónVisitorParaAccionesSegúnTipoCertificación() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mostrarAsignaturasPendientesParaCompletarCertificaciones() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String validarEstudiante(String rut) { // verifica si existe el estudiante
		String mensaje = "Usuario no encontrado";
		
		for(Estudiante estudiante : listaEstudiantes) {
			String rutEstuddiante = estudiante.getRut();
			if(rutEstuddiante.equals(rut)) {//si no contiene una contraseña
			mensaje = "Encontrado";
			}
			
		}
		
		return mensaje;
	}


	@Override
	public String validarCoordinador(String nombre) {//verifica si existe el coordinador
		String mensaje = "Usuario no encontrado";
		
		for(Usuario usuario : listaUsuarios) {
			if(usuario.getRol().equals("Coordinador")) {
				if(usuario.getNombre().equals(nombre)) {//si no contiene una contraseña
					mensaje = "Encontrado";
					}
			}	
		}
		return mensaje;
		
	}


	@Override
	public void cambiarEstudiante(String rut, StrategyCambiodatos datos, String val) {
		for(Estudiante estudiante : listaEstudiantes) {
			if(estudiante.getRut().equalsIgnoreCase(rut)) {
				datos.cambiar(estudiante, val);
				return;
				}
			}
		}


	@Override
	public void cambiarCoordinador(String nombre, StrategyCambiarDatosCoord datos, String valor) {
		for(Usuario usuario : listaUsuarios) {
			if(usuario.getNombre().equalsIgnoreCase(nombre)) {
				datos.cambiardatosCord(usuario, valor);
				return;
			}
		}
		
		
	}


//	@Override
//	public String existeEstudianteoCoordinador(String valor) {
//		
//		for(Estudiante estudiante : listaEstudiantes) {
//			if(estudiante.getRut().equalsIgnoreCase(valor)) {
//				
//				return "Estudiante";
//			}
//		}
//		for(Usuario usuario : listaUsuarios ) {
//			if(usuario.getNombre().equalsIgnoreCase(valor)) {
//				return "Coordinador";
//			}
//		}
//		return "";
//	}
//
//
//	@Override
//	public boolean existeCoordinador(String nombre) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//
//	@Override
//	public String devolverEstudiante(String rut) {
//		String nombre = "";
//		for(Estudiante estudiante : listaEstudiantes) {
//			if(estudiante.getRut().equalsIgnoreCase(rut)) {
//				nombre = estudiante.getNombre();
//			}
//		}
//		
//		return nombre;
//	}
//
//
//	
//
//
//	@Override
//	public String contraseñaEstudiante(String rut) {
//		String contraseña = "";
//		for(Estudiante estudiante : listaEstudiantes) {
//			if(estudiante.getRut().equalsIgnoreCase(rut)) {
//				contraseña = estudiante.getContraseña();
//			}
//		}	
//		return contraseña;
//	}
//
//
	@Override
	public String contraseñaAdmin(String contra) {
		String contraseña = "";
		for(Usuario usuario : listaUsuarios) {
			if(usuario.getContraseña().equalsIgnoreCase(contra)) {
				contraseña = usuario.getContraseña();
			}
		}		
		return contraseña;
	}


	
		
}




