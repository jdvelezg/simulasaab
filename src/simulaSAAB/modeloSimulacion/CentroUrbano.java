/**
 * 
 */
package simulaSAAB.modeloSimulacion;

import com.vividsolutions.jts.geom.Geometry;

/**
 * @author dampher
 *
 */
public class CentroUrbano extends AmbienteLocal {
	
	private Geometry geometria;
	
	/**
	 * Constructor
	 */
	public CentroUrbano(){
		
	}

	/**
	 * @return the geometria
	 */
	public Geometry getGeometria() {
		return geometria;
	}

	/**
	 * @param geometria the geometria to set
	 */
	public void setGeometria(Geometry geometria) {
		this.geometria = geometria;
	}
	
	

}
