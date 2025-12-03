package taller4;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI extends JFrame{
	JFrame pantalla;
	
	JButton botonAdmin;
	JButton botonCoordinador;
	JButton botonEstudiante;
	
	JLabel textoAmdmin;
	JLabel textoCoordinador;
	JLabel textoEstudiante;
	
	public GUI() {
		pantalla = new JFrame();
		
		botonAdmin = new JButton();
		botonCoordinador = new JButton();
		botonEstudiante = new JButton();
		
		pantalla.setVisible(true);
		pantalla.setBounds(400,400,400,400);
		pantalla.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pantalla.setTitle("ACADEMI CORE");
		pantalla.setLayout(null);
		
		botonAdmin.setBounds(1,50,200,30);
		botonAdmin.setText("MENÚ ADMINISTRADOR");
		
		botonCoordinador.setBounds(2,100,200,30);
		botonCoordinador.setText("MENÚ COORDINADOR");
		
		botonEstudiante.setBounds(2,150,200,30);
		botonEstudiante.setText("MENÚ ESTUDIANTE");
		
		pantalla.add(botonAdmin);
		pantalla.add(botonCoordinador);
		pantalla.add(botonEstudiante);

	
		
	}
	
	

}
