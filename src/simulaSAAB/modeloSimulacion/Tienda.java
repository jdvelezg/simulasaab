/**
 * 
 */
package simulaSAAB.modeloSimulacion;

import com.vividsolutions.jts.geom.Coordinate;

/**
 * @author dampher
 *
 */
public class Tienda extends CentroDeAcopio {
	
	private Coordinate coordenadas;

	/**
	 * Constructor
	 * @param nombre
	 */
	public Tienda(String nombre, Coordinate c) {
		super(nombre, c);		
	}

}
