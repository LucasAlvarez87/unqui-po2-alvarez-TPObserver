package concurso;

public class PartidaComenzada extends EstadoDePartida {

	public PartidaComenzada(SistemaDePreguntas sistema) {
		super(sistema);
	}

	@Override
	public void procesarSolicitud(Participante participante) throws Exception {
		throw new Exception("Accion no permitida"); 
	}

	@Override
	protected void procesarRespuesta(String pregunta, String respuesta, Participante participante) throws Exception {
		if (this.getSistema().getPreguntasYRespuestas().containsKey(pregunta) ) {
			this.getSistema().verificarRespuesta(pregunta,respuesta, participante);
		}
		else {
			participante.notificarNoExistePregunta(); 
		}
		
	}
	
	

}
