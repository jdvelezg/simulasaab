package simulaSAAB.modeloSimulacion.tareas;

import simulaSAAB.modeloSimulacion.comunicacion.Proposito;
import simulaSAAB.modeloSimulacion.agentes.AgenteSaab;

public interface SistemaActividadHumana {	
	
	String getEnunciado();
	
	Proposito getProposito();
	
	String getEstado();
	
	void secuenciaPrincipalDeAcciones(AgenteSaab actor);

}
