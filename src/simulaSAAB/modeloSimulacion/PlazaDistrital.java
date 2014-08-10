/**
 * 
 */
package simulaSAAB.modeloSimulacion;

import java.util.List;

import simulaSAAB.modeloSimulacion.agentes.NodoSAAB;

/**
 * @author dampher
 *
 */
public class PlazaDistrital extends NodoSAAB {

	private String Nombre;
	
	private List<PuestoDeVenta> puestos;
	
	/**
	 * Constructor
	 * @param nombre
	 */
	public PlazaDistrital(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the puestos
	 */
	public List<PuestoDeVenta> getPuestos() {
		return puestos;
	}

	/**
	 * @param puestos the puestos to set
	 */
	public void setPuestos(List<PuestoDeVenta> puestos) {
		this.puestos = puestos;
	}
	
	

}
