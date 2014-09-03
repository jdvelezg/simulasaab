/**
 * 
 */
package simulaSAAB.modeloSimulacion.comunicacion;

import simulaSAAB.modeloSimulacion.AmbienteLocal;
import simulaSAAB.modeloSimulacion.Producto;
import simulaSAAB.modeloSimulacion.agentes.AgenteSaab;

/**
 * @author dampher
 *
 */
public class Oferta extends Demanda {
	
	private int id;
	
	private double Cantidad;
	
	private Producto Producto;
	
	private Double Precio;
	
	private AmbienteLocal Ubicacion;
	
	private AgenteSaab Ofertante;
	
	private String Estado;//vigente - caducada - vendida
	
	
	/**
	 * Constructor
	 */
	public Oferta(){
		super();
	}
	
	/**
	 * Constructor
	 * @param cantidad
	 * @param p
	 * @param a
	 */
	public Oferta(double cantidad, Producto p, AgenteSaab a){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCantidad() {
		return Cantidad;
	}

	public void setCantidad(double cantidad) {
		Cantidad = cantidad;
	}

	public Producto getProducto() {
		return Producto;
	}

	public void setProducto(Producto producto) {
		Producto = producto;
	}

	public Double getPrecio() {
		return Precio;
	}
	
	public Double getPrecioUnitario(){
		return Precio/Cantidad;
	}

	public void setPrecio(Double precio) {
		Precio = precio;
	}

	public AmbienteLocal getUbicacion() {
		return Ubicacion;
	}

	public void setUbicacion(AmbienteLocal ubicacion) {
		Ubicacion = ubicacion;
	}

	public AgenteSaab getOfertante() {
		return Ofertante;
	}

	public void setOfertante(AgenteSaab ofertante) {
		Ofertante = ofertante;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}
	
	

}
