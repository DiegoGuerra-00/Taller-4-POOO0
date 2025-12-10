package taller4;

public class CambiarcontraseñaCord implements StrategyCambiarDatosCoord{

	@Override
	public void cambiardatosCord(Usuario usuario, String valor) {
		usuario.setContraseña(valor);
	}

}
