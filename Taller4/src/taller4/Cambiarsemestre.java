package taller4;

public class Cambiarsemestre implements StrategyCambiodatos {

	@Override
	public void cambiar(Estudiante estudiante, String val) {
		int semestre = Integer.valueOf(val);
		estudiante.setSemestre(semestre);
	}

}
