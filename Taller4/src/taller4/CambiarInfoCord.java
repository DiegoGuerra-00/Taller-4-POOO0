package taller4;

public class CambiarInfoCord implements StrategyCambiarDatosCoord{

	@Override
	public void cambiardatosCord(Usuario usuario, String valor) {
		usuario.setInformacion(valor);
	}

}
