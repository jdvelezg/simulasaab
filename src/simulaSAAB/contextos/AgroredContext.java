/**
 * 
 */
package simulaSAAB.contextos;

import repast.simphony.context.DefaultContext;
import simulaSAAB.main.VariablesGlobales;
import simulaSAAB.modeloSimulacion.agentes.AgenteSaab;

/**
 * @author dampher
 *
 */
public class AgroredContext extends DefaultContext<Object> {
	
	/**
	 * Constructor
	 */
	public AgroredContext(){
		super(VariablesGlobales.CONTEXTO_AGRORED);
	}

}
