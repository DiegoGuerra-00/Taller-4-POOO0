package taller4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GUI extends JFrame{
	private Sistema sistema;
	static JFrame pantalla; // se usara para los metodos, se puede intepretar como si fuera un "private"
	
	

	
	JButton gestionUsuarios; //botones que contendran los botones principales del menu, al hacer click en algun boton principal se accedera a alguno de estos 
	JButton gestionCertificacion;
	JButton panelMetricasYanalisis;
	JButton gestionEstudiantes;
	JButton perfilEstudiante;
	JButton mallaCurricular;
	JButton inscripcionCertificaciones;
	JButton seguimientoProceso;
	
	JLabel tituloAdmin;
	JLabel tituloCoordinador;
	JLabel tituloEstudiante;

	
	public GUI(Sistema sistema ) { // creacion de la gui
		pantalla = new JFrame();
		
	
		pantalla.setBounds(100,200,350,200);
		pantalla.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pantalla.setTitle("ACADEMI CORE");
		pantalla.setLayout(null);
		
		JLabel textoContraseña = new JLabel("Contraseña:");
		textoContraseña.setBounds(10,60,100,30);
		pantalla.add(textoContraseña);
		
		JTextField contraseña = new JTextField();
		contraseña.setBounds(120,60,150,30);
		pantalla.add(contraseña);
		
		JButton sesion = new JButton("Iniciar sesión");
		sesion.setBounds(100,110,120,30);
		pantalla.add(sesion);
		
		
		sesion.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String contra = contraseña.getText();
				String resultado= sistema.validarUsuario(contra);
				
				if(resultado.equalsIgnoreCase("Usuario no encontrado")) {
					JOptionPane.showMessageDialog(pantalla,resultado); 

				}else {
					String usuatio = sistema.devolverTipoUsuario(contra);
					switch (usuatio) {
					case "Coordinador":
						mostrarMenuCoordinador(sesion);
						break;

					case "Admin":
						mostrarGestionUsuario(sesion);
						break;
					case"Estudiante":
						mostrarMenuEstudiante(sesion);
						break;
					}
					
					
				}//--
				
			}
		});
		pantalla.setVisible(true);

		



//		
//		mostrarGestionUsuario(botonAdmin);  // se despliega la info dentro del menu admin, en ella solo esta disponibe el boton gestion de usuarios
//		mostrarMenuCoordinador(botonCoordinador); // se despliega el menu del coordinador
//		mostrarMenuEstudiante(botonEstudiante);
		
	}

	
	private void limpiarPantallaTOTAL() { // se usa cuando se usa el volver, limpia toda la pantalla y la deja como al principio
		pantalla.getContentPane().removeAll();
		pantalla.repaint();
		pantalla.revalidate();
		
		
		
	
		pantalla.repaint();
		
	}
	private void mostrarGestionUsuario(JButton boton) { // muestra la opcion de gestion usuario del menu admin
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { 
				limpiarPantalla();
				pantalla.setBounds(200,200,600,600);
				
				
				tituloAdmin = new JLabel("MENU ADMIN");
				tituloAdmin.setBounds(10,-60,200,200);
				pantalla.add(tituloAdmin);
				
				gestionUsuarios = new JButton();
				gestionUsuarios.setBounds(10,100,200,50);
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

						crearCuentasEstudianteCoorinador.setBounds(10,30,360,50);
						modificarcuentasEstudianteCoordinador.setBounds(10,100,360,50);
						eliminarCuentasEstudianteCoordinador.setBounds(10,170,360,50);
						restablecerContraseñas.setBounds(10,240,360,50);
						
					
						pantalla.add(crearCuentasEstudianteCoorinador);
						pantalla.add(modificarcuentasEstudianteCoordinador); // esos botones se agegran a la pantalla
						pantalla.add(eliminarCuentasEstudianteCoordinador);
						pantalla.add(restablecerContraseñas);
						volverMENUADMIN();

						
					}
				});
			}
		});
		
		
		
		
	}
	
	private void mostrarMenuCoordinador(JButton boton) {
		boton.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {

				limpiarPantalla();
				pantalla.setBounds(200,200,600,600);


				tituloCoordinador = new JLabel("MENU COORDINADOR");
				tituloCoordinador.setBounds(10,-60,200,200);
				pantalla.add(tituloCoordinador);
				
				gestionCertificacion = new JButton(); // boton certificacion
				gestionCertificacion.setBounds(10,50,200,50);
				gestionCertificacion.setText("Gestión de Certificaciones");
				
				panelMetricasYanalisis = new JButton(); // boton metricas y analisis
				panelMetricasYanalisis.setBounds(10,146,200,50);
				panelMetricasYanalisis.setText("Panel de Métricas y Análisis");
				
				gestionEstudiantes = new JButton(); //boton gestion estudiantes
				gestionEstudiantes.setBounds(10,240,200,50);
				gestionEstudiantes.setText("Gestión de Estudiantes");
				
				pantalla.add(gestionCertificacion);
				pantalla.add(panelMetricasYanalisis);
				pantalla.add(gestionEstudiantes);
				gestionCertificacion.addActionListener(new ActionListener() {// se accede a las opciones de gestion y certificacion

					@Override
					public void actionPerformed(ActionEvent e) {
						limpiarPantalla();// se limpia pantalla y se crean los botones de la opcion gestion certificacion
						JButton modificarLineaCertificacion = new JButton();
						modificarLineaCertificacion.setBounds(10,100,360,50);
						modificarLineaCertificacion.setText("Modificar línea de certificación");
						
						JButton generarCertificadoEstudiantesComp = new JButton();
						generarCertificadoEstudiantesComp.setBounds(10,180,360,50);
						generarCertificadoEstudiantesComp.setText("Generar certificados de estudiantes que hayan completado la línea de certificación");
						
						pantalla.add(modificarLineaCertificacion);
						pantalla.add(generarCertificadoEstudiantesComp);
						volverMenuCoordinador(); // vuelve al menu coordinador
					}
				});//-----------------
				
				panelMetricasYanalisis.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						limpiarPantalla(); // se limpia la pantalla
						JButton mostrarEstadisticasInscripciones = new JButton();
						mostrarEstadisticasInscripciones.setBounds(10,100,360,50);
						mostrarEstadisticasInscripciones.setText("Mostrar estadísticas de inscripciones de línea de certificación");
						
						JButton analisisAsignaturasCriticas = new JButton();
						analisisAsignaturasCriticas.setBounds(10,200,360,50);
						analisisAsignaturasCriticas.setText("Análisis de asignaturas críticas en la línea de certificación");
						
						pantalla.add(mostrarEstadisticasInscripciones);
						pantalla.add(analisisAsignaturasCriticas);
						volverMenuCoordinador(); // vuelve al menu coordinador

					
					}
				});//--------------------
				
				gestionEstudiantes.addActionListener(new  ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						limpiarPantalla();
						
						JButton consultarPerfilesCompletos = new JButton();
						consultarPerfilesCompletos.setBounds(10,100,360,50);
						consultarPerfilesCompletos.setText("Consultar perfiles completos de estudiantes de la línea de certificación");
						
						JButton revisaryValidarAvances = new JButton();
						revisaryValidarAvances.setBounds(10,180,360,50);
						revisaryValidarAvances.setText("Revisar y validar avances académicos");
						
						pantalla.add(consultarPerfilesCompletos);
						pantalla.add(revisaryValidarAvances);
						volverMenuCoordinador(); // vuelve al menu coordinador

					}
				});//--------------------
				
				
				
			}
		});
		
		
	}// fin metodo 
	
	private void mostrarMenuEstudiante(JButton boton) {
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pantalla.setBounds(200,200,600,600);

				limpiarPantalla();
				tituloEstudiante = new JLabel("MENU ESTUDIANTE");
				tituloEstudiante.setBounds(10,-60,200,200);
				pantalla.add(tituloEstudiante);
				
				perfilEstudiante = new JButton();
				perfilEstudiante.setBounds(10,50,200,50);
				perfilEstudiante.setText("Perfil del Estudiante");
				
				mallaCurricular = new JButton();
				mallaCurricular.setBounds(10,120,200,50);
				mallaCurricular.setText("Malla Curricular Interactiva");
				
				inscripcionCertificaciones = new  JButton();
				inscripcionCertificaciones.setBounds(10,196,200,50);
				inscripcionCertificaciones.setText("Inscripción a Certificaciones");
				
				seguimientoProceso = new JButton();
				seguimientoProceso.setBounds(10,269,200,50);
				seguimientoProceso.setText("Seguimiento de Progreso");
				
				
				pantalla.add(perfilEstudiante);
				pantalla.add(mallaCurricular);
				pantalla.add(inscripcionCertificaciones);
				pantalla.add(seguimientoProceso);
				
				perfilEstudiante.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						limpiarPantalla();
						
						JButton visualizarInformacionPersonalCompleta = new JButton();
						visualizarInformacionPersonalCompleta.setBounds(10,50,360,50);
						visualizarInformacionPersonalCompleta.setText("Visualizar información personal completa");
						
						JButton mostrarMallaCurricularasg = new JButton();
						mostrarMallaCurricularasg.setBounds(10,130,360,50);
						mostrarMallaCurricularasg.setText("Mostrar malla curricular con asignaturas aprobadas, reprobadas y pendientes");
						
						JButton calcularMostrarPromedioGeneral = new JButton();
						calcularMostrarPromedioGeneral.setBounds(10,210,360,50);
						calcularMostrarPromedioGeneral.setText("Calcular y mostrar promedio general y por semestre");
						
						pantalla.add(visualizarInformacionPersonalCompleta);
						pantalla.add(mostrarMallaCurricularasg);
						pantalla.add(calcularMostrarPromedioGeneral);
					
						volverMenuEstudiante(); // vuelve al menu estudiante

					}
				});//---
				
				mallaCurricular.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						limpiarPantalla();
						
						JButton visualizarGraficaSemestral = new  JButton();
						visualizarGraficaSemestral.setBounds(10,50,360,50);
						visualizarGraficaSemestral.setText("Visualización gráfica de la malla curricular por semestres");
						
						JButton indicadorVisualAsignaturas = new JButton();
						indicadorVisualAsignaturas.setBounds(10,130,360,50);
						indicadorVisualAsignaturas.setText("Indicadores visuales de estado de asignaturas (colores diferentes)");
						
						JButton infoDetalladaPorAsignatura = new JButton();
						infoDetalladaPorAsignatura.setBounds(10,210,360,50);
						infoDetalladaPorAsignatura.setText("Información detallada al hacer clic en cada asignatura");
						
						
						pantalla.add(visualizarGraficaSemestral);
						pantalla.add(indicadorVisualAsignaturas);
						pantalla.add(infoDetalladaPorAsignatura);

						volverMenuEstudiante(); // vuelve al menu estudiante

						
					}
				});//-----
				
				inscripcionCertificaciones.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						limpiarPantalla();
						
						JButton listarLineasCertificacion = new JButton();
						listarLineasCertificacion.setBounds(10,50,360,45);
						listarLineasCertificacion.setText("Listar líneas de certificación disponibles");
						
						JButton mostrarRequisitosDescp = new JButton();
						mostrarRequisitosDescp.setBounds(10,130,360,45);
						mostrarRequisitosDescp.setText("Mostrar requisitos y descripción de cada línea");
						
						JButton procesoInscrpValidadcion = new JButton();
						procesoInscrpValidadcion.setBounds(10,210,360,45);
						procesoInscrpValidadcion.setText("Proceso de inscripción con validaciones");
						
						JButton verificarPrerrequisito = new JButton();
						verificarPrerrequisito.setBounds(10,290,360,45);
						verificarPrerrequisito.setText("Verificar prerrequisitos académicos");
						
						
						pantalla.add(listarLineasCertificacion);
						pantalla.add(mostrarRequisitosDescp);
						pantalla.add(procesoInscrpValidadcion);
						pantalla.add(verificarPrerrequisito);
						volverMenuEstudiante(); // vuelve al menu estudiante
						
					}
				});//-----
				
				seguimientoProceso.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						limpiarPantalla();
						
						JButton dashboardPersonal = new JButton();
						dashboardPersonal.setBounds(10,50,360,50);
						dashboardPersonal.setText("Dashboard personal con progreso en certificaciones inscritas");
						
						JButton aplicarVisitor = new JButton();
						aplicarVisitor.setBounds(10,130,360,30);
						aplicarVisitor.setText("Aplicar Visitor para diferentes acciones según tipo de certificación");
						
						JButton mostrarAsignaturasPendientes = new JButton();
						mostrarAsignaturasPendientes.setBounds(10,210,360,50);
						mostrarAsignaturasPendientes.setText("Mostrar asignaturas pendientes para completar certificaciones");
						
						
						pantalla.add(dashboardPersonal);
						pantalla.add(aplicarVisitor);
						pantalla.add(mostrarAsignaturasPendientes);
						volverMenuEstudiante(); // vuelve al menu estudiante
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
	
	
	
//	private void volveInicio() {   // metodo para volver al apartado de menus
//		JButton volver = new JButton("Volver al incio");
//        volver.setBounds(20, 440, 250, 30);
//        
//       volver.addActionListener(ev -> {
//    	   limpiarPantallaTOTAL();
//       });
//       pantalla.add(volver);
//		
//	}
	
	private void limpiarMenuAdmin() { //limpia el menu admin
		pantalla.getContentPane().removeAll();
		pantalla.repaint();
		pantalla.revalidate();
		
		pantalla.add(gestionUsuarios);
		pantalla.add(tituloAdmin);
		pantalla.repaint();
		
		
	}
	private void volverMENUADMIN() { //vuelve a las opciones del menu admin
		JButton volver = new JButton("Volver");
		volver.setBounds(20,480,250,20);
		volver.addActionListener(ev ->{
			limpiarMenuAdmin();	
		});
		pantalla.add(volver);
		
	}
	private void limpiarMenuCoordinador() { //limpia el menu coordinador
		
		pantalla.getContentPane().removeAll();
		pantalla.repaint();
		pantalla.revalidate();
		
		pantalla.add(gestionCertificacion);
		pantalla.add(panelMetricasYanalisis);
		pantalla.add(gestionEstudiantes);
		pantalla.add(tituloCoordinador);

		
		pantalla.repaint();
	
	}
	private void volverMenuCoordinador() { //vuelve a las opciones del menu coordinador
		JButton volver = new JButton("Volver");
		volver.setBounds(20,480,250,20);
		volver.addActionListener(ev ->{
			limpiarMenuCoordinador();	
		});
		pantalla.add(volver);
		
	}
	private void limpiarMenuEstudiante() { //limpia el menu estudiante 
		pantalla.getContentPane().removeAll();
		pantalla.repaint();
		pantalla.revalidate();
		
		pantalla.add(perfilEstudiante);
		pantalla.add(mallaCurricular);
		pantalla.add(inscripcionCertificaciones);
		pantalla.add(seguimientoProceso);
		pantalla.add(tituloEstudiante);
		pantalla.repaint();
		
	}
	private void volverMenuEstudiante() { //vuelve a las opciones del menu coordinador
		JButton volver = new JButton("Volver");
		volver.setBounds(20,480,250,20);
		volver.addActionListener(ev ->{
			limpiarMenuEstudiante();	
		});
		pantalla.add(volver);
		
	}
	
	
	

}
