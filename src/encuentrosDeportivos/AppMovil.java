package encuentrosDeportivos;

import java.util.Observable;
import java.util.Observer;

public class AppMovil implements Observer {
	
	private String deporteInteresado;
	private String equipoInteresado;
	
	

	public AppMovil(String deporteInteresado, String equipoInteresado) {
		super();
		this.deporteInteresado = deporteInteresado;
		this.equipoInteresado = equipoInteresado;
	}



	public String getDeporteInteresado() {
		return deporteInteresado;
	}



	public String getEquipoInteresado() {
		return equipoInteresado;
	}



	@Override
	public void update(Observable o, Object arg) {
		Partido partido = (Partido) arg;
		if (partido.getDeporte().equals(this.getDeporteInteresado()) || 
			partido.getContrincantes().contains(this.getEquipoInteresado())) {
			System.out.print(partido.toString());
		}
	}

}
