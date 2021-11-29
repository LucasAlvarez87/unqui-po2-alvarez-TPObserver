package publicaciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;

public class Suscriptor implements Observer {

	private List<String> intereses;
	private Sistema sistema;

	public Suscriptor() {
		super();
		this.intereses = new ArrayList<String>();
	}
	
	public void agregarInteres(String interes) {
		this.getIntereses().add(interes);
	}
	
	public void suscribir (Sistema sistema) {
		sistema.addObserver(this);
	}
	
	public void notificar(Articulo articulo) {
		if (this.esDeInteres(articulo)) {
			System.out.println("Hay un nuevo articulo de tu interes");
		}
	}

	public boolean esDeInteres(Articulo articulo) {
		return this.intereses.contains(articulo.getTitulo()) ||
				!Collections.disjoint(intereses, articulo.getAutores())||
				this.intereses.contains(articulo.getFiliacion())||
				this.intereses.contains(articulo.getLugarDePublicacion())||
				!Collections.disjoint(intereses, articulo.getPalabrasClaves());
	}
	public List<String> getIntereses() {
		return intereses;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		Articulo articulo = (Articulo) arg;
		if (this.esDeInteres(articulo)) {
			System.out.print("Hay un nuevo articulo de tu interes");
		}
		
	}
}
