package taller4;

public class CambiarNombreCord implements StrategyCambiarDatosCoord{

	@Override
	public void cambiardatosCord(Usuario usuario, String valor) {
		usuario.setNombre(valor);
	}

}
