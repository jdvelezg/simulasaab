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
public class RuralContext extends DefaultContext<Object> {
	/**
	 * Constructor
	 */
	public RuralContext(){
		super(VariablesGlobales.CONTEXTO_RURAL);
	}

}
