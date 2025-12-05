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
		mostrarMenuCoordinador(botonCoordinador); // se despliega el menu del coordinador
		mostrarMenuEstudiante(botonEstudiante);
		
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

						crearCuentasEstudianteCoorinador.setBounds(1,50,360,30);
						modificarcuentasEstudianteCoordinador.setBounds(1,100,360,30);
						eliminarCuentasEstudianteCoordinador.setBounds(1,200,360,30);
						restablecerContraseñas.setBounds(1,250,360,30);
						
					
						pantalla.add(crearCuentasEstudianteCoorinador);
						pantalla.add(modificarcuentasEstudianteCoordinador); // esos botones se agegran a la pantalla
						pantalla.add(eliminarCuentasEstudianteCoordinador);
						pantalla.add(restablecerContraseñas);
						volveInicio(); // si se presiona volver, se "retorna" al estado "base"
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
				gestionCertificacion = new JButton(); // boton certificacion
				gestionCertificacion.setBounds(1,100,200,30);
				gestionCertificacion.setText("Gestión de Certificaciones");
				
				panelMetricasYanalisis = new JButton(); // boton metricas y analisis
				panelMetricasYanalisis.setBounds(1,150,200,30);
				panelMetricasYanalisis.setText("Panel de Métricas y Análisis");
				
				gestionEstudiantes = new JButton(); //boton gestion estudiantes
				gestionEstudiantes.setBounds(1,200,200,30);
				gestionEstudiantes.setText("Gestión de Estudiantes");
				
				pantalla.add(gestionCertificacion);
				pantalla.add(panelMetricasYanalisis);
				pantalla.add(gestionEstudiantes);
				
				gestionCertificacion.addActionListener(new ActionListener() {// se accede a las opciones de gestion y certificacion
					
					@Override
					public void actionPerformed(ActionEvent e) {
						limpiarPantalla();// se limpia pantalla y se crean los botones de la opcion gestion certificacion
						JButton modificarLineaCertificacion = new JButton();
						modificarLineaCertificacion.setBounds(1,100,360,30);
						modificarLineaCertificacion.setText("Modificar línea de certificación");
						
						JButton generarCertificadoEstudiantesComp = new JButton();
						generarCertificadoEstudiantesComp.setBounds(1,150,360,30);
						generarCertificadoEstudiantesComp.setText("Generar certificados de estudiantes que hayan completado la línea de certificación");
						
						pantalla.add(modificarLineaCertificacion);
						pantalla.add(generarCertificadoEstudiantesComp);
						volveInicio(); // vuelve al principio
						volverMenuCoordinador(); // vuelve al menu coordinador
					}
				});//-----------------
				
				panelMetricasYanalisis.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						limpiarPantalla(); // se limpia la pantalla
						JButton mostrarEstadisticasInscripciones = new JButton();
						mostrarEstadisticasInscripciones.setBounds(1,100,360,30);
						mostrarEstadisticasInscripciones.setText("Mostrar estadísticas de inscripciones de línea de certificación");
						
						JButton analisisAsignaturasCriticas = new JButton();
						analisisAsignaturasCriticas.setBounds(1,150,360,30);
						analisisAsignaturasCriticas.setText("Análisis de asignaturas críticas en la línea de certificación");
						
						pantalla.add(mostrarEstadisticasInscripciones);
						pantalla.add(analisisAsignaturasCriticas);
						volveInicio();
						volverMenuCoordinador(); // vuelve al menu coordinador

					
					}
				});//--------------------
				
				gestionEstudiantes.addActionListener(new  ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						limpiarPantalla();
						
						JButton consultarPerfilesCompletos = new JButton();
						consultarPerfilesCompletos.setBounds(1,100,360,30);
						consultarPerfilesCompletos.setText("Consultar perfiles completos de estudiantes de la línea de certificación");
						
						JButton revisaryValidarAvances = new JButton();
						revisaryValidarAvances.setBounds(1,150,360,30);
						revisaryValidarAvances.setText("Revisar y validar avances académicos");
						
						pantalla.add(consultarPerfilesCompletos);
						pantalla.add(revisaryValidarAvances);
						volveInicio();
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
				limpiarPantalla();
				perfilEstudiante = new JButton();
				perfilEstudiante.setBounds(1,100,200,30);
				perfilEstudiante.setText("Perfil del Estudiante");
				
				mallaCurricular = new JButton();
				mallaCurricular.setBounds(1,150,200,30);
				mallaCurricular.setText("Malla Curricular Interactiva");
				
				inscripcionCertificaciones = new  JButton();
				inscripcionCertificaciones.setBounds(1,200,200,30);
				inscripcionCertificaciones.setText("Inscripción a Certificaciones");
				
				seguimientoProceso = new JButton();
				seguimientoProceso.setBounds(1,250,200,30);
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
						visualizarInformacionPersonalCompleta.setBounds(1,100,360,30);
						visualizarInformacionPersonalCompleta.setText("Visualizar información personal completa");
						
						JButton mostrarMallaCurricularasg = new JButton();
						mostrarMallaCurricularasg.setBounds(1,150,360,30);
						mostrarMallaCurricularasg.setText("Mostrar malla curricular con asignaturas aprobadas, reprobadas y pendientes");
						
						JButton calcularMostrarPromedioGeneral = new JButton();
						calcularMostrarPromedioGeneral.setBounds(1,200,360,30);
						calcularMostrarPromedioGeneral.setText("Calcular y mostrar promedio general y por semestre");
						
						pantalla.add(visualizarInformacionPersonalCompleta);
						pantalla.add(mostrarMallaCurricularasg);
						pantalla.add(calcularMostrarPromedioGeneral);
						volveInicio();
						volverMenuEstudiante(); // vuelve al menu estudiante

					}
				});//---
				
				mallaCurricular.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						limpiarPantalla();
						
						JButton visualizarGraficaSemestral = new  JButton();
						visualizarGraficaSemestral.setBounds(1,100,360,30);
						visualizarGraficaSemestral.setText("Visualización gráfica de la malla curricular por semestres");
						
						JButton indicadorVisualAsignaturas = new JButton();
						indicadorVisualAsignaturas.setBounds(1,150,360,30);
						indicadorVisualAsignaturas.setText("Indicadores visuales de estado de asignaturas (colores diferentes)");
						
						JButton infoDetalladaPorAsignatura = new JButton();
						infoDetalladaPorAsignatura.setBounds(1,200,360,30);
						infoDetalladaPorAsignatura.setText("Información detallada al hacer clic en cada asignatura");
						
						
						pantalla.add(visualizarGraficaSemestral);
						pantalla.add(indicadorVisualAsignaturas);
						pantalla.add(infoDetalladaPorAsignatura);

						volveInicio();
						volverMenuEstudiante(); // vuelve al menu estudiante

						
					}
				});//-----
				
				inscripcionCertificaciones.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						limpiarPantalla();
						
						JButton listarLineasCertificacion = new JButton();
						listarLineasCertificacion.setBounds(1,100,360,30);
						listarLineasCertificacion.setText("Listar líneas de certificación disponibles");
						
						JButton mostrarRequisitosDescp = new JButton();
						mostrarRequisitosDescp.setBounds(1,150,360,30);
						mostrarRequisitosDescp.setText("Mostrar requisitos y descripción de cada línea");
						
						JButton procesoInscrpValidadcion = new JButton();
						procesoInscrpValidadcion.setBounds(1,200,360,30);
						procesoInscrpValidadcion.setText("Proceso de inscripción con validaciones");
						
						JButton verificarPrerrequisito = new JButton();
						verificarPrerrequisito.setBounds(1,250,360,30);
						verificarPrerrequisito.setText("Verificar prerrequisitos académicos");
						
						
						pantalla.add(listarLineasCertificacion);
						pantalla.add(mostrarRequisitosDescp);
						pantalla.add(procesoInscrpValidadcion);
						pantalla.add(verificarPrerrequisito);
						volveInicio();
						volverMenuEstudiante(); // vuelve al menu estudiante
						
					}
				});//-----
				
				seguimientoProceso.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						limpiarPantalla();
						
						JButton dashboardPersonal = new JButton();
						dashboardPersonal.setBounds(1,100,360,30);
						dashboardPersonal.setText("Dashboard personal con progreso en certificaciones inscritas");
						
						JButton aplicarVisitor = new JButton();
						aplicarVisitor.setBounds(1,150,360,30);
						aplicarVisitor.setText("Aplicar Visitor para diferentes acciones según tipo de certificación");
						
						JButton mostrarAsignaturasPendientes = new JButton();
						mostrarAsignaturasPendientes.setBounds(1,200,360,30);
						mostrarAsignaturasPendientes.setText("Mostrar asignaturas pendientes para completar certificaciones");
						
						
						pantalla.add(dashboardPersonal);
						pantalla.add(aplicarVisitor);
						pantalla.add(mostrarAsignaturasPendientes);
						volveInicio();
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
	
	
	
	private void volveInicio() {   // metodo para volver al apartado de menus
		JButton volver = new JButton("Volver al incio");
        volver.setBounds(10, 330, 250, 30);
        
       volver.addActionListener(ev -> {
    	   limpiarPantallaTOTAL();
       });
       pantalla.add(volver);
		
	}
	
	private void limpiarMenuAdmin() { //limpia el menu admin
		pantalla.getContentPane().removeAll();
		pantalla.repaint();
		pantalla.revalidate();
		
		pantalla.add(gestionUsuarios);
		pantalla.repaint();
		
		
	}
	private void volverMENUADMIN() { //vuelve a las opciones del menu admin
		JButton volver = new JButton("Volver");
		volver.setBounds(20,300,250,20);
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
		
		pantalla.repaint();
	
	}
	private void volverMenuCoordinador() { //vuelve a las opciones del menu coordinador
		JButton volver = new JButton("Volver");
		volver.setBounds(20,300,250,20);
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

		pantalla.repaint();
		
	}
	private void volverMenuEstudiante() { //vuelve a las opciones del menu coordinador
		JButton volver = new JButton("Volver");
		volver.setBounds(20,300,250,20);
		volver.addActionListener(ev ->{
			limpiarMenuEstudiante();	
		});
		pantalla.add(volver);
		
	}
	
	
	

}
