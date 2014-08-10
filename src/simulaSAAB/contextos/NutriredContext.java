package simulaSAAB.contextos;

import repast.simphony.context.DefaultContext;
import simulaSAAB.main.VariablesGlobales;
import simulaSAAB.modeloSimulacion.agentes.AgenteSaab;

public class NutriredContext extends DefaultContext<Object> {
	/**
	 * Constructor
	 */
	public NutriredContext(){
		super(VariablesGlobales.CONTEXTO_NUTRIRED);
	}

}
