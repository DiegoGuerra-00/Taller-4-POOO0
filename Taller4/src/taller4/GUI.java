//DiegoGuerra_JoaquinBerenguela_Taller4POO 
//Joaquin Berenguela Caimanque, 21.708.988-3

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
	
	public GUI(Sistema sistema) { // creacion de la gui
		this.sistema = sistema;
		pantalla = new JFrame();
		
	
		pantalla.setBounds(600,200,350,200);
		pantalla.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pantalla.setTitle("ACADEMI CORE");
		pantalla.setLayout(null);
		
		JLabel textoContraseña = new JLabel("Contraseña:");
		textoContraseña.setBounds(10,60,100,30);
		pantalla.add(textoContraseña);
		
		JTextField contraseña = new JTextField();  //input para ingresar una contraseña
		contraseña.setBounds(120,60,150,30);
		pantalla.add(contraseña);
		
		JButton sesion = new JButton("Iniciar sesión");
		sesion.setBounds(100,110,120,30);
		pantalla.add(sesion);
		
		
		sesion.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String contra = contraseña.getText(); // se guarda la contraseña ingresada
				String resultado= sistema.validarUsuario(contra); // se llama el metodo del sistema, validando si es que la contraseña existe
				                                 // a su vez, esta variable sera la principal de todo 
				if(resultado.equalsIgnoreCase("Usuario no encontrado")) {
					JOptionPane.showMessageDialog(pantalla,resultado); // si la contraseña no existe se anuncia

				}else {
					String usuatio = sistema.devolverTipoUsuario(contra); //si la contraseña existe se verifica a que usuario existe y se accede al menu que le corresponde 
					switch (usuatio) {
					case "Coordinador":
						mostrarMenuCoordinador(sesion);
						break;

					case "Admin":
						mostrarGestionUsuario(sesion, contra);
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
	private void mostrarGestionUsuario(JButton boton,String contra) { // muestra la opcion de gestion usuario del menu admin
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { 
				limpiarPantalla();
				pantalla.setBounds(600,200,600,600);
				
				
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
						restablecerContraseñas.setText("Restablecer contraseña");

						crearCuentasEstudianteCoorinador.setBounds(10,30,360,50);
						modificarcuentasEstudianteCoordinador.setBounds(10,100,360,50);
						eliminarCuentasEstudianteCoordinador.setBounds(10,170,360,50);
						restablecerContraseñas.setBounds(10,240,360,50);
					
						pantalla.add(crearCuentasEstudianteCoorinador);
						pantalla.add(modificarcuentasEstudianteCoordinador); // esos botones se agegran a la pantalla
						pantalla.add(eliminarCuentasEstudianteCoordinador);
						pantalla.add(restablecerContraseñas);
						volverMENUADMIN();
						
						crearCuentasEstudianteCoorinador.addActionListener(new ActionListener() { // para la creacion de cuentas de estudiantes o coordinador
							
							@Override
							public void actionPerformed(ActionEvent e) {
								limpiarPantalla(); // boton que limpia la pantalla 
								
								pantalla.setBounds(600,200,350,260);
								JLabel seleccionar = new  JLabel("Seleccione la cuenta a crear");
								seleccionar.setBounds(90,20,200,30);
								
								
								JButton estudiante = new JButton("Estudiante");
								estudiante.setBounds(30,70,115,30);
								
								JButton coordinador = new JButton("Coordinador");
								coordinador.setBounds(200,70,110,30);
								
								//Boton que hace volver a las opciones anteriores 
								botonVolverGestionUsuarios(crearCuentasEstudianteCoorinador,modificarcuentasEstudianteCoordinador,eliminarCuentasEstudianteCoordinador,restablecerContraseñas);
								pantalla.add(seleccionar);
								pantalla.add(estudiante);
								pantalla.add(coordinador);
								
								estudiante.addActionListener(new ActionListener() {// boton si se crea un estudiante nuevo
								
									@Override
									public void actionPerformed(ActionEvent e) {
									limpiarPantalla(); 
									pantalla.setBounds(600,200,400,360);

									JLabel  rutestudiante = new JLabel("Rut:");
									rutestudiante.setBounds(20,10,200,30);
									
									JTextField rut = new JTextField(); // input de rut
									rut.setBounds(50,10,105,30);
									pantalla.add(rut);
									
									JLabel nombreEstudiante = new JLabel("Nombre completo:");
									nombreEstudiante.setBounds(20,50,200,30);
									
									JTextField nombre = new JTextField();//input para el nombre
									nombre.setBounds(130,50,120,30);
									pantalla.add(nombre);
						
									
									JLabel carreraEstudiante = new JLabel("Carerra:");
									carreraEstudiante.setBounds(20,90,200,30);
									
									JTextField carrera = new JTextField(); //input para la carrera
									carrera.setBounds(70,90,120,30);
									pantalla.add(carrera);

									JLabel semestreEstudiante = new JLabel("Semestre actual:");
									semestreEstudiante.setBounds(20,130,200,30);
									
									JTextField semestre = new JTextField(); //input para el semestre
									semestre.setBounds(120,130,120,30);
									pantalla.add(semestre);

									JLabel correoEstudiante = new JLabel("Correo:");
									correoEstudiante.setBounds(20,170,200,30);
									
									JTextField correo = new JTextField(); //input para el correo
									correo.setBounds(65,170,120,30);
									pantalla.add(correo);

									JLabel contraseñaEstudiante = new JLabel("Contraseña:");
									contraseñaEstudiante.setBounds(20,210,200,30);
									
									JTextField contraseña = new JTextField(); //input para la contraseña
									contraseña.setBounds(100,210,120,30);
									pantalla.add(contraseña);

									pantalla.add(rutestudiante);
									pantalla.add(nombreEstudiante);

									pantalla.add(carreraEstudiante);
									pantalla.add(semestreEstudiante);
									pantalla.add(correoEstudiante);
									pantalla.add(contraseñaEstudiante);
									
									JButton botonListo = new JButton("Listo");
									botonListo.setBounds(230,250,120,30);
									pantalla.add(botonListo);
									
									JButton volvera = new JButton("Volver");
									volvera.setBounds(40,250,120,30);
									pantalla.add(volvera);
									
									JOptionPane.showMessageDialog(pantalla, "Importante, solo datos del estudiante");

									botonListo.addActionListener(new ActionListener() {
				
										@Override
										public void actionPerformed(ActionEvent e) {
											//prueba de error para validar espacios de los inputs

											if(nombre.getText().isEmpty() || rut.getText().isEmpty()|| 
											carrera.getText().isEmpty() ||semestre.getText().isEmpty() 
											||correo.getText().isEmpty() ||
											contraseña.getText().isEmpty()  )  { 
												
												
												JOptionPane.showMessageDialog(pantalla,"Faltan datos o los datos son incorrectos");
												return;
											}
											int numeroSemestre_ = 0;
											try {
												
												numeroSemestre_ = Integer.valueOf(semestre.getText().trim());
												} catch (NumberFormatException e2) {
													JOptionPane.showMessageDialog(pantalla, "El semestre debe ser un número valido");
													return;
											}
												
												sistema.crearCuentaDeEstudiante(rut.getText(), nombre.getText(), carrera.getText(), numeroSemestre_, correo.getText(), contraseña.getText());
												
												
												JOptionPane.showMessageDialog(pantalla,"Usuario agregado");
												
												
												// se limpian los espacios para los inputs
												rut.setText(""); 
												nombre.setText("");
												carrera.setText("");
												semestre.setText("");
												contraseña.setText("");
												correo.setText("");
																				
										}
									});//fin boton listo
									volvera.addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e) {
											pantalla.setBounds(600,200,350,260);

											pantalla.getContentPane().removeAll();
											pantalla.repaint();
											pantalla.revalidate();

											pantalla.add(seleccionar);
											pantalla.add(estudiante);
											pantalla.add(coordinador);
											botonVolverGestionUsuarios(crearCuentasEstudianteCoorinador,modificarcuentasEstudianteCoordinador,eliminarCuentasEstudianteCoordinador,restablecerContraseñas);
											
										}
									});//---
									
									

									}
									
									
								});//fin boton estudiante
								coordinador.addActionListener(new ActionListener() {// boton creacion coordinador nuevo
									
									@Override
									public void actionPerformed(ActionEvent e) {
										limpiarPantalla(); 
										pantalla.setBounds(600,200,400,360);

										JLabel  nombreCoordinador = new JLabel("Nombre:");
										nombreCoordinador.setBounds(20,10,200,30);
										
										JTextField nombre = new JTextField(); // input de rut
										nombre.setBounds(70,10,105,30);
										pantalla.add(nombre);
										
										JLabel contraseñaCoord = new JLabel("Contraseña:");
										contraseñaCoord.setBounds(20,50,200,30);
										
										JTextField contraseña = new JTextField();//input para el nombre
										contraseña.setBounds(90,50,120,30);
										pantalla.add(contraseña);
							
										
										JLabel infoAdicional = new JLabel("Info adicional:");
										infoAdicional.setBounds(20,90,200,30);
										
										JTextField info = new JTextField(); //input para la carrera
										info.setBounds(100,90,120,30);
										pantalla.add(info);
										
										pantalla.add(nombreCoordinador);
										pantalla.add(contraseñaCoord);
										pantalla.add(infoAdicional);

										JButton botonListo = new JButton("Listo");
										botonListo.setBounds(230,250,120,30);
										pantalla.add(botonListo);
										
										JButton volvera = new JButton("Volver");
										volvera.setBounds(40,250,120,30);
										pantalla.add(volvera);

										JOptionPane.showMessageDialog(pantalla, "Importante, solo datos del Coordinador");

										botonListo.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												//prueba de error para validar espacios de los inputs
												if(nombre.getText().isEmpty() || contraseña.getText().isEmpty()|| 
														info.getText().isEmpty()) {
													
													
													JOptionPane.showMessageDialog(pantalla,"Faltan datos");
													return;		
												}else {
													sistema.crearCuentaDeCoordinador(nombre.getText(), contraseña.getText(), "Coordinador", info.getText());
													
													JOptionPane.showMessageDialog(pantalla,"Usuario agregado");
																										
													// se limpian los espacios para los inputs
													nombre.setText("");
													contraseña.setText("");
													info.setText("");
													
												}
											}
										});//fin boton listo
									volvera.addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e) {
											pantalla.setBounds(600,200,350,260);

											pantalla.getContentPane().removeAll();
											pantalla.repaint();
											pantalla.revalidate();

											pantalla.add(seleccionar);
											pantalla.add(estudiante);
											pantalla.add(coordinador);
											botonVolverGestionUsuarios(crearCuentasEstudianteCoorinador,modificarcuentasEstudianteCoordinador,eliminarCuentasEstudianteCoordinador,restablecerContraseñas);
											
										}
									});//fin boton volvera
									
									}
								});//fin boton coordinador
								
							}
						}); // fin accion boton crearCuentasEstudianteCoorinador
						modificarcuentasEstudianteCoordinador.addActionListener(new ActionListener() {//inicio boton modificar cuentas
							
							@Override
							public void actionPerformed(ActionEvent e) {
								limpiarPantalla(); // boton que limpia la pantalla 
								
								pantalla.setBounds(600,200,350,300);
								JLabel seleccionar = new  JLabel("Seleccione la cuenta a modificar");
								seleccionar.setBounds(90,20,200,30);
								
								
								JButton estudiante = new JButton("Estudiante");
								estudiante.setBounds(30,70,115,30);
								
								JButton coordinador = new JButton("Coordinador");
								coordinador.setBounds(200,70,110,30);
								
								//Boton que hace volver a las opciones anteriores 
								botonVolverGestionUsuarios(crearCuentasEstudianteCoorinador,modificarcuentasEstudianteCoordinador,eliminarCuentasEstudianteCoordinador,restablecerContraseñas);
								pantalla.add(seleccionar);
								pantalla.add(estudiante);
								pantalla.add(coordinador);
								
								estudiante.addActionListener(new ActionListener() {// se accede al cambio de cuenta en estudiantes
									
									@Override
									public void actionPerformed(ActionEvent e) {
										limpiarPantalla();
										JLabel rut = new JLabel("Ingrese rut del estudiante:");
										rut.setBounds(10,20,200,30);
										pantalla.add(rut);
										
										JTextField rutEstudiante = new JTextField();
										rutEstudiante.setBounds(170,20,100,30);
										pantalla.add(rutEstudiante);
										
										JButton continuar = new JButton("Continuar");
										continuar.setBounds(170,50,100,30);
										pantalla.add(continuar);
										
										
										
										//metodo que crea  un boton "volver", se necestian los demas botones para la creacion de otro boton "volver"
										botonVolverCambioEstudiante(seleccionar,estudiante,coordinador,crearCuentasEstudianteCoorinador,modificarcuentasEstudianteCoordinador,eliminarCuentasEstudianteCoordinador,restablecerContraseñas);
										continuar.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												
												String rut_ = rutEstudiante.getText();
												String resultado = sistema.validarEstudiante(rut_);
												if(resultado.equalsIgnoreCase("Usuario no encontrado")) {// validar que el usuario exista
													JOptionPane.showMessageDialog(pantalla, "Estudiante no encontrado");
												}else {
													limpiarPantalla();
													JLabel seleccionar = new JLabel("Seleccione el dato a cambiar");
													seleccionar.setBounds(90,10,200,30);
													pantalla.add(seleccionar);
													pantalla.setBounds(600,200,350,300);

													
													JButton botonrut = new JButton("Rut");
													JButton botonNombre  = new JButton("Nombre");
													JButton botoncarrera = new JButton("Carrera");
													JButton botonsemestre = new JButton("Semestre");
													JButton botoncorreo = new JButton("Correo");
													JButton botonContraseña = new JButton("Contraseña");
													
													//lado izquierdo
													botonrut.setBounds(30,60,100,30);
													botonNombre.setBounds(30,110,100,30);
													botoncarrera.setBounds(30,155,100,30);

													pantalla.add(botonrut);
													pantalla.add(botonNombre);
													pantalla.add(botoncarrera);
													
													//lado derecho
													botonsemestre.setBounds(200,60,100,30);
													botoncorreo.setBounds(200,110,100,30);
													botonContraseña.setBounds(200,155,100,30);
													
													pantalla.add(botonsemestre);
													pantalla.add(botoncorreo);
													pantalla.add(botonContraseña);
													
													//accion de botones texto, estrategia,rut original, Sistema, boton
													
													
													cambiarDatosEstudiantes(botonrut, new CambiarRut(), "Rut",rut_, botonrut, botonNombre, botoncarrera, botonsemestre, botoncorreo, botonContraseña,crearCuentasEstudianteCoorinador,
															modificarcuentasEstudianteCoordinador,eliminarCuentasEstudianteCoordinador,restablecerContraseñas,seleccionar,estudiante,coordinador);
													cambiarDatosEstudiantes(botonNombre, new CambiarNombre(), "Nombre",rut_, botonrut, botonNombre, botoncarrera, botonsemestre, botoncorreo, botonContraseña,crearCuentasEstudianteCoorinador,
															modificarcuentasEstudianteCoordinador,eliminarCuentasEstudianteCoordinador,restablecerContraseñas,seleccionar,estudiante,coordinador);
													cambiarDatosEstudiantes(botoncarrera, new CambiarCarrera(), "Carrera",rut_, botonrut, botonNombre, botoncarrera, botonsemestre, botoncorreo, botonContraseña,crearCuentasEstudianteCoorinador,
															modificarcuentasEstudianteCoordinador,eliminarCuentasEstudianteCoordinador,restablecerContraseñas,seleccionar,estudiante,coordinador);
													cambiarDatosEstudiantes(botonsemestre, new Cambiarsemestre(), "Semestre",rut_, botonrut, botonNombre, botoncarrera, botonsemestre, botoncorreo, botonContraseña,crearCuentasEstudianteCoorinador,
															modificarcuentasEstudianteCoordinador,eliminarCuentasEstudianteCoordinador,restablecerContraseñas,seleccionar,estudiante,coordinador);
													cambiarDatosEstudiantes(botoncorreo, new CambiarCorreo(), "Correo",rut_, botonrut, botonNombre, botoncarrera, botonsemestre, botoncorreo, botonContraseña,crearCuentasEstudianteCoorinador,
															modificarcuentasEstudianteCoordinador,eliminarCuentasEstudianteCoordinador,restablecerContraseñas,seleccionar,estudiante,coordinador);
													cambiarDatosEstudiantes(botonContraseña, new Cambiarcontraseña(), "Contraseña",rut_, botonrut, botonNombre, botoncarrera, botonsemestre, botoncorreo, botonContraseña,crearCuentasEstudianteCoorinador,
															modificarcuentasEstudianteCoordinador,eliminarCuentasEstudianteCoordinador,restablecerContraseñas,seleccionar,estudiante,coordinador);
											
													botonVolverCuentasModificar(crearCuentasEstudianteCoorinador,modificarcuentasEstudianteCoordinador,eliminarCuentasEstudianteCoordinador,restablecerContraseñas,seleccionar,estudiante,coordinador);

													

												}//fin del else
												

												
											}
										});//fin boton continuar
										
										
									}
								});//fin boton estudiante
								
								coordinador.addActionListener(new ActionListener() { // inicio boton modificar un coordinador
									
									@Override
									public void actionPerformed(ActionEvent e) {
										limpiarPantalla();
										JLabel rut = new JLabel("Ingrese nombre del Coordinador:");
										rut.setBounds(10,20,200,30);
										pantalla.add(rut);
										
										JTextField nombreCorrdinador = new JTextField();
										nombreCorrdinador.setBounds(205,20,100,30);
										pantalla.add(nombreCorrdinador);
										
										JButton continuar = new JButton("Continuar");
										continuar.setBounds(205,60,100,30);
										pantalla.add(continuar);				
										
										botonVolverCambioEstudiante(seleccionar,estudiante,coordinador,crearCuentasEstudianteCoorinador,modificarcuentasEstudianteCoordinador,eliminarCuentasEstudianteCoordinador,restablecerContraseñas);
										
										continuar.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												
												String nombre = nombreCorrdinador.getText();
												String resultado = sistema.validarCoordinador(nombre);
												if(resultado.equalsIgnoreCase("Usuario no encontrado")) {// validar que el usuario exista
													JOptionPane.showMessageDialog(pantalla, "Coordinador no encontrado");
												}else {
													limpiarPantalla();
													JLabel seleccionar = new JLabel("Seleccione el dato a cambiar");
													seleccionar.setBounds(90,10,200,30);
													pantalla.add(seleccionar);
													
													JButton nombreUsuario = new JButton("Nombre");
													JButton contraseñaUsuario = new JButton("Contraseña");
													JButton informacionAdd = new JButton("Informacion Adicional");
													
													
													nombreUsuario.setBounds(30,60,100,30);
													contraseñaUsuario.setBounds(200,60,100,30);
													informacionAdd.setBounds(70,110,200,30);

													pantalla.add(nombreUsuario);
													pantalla.add(contraseñaUsuario);
													pantalla.add(informacionAdd);
													botonVolverCuentasModificar(crearCuentasEstudianteCoorinador,modificarcuentasEstudianteCoordinador,eliminarCuentasEstudianteCoordinador,restablecerContraseñas,seleccionar,estudiante,coordinador);
													cambiarDatosCoord(nombreUsuario, new CambiarNombreCord(),"Nombre",nombre,nombreUsuario,contraseñaUsuario,informacionAdd,crearCuentasEstudianteCoorinador,modificarcuentasEstudianteCoordinador
															,eliminarCuentasEstudianteCoordinador,restablecerContraseñas,seleccionar,estudiante,coordinador);
													cambiarDatosCoord(contraseñaUsuario, new CambiarcontraseñaCord(),"Contraseña",nombre,nombreUsuario,contraseñaUsuario,informacionAdd,crearCuentasEstudianteCoorinador,modificarcuentasEstudianteCoordinador
															,eliminarCuentasEstudianteCoordinador,restablecerContraseñas,seleccionar,estudiante,coordinador);
													cambiarDatosCoord(informacionAdd, new CambiarInfoCord(),"Informacion",nombre,nombreUsuario,contraseñaUsuario,informacionAdd,crearCuentasEstudianteCoorinador,modificarcuentasEstudianteCoordinador
															,eliminarCuentasEstudianteCoordinador,restablecerContraseñas,seleccionar,estudiante,coordinador);
													
//												(JButton boton, StrategyCambiarDatosCoord estrategia, String titulo, String nombre,JButton botonnombre,
//														JButton botoncontra,JButton botoninfoAdicional,JButton b1,
//														JButton b2, JButton b3, JButton b4,JLabel seleccioando, JButton estudiante, JButton coordinador)			
//												
															
												}//fin else												
											}
										});
										
									}
								});// coordinador
																
							}
						});// fin boton modificar cuentas 
						eliminarCuentasEstudianteCoordinador.addActionListener(new ActionListener() {//inicio boton eliminar cuentas
							
							@Override
							
							public void actionPerformed(ActionEvent e) {
								
								limpiarPantalla(); // boton que limpia la pantalla 
								
								pantalla.setBounds(600,200,350,300);
								JLabel seleccionar = new  JLabel("Seleccione el tipo de cuenta a eliminar");
								seleccionar.setBounds(70,20,300,30);
								
								
								JButton estudiante = new JButton("Estudiante");
								estudiante.setBounds(30,70,115,30);
								
								JButton coordinador = new JButton("Coordinador");
								coordinador.setBounds(200,70,110,30);
								
								pantalla.add(estudiante);
								pantalla.add(coordinador);
								pantalla.add(seleccionar);
								botonVolverGestionUsuarios(crearCuentasEstudianteCoorinador,modificarcuentasEstudianteCoordinador,eliminarCuentasEstudianteCoordinador,restablecerContraseñas);

								estudiante.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										
										limpiarPantalla();
										JLabel rut = new JLabel("Ingrese rut del estudiante:");
										rut.setBounds(10,20,200,30);
										pantalla.add(rut);
										
										JTextField rutEstudiante = new JTextField();
										rutEstudiante.setBounds(170,20,100,30);
										pantalla.add(rutEstudiante);
										
										JButton eliminar = new JButton("Eliminar");
										eliminar.setBounds(170,50,100,30);
										pantalla.add(eliminar);
										botonVolverCambioEstudiante(seleccionar,estudiante,coordinador,crearCuentasEstudianteCoorinador,modificarcuentasEstudianteCoordinador,eliminarCuentasEstudianteCoordinador,restablecerContraseñas);

										eliminar.addActionListener(new ActionListener() {
	
											@Override
											public void actionPerformed(ActionEvent e) {
												String rut_ = rutEstudiante.getText();
												String resultado = sistema.validarEstudiante(rut_);
												if(resultado.equalsIgnoreCase("Usuario no encontrado")) {// validar que el usuario exista
													JOptionPane.showMessageDialog(pantalla, "Estudiante no encontrado");
													rutEstudiante.setText("");

												}else {
													JOptionPane.showMessageDialog(pantalla, "Cuenta eliminada");
													
													sistema.eliminarCuentaDeEstudiante(rut_); // estudiante eliminado del sistema
													rutEstudiante.setText("");
													botonVolverCuentasModificar(crearCuentasEstudianteCoorinador,modificarcuentasEstudianteCoordinador,eliminarCuentasEstudianteCoordinador,restablecerContraseñas,seleccionar,estudiante,coordinador);

												}
											}
										});
									}
								});//fin boton borrar estudiante
								coordinador.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										limpiarPantalla();

										JLabel nombre = new JLabel("Ingrese nombre del Coordinador:");
										nombre.setBounds(10,20,200,30);
										pantalla.add(nombre);
										
										JTextField nombreCorrdinador = new JTextField();
										nombreCorrdinador.setBounds(205,20,100,30);
										pantalla.add(nombreCorrdinador);
										
										JButton eliminar = new JButton("Eliminar");
										eliminar.setBounds(205,60,100,30);
										pantalla.add(eliminar);				
										botonVolverCambioEstudiante(seleccionar,estudiante,coordinador,crearCuentasEstudianteCoorinador,modificarcuentasEstudianteCoordinador,eliminarCuentasEstudianteCoordinador,restablecerContraseñas);

										eliminar.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												String nombre = nombreCorrdinador.getText();
												String resultado = sistema.validarCoordinador(nombre);
												if(resultado.equalsIgnoreCase("Usuario no encontrado")) {// validar que el usuario exista
													JOptionPane.showMessageDialog(pantalla, "Coordinador no encontrado");
												}else {
													JOptionPane.showMessageDialog(pantalla, "Cuenta eliminada");
													nombreCorrdinador.setText("");
													sistema.eliminarCuentaDeCoordinador(nombre);
													botonVolverCuentasModificar(crearCuentasEstudianteCoorinador,modificarcuentasEstudianteCoordinador,eliminarCuentasEstudianteCoordinador,restablecerContraseñas,seleccionar,estudiante,coordinador);
													nombreCorrdinador.setText("");
												}												
											}
										});
									}
								});// fin boton borrar coordinador
							}
						});//fin boton eliminar cuentas
						restablecerContraseñas.addActionListener(new ActionListener() {//inicio boton restablecer contraseñas
							
							@Override
							public void actionPerformed(ActionEvent e) {
								limpiarPantalla(); // boton que limpia la pantalla 
								
								pantalla.setBounds(600,200,400,300);
								JLabel seleccionar = new  JLabel("Su contraseña actual es "+sistema.contraseñaAdmin(contra));
								seleccionar.setBounds(20,20,800,40);
								
								
								JLabel nuevo = new JLabel("Ingresar nueva contraseña:");
								nuevo.setBounds(20,55,300,30);
								JTextField input = new JTextField();
								input.setBounds(190,55,150,30);
								
								pantalla.add(seleccionar);
								pantalla.add(nuevo);
								pantalla.add(input);
								
								botonVolverGestionUsuarios(crearCuentasEstudianteCoorinador,modificarcuentasEstudianteCoordinador,eliminarCuentasEstudianteCoordinador,restablecerContraseñas);
								JButton restablecer = new JButton("Restablecer");
								restablecer.setBounds(205,110,150,30);
								pantalla.add(restablecer);
								
								restablecer.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										String valor = input.getText();
										JOptionPane.showMessageDialog(pantalla, sistema.restablecerContraseña(valor, contra));
										JLabel seleccionar = new  JLabel("Su contraseña actual es "+sistema.contraseñaAdmin(valor));
										seleccionar.setBounds(20,20,800,40);
										pantalla.add(seleccionar);
											
										
									}
								});
								
								
							}
						});//fin boton restablecer contraseñas
						
					
						
						
						
						
						

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
				pantalla.setBounds(600,200,600,600);

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
				pantalla.setBounds(600,200,600,600);

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
					
					
				});//----------------------------------------------------------------------------------------------------------------------------------------
				
				
				
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
	
	//Boton creado para que se vuelva a las opciones que hay en el menu de administrador
	private void botonVolverGestionUsuarios(JButton crearCuentas,JButton modifcarCuentas, JButton EliminarCuentas, JButton restablecer) {
		JButton volverOpciones= new JButton("Volver");
		volverOpciones.setBounds(68,190,200,30);
		volverOpciones.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pantalla.getContentPane().removeAll();
				pantalla.repaint();
				pantalla.revalidate();
				
				pantalla.add(crearCuentas);
				pantalla.add(modifcarCuentas); // esos botones se agegran a la pantalla
				pantalla.add(EliminarCuentas);
				pantalla.add(restablecer);
				volverMENUADMIN();
				pantalla.repaint();
				pantalla.setBounds(600,200,600,600);

			}
		});
		pantalla.add(volverOpciones);

	}
	
	// metodo para cambiar datos de un estudiante, dependiendo del tipo de dato que se quiera cambiar
	private void cambiarDatosEstudiantes(JButton boton, StrategyCambiodatos estrategia, String titulo, String rut,JButton botonrut,
			JButton botonnombre,JButton botoncarrera,JButton botonsemestre,JButton botoncorreo,JButton botoncontraseña,JButton b1,
			JButton b2, JButton b3, JButton b4,JLabel seleccioando, JButton estudiante, JButton coordinador) {
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				limpiarPantalla();
				JLabel texto = new JLabel("Ingrese nuevo/a "+ titulo +":");
				texto.setBounds(10,10,200,30);
				pantalla.add(texto);
				
				JTextField rutNuevo = new JTextField();
				rutNuevo.setBounds(170,10,100,30);
				pantalla.add(rutNuevo);
				
				
//				sistema.cambiarEstudiante(rut, new CambiarRut(), resultado);
				
				JButton cambiar = new JButton("Cambiar");
				cambiar.setBounds(150,50,100,30);
				pantalla.add(cambiar);
				
				JButton volvera = new JButton("Volver");
				volvera.setBounds(40,130,120,30);
				pantalla.add(volvera);
				
				cambiar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String valor = rutNuevo.getText();

						if(valor.equals("")) {
							JOptionPane.showMessageDialog(pantalla, "Faltan datos");
						}else {
							sistema.cambiarEstudiante(rut, estrategia, valor);
							JOptionPane.showMessageDialog(pantalla, titulo+" se ha actualizado!");
							

						}
						
					}
				});
				volvera.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						pantalla.setBounds(600,200,350,300);

						pantalla.getContentPane().removeAll();
						pantalla.repaint();
						pantalla.revalidate();
						
						pantalla.add(botonrut);
						pantalla.add(botonnombre);
						pantalla.add(botoncarrera);
						
						
						pantalla.add(botonsemestre);
						pantalla.add(botoncorreo);
						pantalla.add(botoncontraseña);
						JLabel seleccionar = new  JLabel("Seleccione el dato a modificar");
						seleccionar.setBounds(90,20,200,30);
						pantalla.add(seleccionar);
						botonVolverCuentasModificar(b1,b2,b3,b4,seleccioando,estudiante,coordinador);

					}
				});//fin boton volvera
						
			
				
			}
		});
	}
	private void botonVolverCambioEstudiante(JLabel texto, JButton r, JButton c,JButton crearCuentas,
			JButton modificarcuentas,JButton eliminarCuentas,JButton restablecerContraseñas) {
		JButton volvera = new JButton("Volver");
		volvera.setBounds(40,130,120,30);
		pantalla.add(volvera);
		volvera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pantalla.getContentPane().removeAll();
				pantalla.repaint();
				pantalla.revalidate();
				
				pantalla.add(texto);
				pantalla.add(r);
				pantalla.add(c);		
				botonVolverGestionUsuarios(crearCuentas,modificarcuentas,eliminarCuentas,restablecerContraseñas);

			}
		});
	
		
	}
	private void botonVolverEstudiantePorRut(JLabel rut , JButton b1, JTextField rutEstudiante) {
		
		JButton volvera = new JButton("Volver");
		volvera.setBounds(40,130,120,30);
		pantalla.add(volvera);
		volvera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pantalla.getContentPane().removeAll();
				pantalla.repaint();
				pantalla.revalidate();
				pantalla.add(rut);
				pantalla.add(b1);
				pantalla.add( rutEstudiante);
								
			}
		});
	
	
	}
	public void botonVolverCuentasModificar(JButton b1, JButton b2,JButton b3, JButton b4, JLabel texto, JButton estudiante, JButton cord) {
		JButton volvera = new JButton("Volver");
		volvera.setBounds(40,210,120,30);
		
		pantalla.add(volvera);
		volvera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pantalla.getContentPane().removeAll();
				pantalla.repaint();
				pantalla.revalidate();
				texto.setText("Seleccione la cuenta a modificar");
				
				pantalla.add(texto);
				pantalla.add(estudiante);
				pantalla.add(cord);
				botonVolverGestionUsuarios(b1,b2,b3,b4);

								
			}
		});
	}
	private void cambiarDatosCoord(JButton boton, StrategyCambiarDatosCoord estrategia, String titulo, String nombre,JButton botonnombre,
			JButton botoncontra,JButton botoninfoAdicional,JButton b1,
			JButton b2, JButton b3, JButton b4,JLabel seleccioando, JButton estudiante, JButton coordinador) {
			
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				limpiarPantalla();
				JLabel texto = new JLabel("Ingrese nuevo/a "+ titulo +":");
				texto.setBounds(10,10,200,30);
				pantalla.add(texto);
				
				JTextField nuevo = new JTextField();
				nuevo.setBounds(180,10,100,30);
				pantalla.add(nuevo);
				
							
				JButton cambiar = new JButton("Cambiar");
				cambiar.setBounds(150,50,100,30);
				pantalla.add(cambiar);
				
				JButton volvera = new JButton("Volver");
				volvera.setBounds(40,130,120,30);
				pantalla.add(volvera);
				
				cambiar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String valorString = nuevo.getText();

						if(valorString.equals("")) {
							JOptionPane.showMessageDialog(pantalla, "Faltan datos");
						}else {
							sistema.cambiarCoordinador(nombre, estrategia, valorString);
							JOptionPane.showMessageDialog(pantalla, titulo+" se ha actualizo!");
						}
					}//---
				});// fin boton cambiar
				volvera.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						pantalla.setBounds(600,200,350,300);

						pantalla.getContentPane().removeAll();
						pantalla.repaint();
						pantalla.revalidate();
						
						pantalla.add(botonnombre);
						pantalla.add(botoncontra);
						pantalla.add(botoninfoAdicional);
						
			
						JLabel seleccionar = new  JLabel("Seleccione el dato a modificar");
						seleccionar.setBounds(90,20,200,30);
						pantalla.add(seleccionar);
						botonVolverCuentasModificar(b1,b2,b3,b4,seleccioando,estudiante,coordinador);

					}
				});//fin boton volvera
				
			}
		});
	}
			
		

}

