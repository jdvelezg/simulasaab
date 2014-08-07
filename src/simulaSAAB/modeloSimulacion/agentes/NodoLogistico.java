package simulaSAAB.modeloSimulacion.agentes;

import simulaSAAB.main.Producto;

public abstract class NodoLogistico implements AgenteSaab {
	
	public abstract void almacenar(Producto p);
	
	public abstract void despachar(Producto p);
	
	

}
