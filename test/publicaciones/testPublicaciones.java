package publicaciones;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class testPublicaciones {
	
	private Sistema sistema;
	private Articulo articulo;
	private Suscriptor suscriptor;
	
	@BeforeEach																																		
	public void setUp() {
		sistema = new Sistema();
		articulo = new Articulo("CyberSecurity en Argentina",Arrays.asList("Alvarez","Navarro"), "Universidad", "Investigacion", "xxx", Arrays.asList("CyberSecurity","xxx"));
		suscriptor = new Suscriptor();
		suscriptor.agregarInteres("CyberSecurity");
		suscriptor.suscribir(sistema);
	}
	
	
	@Test
	public void testNotificar() {
		assertTrue(suscriptor.esDeInteres(articulo));
	}
	
	@Test
	public void testNotificarSuscriptor() {
		sistema.ingresarArticulo(articulo);
	}
}
