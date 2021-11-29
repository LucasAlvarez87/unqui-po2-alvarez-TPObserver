package encuentrosDeportivos;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Aplicacion extends Observable {

	private List<Partido> partidos;

	public List<Partido> getPartidos() {
		return partidos;
	}

	public Aplicacion() {
		super();
		partidos = new ArrayList<Partido>();
	}
	
	public void agregarPartido(Partido partido) {
		this.getPartidos().add(partido);
		this.notificar(partido);
	}
	
	public void notificar(Partido partido) {
		this.setChanged();
		this.notifyObservers(partido);
	}
	
}
