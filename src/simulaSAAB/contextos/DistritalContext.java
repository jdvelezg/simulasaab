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
public class DistritalContext extends DefaultContext<Object> {
	
	/**
	 * Constructor
	 */
	public DistritalContext(){
		super(VariablesGlobales.CONTEXTO_DISTRITAL);
	}

}
