/**
 * 
 */
package simulaSAAB.modeloSimulacion.agentes;

import java.util.List;

import simulaSAAB.modeloSimulacion.comunicacion.Demanda;
import simulaSAAB.modeloSimulacion.comunicacion.Experiencia;
import simulaSAAB.modeloSimulacion.comunicacion.Oferta;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;
import simulaSAAB.modeloSimulacion.tareas.SistemaActividadHumana;

/**
 * @author dampher
 *
 */
public class OperadorDemanda extends OperadorSaab {
	
	/**
	 * Contructor
	 */
	public OperadorDemanda(){
		
	}
	
	@Override
	public List<Experiencia> getExperiencia(Proposito p) {
		return null;
	}

	/* (non-Javadoc)
	 * @see simulaSAAB.modeloSimulacion.agentes.AgenteSaab#sendMessage()
	 */
	@Override
	public void sendMessage() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see simulaSAAB.modeloSimulacion.agentes.AgenteSaab#receiveMessage()
	 */
	@Override
	public void receiveMessage() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see simulaSAAB.modeloSimulacion.agentes.OperadorSaab#registrarOferta(simulaSAAB.modeloSimulacion.comunicacion.Oferta)
	 */
	@Override
	public boolean registrarOferta(Oferta of) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see simulaSAAB.modeloSimulacion.agentes.OperadorSaab#registrarDemanda(simulaSAAB.modeloSimulacion.comunicacion.Demanda)
	 */
	@Override
	public boolean registrarDemanda(Demanda dm) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see simulaSAAB.modeloSimulacion.agentes.OperadorSaab#negociacionYCompra()
	 */
	@Override
	public void negociacionYCompra() {
		// TODO Auto-generated method stub

	}

	@Override
	public Experiencia getExperiencia(SistemaActividadHumana act) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addExperiencia(Experiencia e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getUltimaUtilidadObtenida() {
		// TODO Auto-generated method stub
		return 0;
	}

}
