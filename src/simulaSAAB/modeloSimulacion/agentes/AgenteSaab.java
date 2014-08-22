/**
 * 
 */
package simulaSAAB.modeloSimulacion.agentes;

import java.util.List;

import simulaSAAB.modeloSimulacion.comunicacion.Experiencia;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;
import simulaSAAB.modeloSimulacion.comunicacion.Recurso;
import simulaSAAB.modeloSimulacion.comunicacion.Utilidad;
import simulaSAAB.modeloSimulacion.tareas.SistemaActividadHumana;

/**
 * @author dampher
 *
 */
public interface AgenteSaab {
	
	/**
	 * Agrega recursos al agente
	 * @param recurso
	 */
	void addRecurso(Recurso recurso);
	/**
	 * 
	 * @param p
	 * @return
	 */
	List<Experiencia> getExperiencia(Proposito p);
	
	/**
	 * 
	 * @param act
	 * @return
	 */
	Experiencia getExperiencia(SistemaActividadHumana act);
	
	/**
	 * 
	 * @return
	 */
	SistemaActividadHumana getActividadVigente();
	
	/**
	 * 
	 * @param e
	 */
	void setEstado(String e);
	
	/**
	 * 
	 * @param e
	 */
	void addExperiencia(Experiencia e);
	
	/**
	 * 
	 * @return
	 */
	double getUltimaUtilidadObtenida();
	
	/**
	 * 
	 */
	void sendMessage();
	
	/**
	 * 
	 */
	void receiveMessage();

}
