package concurso;

public abstract class EstadoDePartida {
	
	SistemaDePreguntas sistema;

	public EstadoDePartida(SistemaDePreguntas sistema) {
		super();
		this.sistema = sistema;
	}

	public abstract void procesarSolicitud(Participante participante) throws Exception ;

	public SistemaDePreguntas getSistema() {
		return sistema;
	}

	public void setSistema(SistemaDePreguntas sistema) {
		this.sistema = sistema;
	}

	protected abstract void procesarRespuesta(String pregunta, String respuesta, Participante participante) throws Exception;
	
	
	
}
