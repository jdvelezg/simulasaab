/**
 * 
 */
package simulaSAAB.modeloSimulacion;

import java.util.List;

import com.vividsolutions.jts.geom.Coordinate;

import simulaSAAB.modeloSimulacion.agentes.NodoSAAB;
import simulaSAAB.modeloSimulacion.agentes.OperadorSaab;;

/**
 * @author dampher
 *
 */
public class CentroGestionVeredal extends NodoSAAB {
	
	private Coordinate Ubicacion;
	
	private List<OperadorSaab> operadores;
	
	/**
	 * Constructor
	 * @param nombre
	 */
	public CentroGestionVeredal(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the ubicacion
	 */
	public Coordinate getUbicacion() {
		return Ubicacion;
	}

	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(Coordinate ubicacion) {
		Ubicacion = ubicacion;
	}

	/**
	 * @return the operadores
	 */
	public List<OperadorSaab> getOperadores() {
		return operadores;
	}

	/**
	 * @param operadores the operador to add
	 */
	public void addOperadores(OperadorSaab operador) {
		this.operadores.add(operador);
	}
	
	

}
