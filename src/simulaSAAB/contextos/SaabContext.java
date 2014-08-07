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
public class SaabContext extends DefaultContext<Object> {
	/**
	 * Constructor
	 */
	public SaabContext(){
		super(VariablesGlobales.CONTEXTO_SAAB);
	}

}
