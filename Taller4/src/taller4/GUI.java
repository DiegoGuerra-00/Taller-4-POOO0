package taller4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI extends JFrame{
	JFrame pantalla;
	
	JButton botonAdmin;
	JButton botonCoordinador;
	JButton botonEstudiante;
	
	JButton gestionUsuarios;
	JButton gestionCertificacion;
	JButton panelMetricasYanalisis;
	JButton gestionEstudiantes;
	JButton perfilEstudiante;
	JButton mallaCurricular;
	JButton inscripcionCertificaciones;
	JButton seguimientoProceso;
	
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
		
		mostrarGestionUsuario(botonAdmin);

	
		
	}
	private void limpiarPantallaTOTAL() {
		pantalla.getContentPane().removeAll();
		pantalla.repaint();
		pantalla.revalidate();
		
		
		
		pantalla.add(botonAdmin);
		pantalla.add(botonCoordinador);
		pantalla.add(botonEstudiante);
		
		pantalla.repaint();
		
	}
	private void mostrarGestionUsuario(JButton boton) {
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				limpiarPantalla();
				gestionUsuarios = new JButton();
				gestionUsuarios.setBounds(1,100,200,30);
				gestionUsuarios.setText("Gestión de Usuarios");
				pantalla.add(gestionUsuarios);
				
				gestionUsuarios.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						limpiarPantalla();
						
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
						pantalla.add(modificarcuentasEstudianteCoordinador);
						pantalla.add(eliminarCuentasEstudianteCoordinador);
						pantalla.add(restablecerContraseñas);
						volveR();
						

						
					}
				});
			}
		});
		
		
		
		
	}
	private void limpiarPantalla() {
		pantalla.getContentPane().removeAll();
		pantalla.repaint();
		pantalla.revalidate();
	}
	private void volveR() {
		JButton volver = new JButton("Volver");
        volver.setBounds(10, 300, 100, 30);
        
       volver.addActionListener(ev -> {
    	   limpiarPantallaTOTAL();
       });
       pantalla.add(volver);
		
	}
	
	
	

}
