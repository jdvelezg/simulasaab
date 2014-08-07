/**
 * 
 */
package simulaSAAB.contextos;

import repast.simphony.context.DefaultContext;
import simulaSAAB.main.VariablesGlobales;

/**
 * @author dampher
 *
 */
public class DemandaContext extends DefaultContext<Object> {
	/**
	 * Constructor
	 */
	public DemandaContext(){
		super(VariablesGlobales.CONTEXTO_DEMANDA);
	}

}
