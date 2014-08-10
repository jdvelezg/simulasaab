/**
 * 
 */
package simulaSAAB.modeloSimulacion.agentes;

import simulaSAAB.modeloSimulacion.comunicacion.Demanda;
import simulaSAAB.modeloSimulacion.comunicacion.Oferta;

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

}
