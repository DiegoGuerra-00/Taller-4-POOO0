package taller4;

public class CambiarCarrera implements StrategyCambiodatos{

	@Override
	public void cambiar(Estudiante estudiante, String val) {
		estudiante.setCarrera(val);		
	}
	

}
