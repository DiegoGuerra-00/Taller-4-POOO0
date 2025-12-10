package taller4;

public class Cambiarcontraseña implements StrategyCambiodatos{

	@Override
	public void cambiar(Estudiante estudiante, String val) {
		estudiante.setContraseña(val);
	}
	

}
