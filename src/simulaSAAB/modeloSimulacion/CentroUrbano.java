/**
 * 
 */
package simulaSAAB.modeloSimulacion;

import simulaSAAB.modeloSimulacion.agentes.OperadorDemanda;
import simulaSAAB.modeloSimulacion.agentes.OperadorOferta;

import com.vividsolutions.jts.geom.Geometry;

/**
 * @author dampher
 *
 */
public class CentroUrbano extends AmbienteLocal {
	
	private Geometry geometria;
	private OperadorOferta OperadorOferta;
	private OperadorDemanda OperadorDemanda;
	
	/**
	 * Constructor
	 */
	public CentroUrbano(){
		this.OperadorDemanda 	= new OperadorDemanda();
		this.OperadorOferta 	= new OperadorOferta();
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
