package concurso;

import java.util.Map;

import publicaciones.Sistema;

public class Participante {
	
	private String nombre;
	private SistemaDePreguntas sistema;
	
	public Participante(String nombre,SistemaDePreguntas sistema) {
		super();
		this.nombre = nombre;
		this.sistema = sistema;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public SistemaDePreguntas getSistema() {
		return sistema;
	}
	
	public void setSistema(SistemaDePreguntas sistema) {
		this.sistema = sistema;
	}
	
	public void solicitarSumarse() throws Exception {
		this.getSistema().procesarSolicitud(this);
	}



	public void recibirNotificacionDeInicio(Map<String, String> preguntasYRespuestas) {
		// TODO Auto-generated method stub
		
		
	}
	
	public void contestarPregunta(String pregunta, String respuesta) throws Exception {
		this.getSistema().procesarRespuesta(pregunta, respuesta, this);
	}

	public void notificarNoExistePregunta() {
		// TODO Auto-generated method stub
		
	}

	public void notificacionDeRespuestaIncorreta() {
		// TODO Auto-generated method stub
		
	}

	public void notificacionDeRespuestaCorrecta() {
		// TODO Auto-generated method stub
		
	}

	public void notificarDeParticipanteRespondioCorrectamente(String string, String pregunta) {
		// TODO Auto-generated method stub
		
	}

	public void notificarGanador(String string) {
		// TODO Auto-generated method stub
		
	}
	
	
}
