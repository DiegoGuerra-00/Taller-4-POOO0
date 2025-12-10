package taller4;

public class CambiarNombre implements StrategyCambiodatos{

	@Override
	public void cambiar(Estudiante estudiante, String val) {
		estudiante.setNombre(val);
	}
	

}
