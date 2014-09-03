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
public class Demanda {
	
	private int id;
	
	private double Cantidad;
	
	private Producto Producto;
	
	private Double Precio;
	
	private AmbienteLocal Ubicacion;
	
	private AgenteSaab Demandante;
	
	private String Estado;//vigente - caducada - vendida
	
	
	/**
	 * Constructor
	 */
	public Demanda(){
		
		this.Estado = "vigente";
	}


	public int getID() {
		return id;
	}


	public void setID(int id) {
		this.id = id;
	}


	public double getCantidad() {
		return Cantidad;
	}


	public void setCantidad(double cantidad) {
		Cantidad = cantidad;
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


	public Producto getProducto() {
		return Producto;
	}


	public void setProducto(Producto producto) {
		Producto = producto;
	}


	public AmbienteLocal getUbicacion() {
		return Ubicacion;
	}


	public void setUbicacion(AmbienteLocal ubicacion) {
		Ubicacion = ubicacion;
	}


	public AgenteSaab getDemandante() {
		return Demandante;
	}


	public void setDemandante(AgenteSaab demandante) {
		Demandante = demandante;
	}


	public String getEstado() {
		return Estado;
	}


	public void setEstado(String estado) {
		Estado = estado;
	}
	

}
