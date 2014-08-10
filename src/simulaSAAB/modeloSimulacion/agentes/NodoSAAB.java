package simulaSAAB.modeloSimulacion.agentes;

import com.vividsolutions.jts.geom.Geometry;

import simulaSAAB.modeloSimulacion.Producto;

public class NodoSAAB extends NodoLogistico {
	
	private String nombre;
	
	private Geometry geometria;
	
	/**
	 * Constructor
	 * @param nombre
	 */
	public NodoSAAB(String nombre){
		this.nombre = nombre;
	}

	@Override
	public void sendMessage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void receiveMessage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void almacenar(Producto p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void despachar(Producto p) {
		// TODO Auto-generated method stub

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
	 * @return the geometria
	 */
	public Geometry getGeometria() {
		return geometria;
	}

	/**
	 * @param geometria the geometria to set
	 */
	public void setGeometria(Geometry geometria) {
		this.geometria = geometria;
	}
	
	

}
