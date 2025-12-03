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
		}
		
	}
	public static void abrircertificaciones() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("certificaciones.txt"));
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
		}
		
	}
	public static void abrircursos() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("cursos.txt"));
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
		}
		
	}
	public static void abrirCursos() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("cursosS.txt"));
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
		}
		
	}
	public static void arbriEstudiantes() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("estudiantes.txt"));
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
		}
		
	}
	public static void abrirNotas() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("notasS.txt"));
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
		}
		
	}
	public static void arbrirRegistros() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("registros.txt"));
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
		}
		
	}
	public static void abrirUsuarios() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("usuariosS.txt"));
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
