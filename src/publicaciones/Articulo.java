package publicaciones;

import java.util.List;

public class Articulo {

	private String titulo;
	private List<String> autores;
	private String filiacion;
	private String tipo;
	private String lugarDePublicacion;
	private List<String> palabrasClaves;
	
	public String getTitulo() {
		return titulo;
	}

	public List<String> getAutores() {
		return autores;
	}

	public String getFiliacion() {
		return filiacion;
	}

	public String getTipo() {
		return tipo;
	}

	public String getLugarDePublicacion() {
		return lugarDePublicacion;
	}

	public List<String> getPalabrasClaves() {
		return palabrasClaves;
	}

	public Articulo(String titulo, List<String> autores, String filiacion, String tipo, String lugarDePublicacion,
			List<String> palabrasClaves) {
		super();
		this.titulo = titulo;
		this.autores = autores;
		this.filiacion = filiacion;
		this.tipo = tipo;
		this.lugarDePublicacion = lugarDePublicacion;
		this.palabrasClaves = palabrasClaves;
	}
}
