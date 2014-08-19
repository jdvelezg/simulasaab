/**
 * 
 */
package simulaSAAB.modeloSimulacion.agentes;

import java.util.List;

import simulaSAAB.modeloSimulacion.comunicacion.Experiencia;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;

/**
 * @author dampher
 *
 */
public interface AgenteSaab {
	
	List<Experiencia> getExperiencia(Proposito p);
	
	void sendMessage();
	
	void receiveMessage();

}
