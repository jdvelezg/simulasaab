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
public class ConexionesContext extends DefaultContext<Object> {
	/**
	 * Contructor
	 */
	public ConexionesContext(){
		super(VariablesGlobales.CONTEXTO_CONEXIONES);
	}

}
