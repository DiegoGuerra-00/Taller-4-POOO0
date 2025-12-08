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
			if(contraseñas.equalsIgnoreCase(contraseña)) {//si no contiene una contraseña
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
			if(usuario.getContraseña().equalsIgnoreCase(contraseña)) {
				
				if(usuario.getRol().equalsIgnoreCase("Coordinador")) {
					usuarioTIpo = "Coordinador";
				}else {
					usuarioTIpo = "Admin";

				}
			}
			
		}//---
		for(Estudiante estudiante : listaEstudiantes) {
			if(estudiante.getContraseña().equalsIgnoreCase(contraseña)) {
				usuarioTIpo = "Estudiante";
			}
		}//----
		
		
			

		
		 
		
		return usuarioTIpo;
	}

}


