/**
 * 
 */
package simulaSAAB.modeloSimulacion;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;

/**
 * @author dampher
 *
 */
public class ViaTransitable {
	
	private Geometry geometria;
	private Coordinate origen;
	private Coordinate destino;
	
	/**
	 * Constructor
	 */
	public ViaTransitable(){
		
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


	/**
	 * @return the origen
	 */
	public Coordinate getOrigen() {
		return origen;
	}


	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(Coordinate origen) {
		this.origen = origen;
	}


	/**
	 * @return the destino
	 */
	public Coordinate getDestino() {
		return destino;
	}


	/**
	 * @param destino the destino to set
	 */
	public void setDestino(Coordinate destino) {
		this.destino = destino;
	}



}
