package encuentrosDeportivos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testDeEncuentros {
	
	private Aplicacion aplicacion;
	private Partido partido;
	private Servidor servidor;
	private AppMovil app;
	
	@BeforeEach																																		
	public void setUp() {
		aplicacion = new Aplicacion();
		partido = new Partido("Futbol", Arrays.asList("Boca","River"), "2-2");
		servidor = new Servidor(Arrays.asList("Futbol","Basquet"), aplicacion);
		app = new AppMovil("Futbol", "Boca");
	}
	
	@Test
	public void testDeAplicacion() {
		aplicacion.agregarPartido(partido);
		assertFalse(aplicacion.getPartidos().isEmpty());
	}
	
	@Test
	public void testDeServidor() {
		aplicacion.agregarPartido(partido);
		assertFalse(servidor.getPartidos().isEmpty());
	}
}
