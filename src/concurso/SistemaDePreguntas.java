package concurso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import complexWithListener.SensorListener;

public class SistemaDePreguntas {
	private EstadoDePartida estado;
	private Set<Participante> participantes;
	private Map<String, String> preguntasYRespustras;
	private Map<Participante,Set<String>> respuestaCorrectas;
	
	
	
	public SistemaDePreguntas(Map<String, String> preguntas) {
		super();
		this.preguntasYRespustras = preguntas;
		this.participantes = new HashSet<Participante>();
		this.estado = new EsperandoParticipantes(this);
		this.respuestaCorrectas = new HashMap<Participante, Set<String> >();
	}
	
	public void procesarSolicitud(Participante participante) throws Exception {
		this.getEstado().procesarSolicitud(participante);
	}
	
	public EstadoDePartida getEstado() {
		return estado;
	}

	public void setEstado(EstadoDePartida estado) {
		this.estado = estado;
	}

	public Set<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Set<Participante> participantes) {
		this.participantes = participantes;
	}

	public Map<String, String> getPreguntasYRespuestas() {
		return this.preguntasYRespustras;
	}

	public void setPreguntasYRespuestas(Map<String, String> preguntas) {
		this.preguntasYRespustras = preguntas;
	}

	public Map<Participante, Set<String>> getRespuestaCorrectas() {
		return respuestaCorrectas;
	}

	public void setRespuestaCorrectas(Map<Participante, Set<String>> respuestaCorrectas) {
		this.respuestaCorrectas = respuestaCorrectas;
	}
	public void agregarParticipante(Participante participante) {
		this.getParticipantes().add(participante);
		this.getRespuestaCorrectas().put(participante, new HashSet<String>());
	}

	public void iniciarPartida() {
		this.setEstado(new PartidaComenzada(this));
		this.notificarJugadoresDeInicioDePartida();
	}

	private void notificarJugadoresDeInicioDePartida() {
		this.getParticipantes().stream().forEach(p -> p.recibirNotificacionDeInicio(this.getPreguntasYRespuestas()) );
	}
	
	public void  procesarRespuesta(String pregunta, String respuesta, Participante participante) throws Exception {
		this.getEstado().procesarRespuesta(pregunta,respuesta, participante);
	}

	public void verificarRespuesta(String pregunta, String respuesta, Participante participante) {
		// TODO Auto-generated method stub
		if (this.getPreguntasYRespuestas().get(pregunta).equals(respuesta)  ) {
			this.contestanteRespondioCorrectamente(pregunta, respuesta,participante);
		}
		else {
			this.contestanteRespondioIncorrectamente(participante);
		}
		
	}

	private void contestanteRespondioIncorrectamente(Participante participante) {
		// TODO Auto-generated method stub
		participante.notificacionDeRespuestaIncorreta();
	}

	private void contestanteRespondioCorrectamente(String pregunta,String respuesta, Participante participante) {
		// TODO Auto-generated method stub
		this.getRespuestaCorrectas().get(participante).add(respuesta);
		if (this.getRespuestaCorrectas().get(participante).size() == 5) {
			this.finalizarPartida(participante);
		}
		else {
			this.notificarDeRespuestaCorrecta(pregunta,participante);
		}
	}

	private void notificarDeRespuestaCorrecta(String pregunta, Participante participante) {
		participante.notificacionDeRespuestaCorrecta();
		this.getParticipantes().stream().forEach(p -> p.notificarDeParticipanteRespondioCorrectamente(participante.getNombre(), pregunta));
	}

	private void finalizarPartida(Participante participante) {
		// TODO Auto-generated method stub
		this.getParticipantes().stream().forEach(p -> p.notificarGanador(participante.getNombre()));
		this.setEstado(new EsperandoParticipantes(this));
	}
	
}
