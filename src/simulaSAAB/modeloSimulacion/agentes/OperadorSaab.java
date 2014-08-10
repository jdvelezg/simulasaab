package simulaSAAB.modeloSimulacion.agentes;

import simulaSAAB.modeloSimulacion.comunicacion.Demanda;
import simulaSAAB.modeloSimulacion.comunicacion.Oferta;

public abstract class OperadorSaab implements AgenteSaab {
	
	public abstract boolean registrarOferta(Oferta of);
	
	public abstract boolean registrarDemanda(Demanda dm);
	
	public abstract void negociacionYCompra();
		

}
