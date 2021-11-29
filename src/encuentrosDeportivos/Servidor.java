package encuentrosDeportivos;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Servidor implements Observer {
	private List<Partido> partidos;
	private List<String> deportesInteresados;
	private Aplicacion aplicacion;
	

	
	public Servidor( List<String> deportesInteresados, Aplicacion aplicacion) {
		super();
		this.partidos = new ArrayList<Partido>();
		this.deportesInteresados = deportesInteresados;
		this.aplicacion = aplicacion;
		this.aplicacion.addObserver(this);
	}


	public List<Partido> getPartidos() {
		return partidos;
	}

	public List<String> getDeportesInteresados() {
		return deportesInteresados;
	}


	@Override
	public void update(Observable o, Object arg) {
		Partido partido = (Partido) arg;
		if  (this.getDeportesInteresados().contains(partido.getDeporte())) {
			this.getPartidos().add(partido);
		}
	}
	
	
}
