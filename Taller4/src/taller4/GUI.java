package taller4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI extends JFrame{
	JFrame pantalla; // se usara para los metodos, se puede intepretar como si fuera un "private"
	
	JButton botonAdmin;  // botones principales del menu
	JButton botonCoordinador;
	JButton botonEstudiante;
	
	JButton gestionUsuarios; //botones que contendran los botones principales del menu, al hacer click en algun boton principal se accedera a alguno de estos 
	JButton gestionCertificacion;
	JButton panelMetricasYanalisis;
	JButton gestionEstudiantes;
	JButton perfilEstudiante;
	JButton mallaCurricular;
	JButton inscripcionCertificaciones;
	JButton seguimientoProceso;
	
	public GUI() { // creacion de la gui
		pantalla = new JFrame();
		
		botonAdmin = new JButton();
		botonCoordinador = new JButton();
		botonEstudiante = new JButton();
		
		pantalla.setVisible(true);
		pantalla.setBounds(400,400,400,400);
		pantalla.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pantalla.setTitle("ACADEMI CORE");
		pantalla.setLayout(null);
		
		botonAdmin.setBounds(1,50,200,30);    // creacion de botones principales
		botonAdmin.setText("MENÚ ADMINISTRADOR");
		
		botonCoordinador.setBounds(2,100,200,30);
		botonCoordinador.setText("MENÚ COORDINADOR");
		
		botonEstudiante.setBounds(2,150,200,30);
		botonEstudiante.setText("MENÚ ESTUDIANTE");
		
		pantalla.add(botonAdmin);
		pantalla.add(botonCoordinador);
		pantalla.add(botonEstudiante);
		
		mostrarGestionUsuario(botonAdmin);  // se despliega la info dentro del menu admin, en ella solo esta disponibe el boton gestion de usuarios

	
		
	}
	private void limpiarPantallaTOTAL() { // se usa cuando se usa el volver, limpia toda la pantalla y la deja como al principio
		pantalla.getContentPane().removeAll();
		pantalla.repaint();
		pantalla.revalidate();
		
		
		
		pantalla.add(botonAdmin);
		pantalla.add(botonCoordinador);  // al limpiar la pantalla se "aregaran" los botones principales del menu"
		pantalla.add(botonEstudiante);
		
		pantalla.repaint();
		
	}
	private void mostrarGestionUsuario(JButton boton) { // muestra la opcion de gestion usuario del menu admin
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { 
				limpiarPantalla();
				gestionUsuarios = new JButton();
				gestionUsuarios.setBounds(1,100,200,30);
				gestionUsuarios.setText("Gestión de Usuarios"); // se crea un boton nuevo que contendra la info 
				pantalla.add(gestionUsuarios);
				
				gestionUsuarios.addActionListener(new ActionListener() { // al accionar el boton se accede
					
					@Override
					public void actionPerformed(ActionEvent e) {
						limpiarPantalla();  // aqui estan todas las opcciones dentro del boton "Gestion de usuarios"
						
						JButton crearCuentasEstudianteCoorinador =  new JButton();
						crearCuentasEstudianteCoorinador.setText("Crear cuentas de estudiante o coordinador");
						JButton modificarcuentasEstudianteCoordinador =  new JButton();
						modificarcuentasEstudianteCoordinador.setText("Modificar cuentas de estudiante o coordinador");
						JButton eliminarCuentasEstudianteCoordinador =  new JButton();
						eliminarCuentasEstudianteCoordinador.setText("Eliminar cuentas de estudiante o coordinador");
						JButton restablecerContraseñas =  new JButton();
						restablecerContraseñas.setText("Restablecer contraseñas");

						crearCuentasEstudianteCoorinador.setBounds(1,50,200,30);
						modificarcuentasEstudianteCoordinador.setBounds(1,100,200,30);
						eliminarCuentasEstudianteCoordinador.setBounds(1,200,200,30);
						restablecerContraseñas.setBounds(1,250,200,30);
						
					
						pantalla.add(crearCuentasEstudianteCoorinador);
						pantalla.add(modificarcuentasEstudianteCoordinador); // esos botones se agegran a la pantalla
						pantalla.add(eliminarCuentasEstudianteCoordinador);
						pantalla.add(restablecerContraseñas);
						volveR(); // si se presiona volver, se "retorna" al estado "base"
						

						
					}
				});
			}
		});
		
		
		
		
	}
	private void limpiarPantalla() { // limpia la pantalla para agregar los nuevos botones, sirve tambien para limpiar la pantalla y agregar nueva info
		pantalla.getContentPane().removeAll();
		pantalla.repaint();
		pantalla.revalidate();
	}
	private void volveR() {   // metodo para volver al apartado de menus
		JButton volver = new JButton("Volver");
        volver.setBounds(10, 300, 100, 30);
        
       volver.addActionListener(ev -> {
    	   limpiarPantallaTOTAL();
       });
       pantalla.add(volver);
		
	}
	
	
	

}
