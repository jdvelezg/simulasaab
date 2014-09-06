/**
 * 
 */
package simulaSAAB.modeloSimulacion.comunicacion;

/**
 * @author dampher
 *
 */
public interface Preposicion {
	
	
	/**
	 * Devuelve el enunciado de la preposicion en lenguaje natural
	 * @return
	 */
	String getEnunciadoPreposicion();	
	

}

class ComprarProductoAPrecio implements Preposicion{
	
	private Accion comprar;
	
	private Concepto producto;
	
	Double Precio;
	
	/**
	 * Constructor
	 */
	public ComprarProductoAPrecio(Concepto producto, Double Precio){
		this.comprar 	= new Accion("Comprar");
		this.producto	= producto;
		this.Precio		= Precio;
	}

	@Override
	public String getEnunciadoPreposicion() {
		// TODO Auto-generated method stub
		return comprar.getVerbo()+" "+producto.getConcepto().getNombre()+" a "+Precio.toString();
	}
	
}

class VenderProductoAPrecio implements Preposicion{
	
	private Accion vender;
	
	private Concepto producto;
	
	Double Precio;
	
	/**
	 * Constructor
	 */
	public VenderProductoAPrecio(Concepto producto, Double Precio){
		this.vender 	= new Accion("Vender");
		this.producto 	= producto;
		this.Precio 	= Precio;		
	}

	@Override
	public String getEnunciadoPreposicion() {
		// TODO Auto-generated method stub
		return vender.getVerbo()+" "+producto.getConcepto().getNombre()+" a "+Precio.toString();
	}
	
}
