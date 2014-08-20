/**
 * 
 */
package simulaSAAB.modeloSimulacion.agentes;

import java.util.List;

import simulaSAAB.modeloSimulacion.comunicacion.Experiencia;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;
import simulaSAAB.modeloSimulacion.comunicacion.Utilidad;
import simulaSAAB.modeloSimulacion.tareas.SistemaActividadHumana;

/**
 * @author dampher
 *
 */
public interface AgenteSaab {
	
	List<Experiencia> getExperiencia(Proposito p);
	
	Experiencia getExperiencia(SistemaActividadHumana act);
	
	double getUltimaUtilidadObtenida();
	
	void sendMessage();
	
	void receiveMessage();

}
