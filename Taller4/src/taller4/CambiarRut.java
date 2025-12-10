package taller4;

public class CambiarRut implements StrategyCambiodatos{

	@Override
	public void cambiar(Estudiante estudiante, String val) {
		estudiante.setRut(val);
		
	}

}
