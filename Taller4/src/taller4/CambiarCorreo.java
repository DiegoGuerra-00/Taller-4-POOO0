package taller4;

public class CambiarCorreo implements StrategyCambiodatos{

	@Override
	public void cambiar(Estudiante estudiante, String val) {
		estudiante.setCorreoElectronico(val);
	}

}
