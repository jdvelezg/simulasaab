/**
 * 
 */
package simulaSAAB.modeloSimulacion.agentes;

import java.util.List;

import simulaSAAB.modeloSimulacion.comunicacion.Demanda;
import simulaSAAB.modeloSimulacion.comunicacion.Experiencia;
import simulaSAAB.modeloSimulacion.comunicacion.Oferta;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;

/**
 * @author dampher
 *
 */
public class OperadorOferta extends OperadorSaab {
	
	/**
	 * Constructor
	 */
	public OperadorOferta(){
		
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

	@Override
	public boolean registrarOferta(Oferta of) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registrarDemanda(Demanda dm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void negociacionYCompra() {
		// TODO Auto-generated method stub
		
	}

}
