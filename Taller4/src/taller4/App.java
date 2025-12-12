//DiegoGuerra_JoaquinBerenguela_Taller4POO 
//Joaquin Berenguela Caimanque, 21.708.988-3



package taller4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		Sistema sistema = SistemaIMPL.getInstance();

		abrirAsignaturasCertificaciones(sistema);
		abrircertificaciones(sistema);
		abrirCursos(sistema);
		abrirEstudiantes(sistema);
		abrirNotas(sistema);
		abrirRegistros(sistema);
		abrirUsuarios(sistema);
		 
		GUI gui = new GUI(sistema);
		
//		sistema.mostrar();


	}
	public static void abrirAsignaturasCertificaciones(Sistema sistema) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("asignaturas_certificaciones.txt"));
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			String id = partes[0];
			String nrc = partes[1];
			sistema.rellenarlistaAsignaturaCertificacion(id, nrc);
		}
		
	}
	public static void abrircertificaciones(Sistema sistema) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("certificaciones.txt"));
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			String id = partes[0];
			String nombre = partes[1];
			String descripcion = partes[2];
			int requisitos = Integer.valueOf(partes[3]);
			int validez = Integer.valueOf(partes[4]);
			sistema.rellenarlistaCertificacion(id, nombre, descripcion, requisitos, validez);
		}
		
	}

	public static void abrirCursos(Sistema sistema) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("cursosS.txt"));
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			String nrc = partes[0];
			String nombreCurso = partes[1];
			int semestre = Integer.valueOf(partes[2]);
			int creditos = Integer.valueOf(partes[3]);
			String area = partes[4];
			String nrcPrerequisito = "";
			if(partes.length == 6) {
				nrcPrerequisito = partes[5];
				
			}
			sistema.rellenarlistacursos(nrc, nombreCurso, semestre, creditos, area, nrcPrerequisito);
			
		}
		
	}
	public static void abrirEstudiantes(Sistema sistema) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("estudiantes.txt"));
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			String rut = partes[0];
			String nombreEstudiante = partes[1];
			String carreraEstudiante = partes[2];
			int semestre = Integer.valueOf(partes[3]);
			String correo = partes[4];
			String contraseña = partes[5];
			sistema.rellenarlistaEstudiante(rut, nombreEstudiante, carreraEstudiante, semestre, correo, contraseña);
		}
		
	}
	public static void abrirNotas(Sistema sistema) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("notasS.txt"));
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			String rut = partes[0];
			String codigoAisgnatura = partes[1];
			double calificacion = Double.valueOf(partes[2]);
			String estado = partes[3];
			String semestre = partes[4];
			sistema.rellenarlistaNota(rut, codigoAisgnatura, calificacion, estado, semestre);
		}
		
	}
	public static void abrirRegistros(Sistema sistema) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("registros.txt"));
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			String rut = partes[0];
			String idCertificacion = partes[1];
			String fecha = partes[2];
			String estado = partes[3];
			int progreso = Integer.valueOf(partes[4]);
			sistema.rellenarlistaRegristro(rut, idCertificacion, fecha, estado, progreso);
		}
		
	}
	public static void abrirUsuarios(Sistema sistema) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("usuariosS.txt"));
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			String nombreUsuario = partes[0];
			String contraseña = partes[1];
			String rol = partes[2];
			String infoAdicional = "";
			
			
			if(partes.length == 4) {
				infoAdicional = partes[3];
			
				
			}
			sistema.rellenarlistaUsuario(nombreUsuario, contraseña, rol, infoAdicional);
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}

