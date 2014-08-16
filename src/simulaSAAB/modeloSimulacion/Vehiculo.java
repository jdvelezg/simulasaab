/**
 * 
 */
package simulaSAAB.modeloSimulacion;

import repast.simphony.space.gis.Car;
import simulaSAAB.modeloSimulacion.agentes.AgenteSaab;

/**
 * @author dampher
 *
 */
public class Vehiculo extends Car {
	
	private AgenteSaab propietario;
	
	
	/**
	 * Constructor superclase
	 * @param make
	 * @param model
	 * @param year
	 * @param color
	 */
	public Vehiculo(String make, String model, int year, String color) {
		super(make, model, year, color);
		// TODO Auto-generated constructor stub
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
	
	

}
