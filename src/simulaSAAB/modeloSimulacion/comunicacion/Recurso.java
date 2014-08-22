package simulaSAAB.modeloSimulacion.comunicacion;

public class Recurso {
	
	private int id;
	
	private Item item;
	
	private double cantidad;
	
	public Recurso(){
		
	}
	/**
	 * Constructor
	 * @param i Item q compone el recurso
	 * @param cantidad cantidad de items que componen el recurso
	 */
	public Recurso(Item i, double cantidad){
		this.cantidad 	= cantidad;
		this.item		=i;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}
	/**
	 * @param item the item to set
	 */
	public void setItem(Item item) {
		this.item = item;
	}
	/**
	 * @return the cantidad
	 */
	public double getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
