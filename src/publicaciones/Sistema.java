package publicaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Sistema extends Observable {
	
	private List<Articulo> articulos;
	
	
	public Sistema() {
		super();
		articulos = new ArrayList<Articulo>();
	}

	public void suscribirMiembro(Suscriptor suscriptor) {
		this.getSuscriptores().add(suscriptor);
	}
	
	public void ingresarArticulo(Articulo articulo) {
		this.getArticulos().add(articulo);
		this.notificar(articulo);
	}


	private void notificar(Articulo articulo) {
		// TODO Auto-generated method stub
		this.setChanged();
		this.notifyObservers(articulo);
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

}
