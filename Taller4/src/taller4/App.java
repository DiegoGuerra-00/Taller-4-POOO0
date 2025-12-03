package taller4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void abrirAsignaturasCertificaciones() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("asignaturas_certificaciones.txt"));
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			String id = partes[0];
			String nrc = partes[1];
		}
		
	}
	public static void abrircertificaciones() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("certificaciones.txt"));
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			String id = partes[0];
			String nombre = partes[1];
			String descripcion = partes[2];
			int requisitos = Integer.valueOf(partes[3]);
			int validez = Integer.valueOf(partes[4]);
			
		}
		
	}

	public static void abrirCursos() throws FileNotFoundException {
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
			
			
		}
		
	}
	public static void arbriEstudiantes() throws FileNotFoundException {
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
		}
		
	}
	public static void abrirNotas() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("notasS.txt"));
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			String rut = partes[0];
			String codigoAisgnatura = partes[1];
			double calificacion = Double.valueOf(partes[2]);
			String estado = partes[3];
			String semestre = partes[4];
		}
		
	}
	public static void arbrirRegistros() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("registros.txt"));
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			String rut = partes[0];
			String idCertificacion = partes[1];
			String fecha = partes[2];
			String estado = partes[3];
			int progreso = Integer.valueOf(partes[4]);
		}
		
	}
	public static void abrirUsuarios() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("usuariosS.txt"));
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			String nombreUsuario = partes[0];
			String contraseña = partes[1];
			String rol = partes[2];
			String infoAdicional = "";
			
			
			if(partes.length == 4) {
				infoAdicional = partes[4];
			
				
			}
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
