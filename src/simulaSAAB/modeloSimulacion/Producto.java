package simulaSAAB.modeloSimulacion;

import simulaSAAB.modeloSimulacion.comunicacion.Concepto;
import simulaSAAB.modeloSimulacion.comunicacion.Item;
import simulaSAAB.persistencia.ProductoConfigurado;

public class Producto implements Concepto {
	
	private String nombre;
	
	private String tipo;	

	private String MinPisoTermico;
	
	private String MaxPisoTermico;
	
	private double costoproduccionhectarea;
	
	private double rendimientohectarea;
	
	private double UtilidadRegistrada;
	
	private double PrecioVenta;
	
	private String unidadmedida;
	
	private int Cantidad;
	
	
	/**
	 * Constructor
	 */
	public Producto(){
		
	}
	
	/**
	 * Constructor
	 * @param p
	 */
	public Producto(ProductoConfigurado p){
		
		this.nombre					=p.getNombre();
		this.tipo					=p.getTipo();
		this.MinPisoTermico			=p.getMinPisoTermico();
		this.MaxPisoTermico			=p.getMaxPisoTermico();
		this.costoproduccionhectarea=p.getCostoproduccionhectarea();
		this.rendimientohectarea	=p.getRendimientohectarea();
		this.UtilidadRegistrada		=p.getUtilidadRegistrada();
		this.PrecioVenta			=p.getPrecioSIPSA();
		this.unidadmedida			=p.getUnidadmedida();
		
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the minPisoTermico
	 */
	public String getMinPisoTermico() {
		return MinPisoTermico;
	}

	/**
	 * @param minPisoTermico the minPisoTermico to set
	 */
	public void setMinPisoTermico(String minPisoTermico) {
		MinPisoTermico = minPisoTermico;
	}

	/**
	 * @return the maxPisoTermico
	 */
	public String getMaxPisoTermico() {
		return MaxPisoTermico;
	}

	/**
	 * @param maxPisoTermico the maxPisoTermico to set
	 */
	public void setMaxPisoTermico(String maxPisoTermico) {
		MaxPisoTermico = maxPisoTermico;
	}

	/**
	 * @return the costoproduccionhectarea
	 */
	public double getCostoproduccionhectarea() {
		return costoproduccionhectarea;
	}

	/**
	 * @param costoproduccionhectarea the costoproduccionhectarea to set
	 */
	public void setCostoproduccionhectarea(double costoproduccionhectarea) {
		this.costoproduccionhectarea = costoproduccionhectarea;
	}

	/**
	 * @return the rendimientohectarea
	 */
	public double getRendimientohectarea() {
		return rendimientohectarea;
	}

	/**
	 * @param rendimientohectarea the rendimientohectarea to set
	 */
	public void setRendimientohectarea(double rendimientohectarea) {
		this.rendimientohectarea = rendimientohectarea;
	}

	/**
	 * @return the utilidadRegistrada
	 */
	public double getUtilidadRegistrada() {
		return UtilidadRegistrada;
	}

	/**
	 * @param utilidadRegistrada the utilidadRegistrada to set
	 */
	public void setUtilidadRegistrada(double utilidadRegistrada) {
		UtilidadRegistrada = utilidadRegistrada;
	}

	/**
	 * @return the precioVenta
	 */
	public double getPrecioVenta() {
		return PrecioVenta;
	}

	/**
	 * @param precioVenta the precioVenta to set
	 */
	public void setPrecioVenta(double precioVenta) {
		PrecioVenta = precioVenta;
	}

	/**
	 * @return the unidadmedida
	 */
	public String getUnidadmedida() {
		return unidadmedida;
	}

	/**
	 * @param unidadmedida the unidadmedida to set
	 */
	public void setUnidadmedida(String unidadmedida) {
		this.unidadmedida = unidadmedida;
	}

	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return Cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	@Override
	public Item getConcepto() {
		// TODO Devuelve una representacion conceptual del producto
		
		return new Item(this.nombre,this.getClass().getName());
	}
	
	

}
