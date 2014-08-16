/**
 * 
 */
package simulaSAAB.modeloSimulacion;

import com.vividsolutions.jts.geom.Coordinate;

import simulaSAAB.modeloSimulacion.agentes.AgenteSaab;
import simulaSAAB.modeloSimulacion.agentes.Intermediario;
import simulaSAAB.modeloSimulacion.agentes.NodoSAAB;

/**
 * @author dampher
 *
 */
public class CentroDeAcopio extends NodoSAAB {
	
	private AgenteSaab propietario;
	private final Coordinate coordenadas;
	private double Capacidad;
	
	/**
	 * Constructor
	 * @param nombre
	 */
	public CentroDeAcopio(String nombre, Coordinate c) {
		super(nombre);
		this.coordenadas = c;
	}

	/**
	 * @return the propietario
	 */
	public AgenteSaab getPropietario() {
		return propietario;
	}

	/**
	 * @param propietario the propietario to set
	 */
	public void setPropietario(AgenteSaab propietario) {
		this.propietario = propietario;
	}

	/**
	 * @return the coordenadas
	 */
	public Coordinate getCoordenadas() {
		return coordenadas;
	}
	
	

}
