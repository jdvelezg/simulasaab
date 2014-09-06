/**
 * 
 */
package simulaSAAB.modeloSimulacion.comunicacion;

/**
 * @author dampher
 *
 */
public class Dinero {
	
	private final String moneda ="COP";
	
	private Double cantidad;
	
	/**
	 * Constructor
	 */
	public Dinero(){
		this.cantidad =new Double(0);
	}
	
	/**
	 * Constructor
	 * @param cantidad de dinero
	 */
	public Dinero(Double cantidad){
		this.cantidad = cantidad;
	}
	
	/**
	 * Constructor
	 * @param cantidad de dinero
	 */
	public Dinero(double cantidad){
		this.cantidad = new Double(cantidad);
	}

}
