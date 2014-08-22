package simulaSAAB.modeloSimulacion;

import repast.simphony.random.RandomHelper;
import simulaSAAB.modeloSimulacion.comunicacion.Recurso;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;

public class Terreno {	
	
	private int Hectareas;
	
	private double HaUsadas;
	
	private String usoSuelo;	
	
	private AmbienteLocal ambiente;	
	
	//private final Coordinate coordenadas;
	
	private final Geometry geom;
	
	private String Estado;
	
	/**
	 * Constructor
	 */
	public Terreno(Geometry g){
		this.geom = g;
		//this.coordenadas = c;
	}
	
	/**
	 * 
	 * @param hectareas
	 * @param cords
	 */
	public Terreno(int hectareas, Geometry g){		
		this.Hectareas		= hectareas;
		this.geom			=g;
		//this.coordenadas	= cords;		
	}
	
	/**
	 * Devuelve el recurso producido en el terreno.
	 * Usa el rendimiento promedio por hectarea del producto y genera una cantidad aleatoria
	 * que puede superar el promedio hasta en un 25%.
	 * 
	 * @param p El producto a cosechar.
	 * @return La cantidad de producto en su unidad de medida.
	 */
	public Recurso cosechar(Producto p){		
		
		double cantidad = (p.getRendimientohectarea()*RandomHelper.nextDoubleFromTo(0, 1.25))*this.HaUsadas;
		
		return new Recurso(p.getConcepto(),cantidad);
	}
	
	/**
	 * 
	 * @return Hectareas disponibles
	 */
	public double haDisponibles(){
		return this.Hectareas-this.HaUsadas;
	}
	/**
	 * @return the hectareas
	 */
	public int getHectareas() {
		return Hectareas;
	}

	/**
	 * @param hectareas the hectareas to set
	 */
	public void setHectareas(int hectareas) {
		Hectareas = hectareas;
	}

	/**
	 * @return the usoSuelo
	 */
	public String getUsoSuelo() {
		return usoSuelo;
	}

	/**
	 * @param usoSuelo the usoSuelo to set
	 */
	public void setUsoSuelo(String usoSuelo) {
		this.usoSuelo = usoSuelo;
	}

	/**
	 * @return the coordenadas
	 */
	/*public Coordinate getCoordenadas() {
		return coordenadas;
	}*/
	

	/**
	 * @return the ambiente
	 */
	public AmbienteLocal getAmbiente() {
		return ambiente;
	}

	/**
	 * @param ambiente the ambiente to set
	 */
	public void setAmbiente(AmbienteLocal ambiente) {
		this.ambiente = ambiente;
	}

	
	/**
	 * @return the haUsadas
	 */
	public double getHaUsadas() {
		return HaUsadas;
	}


	/**
	 * @param haUsadas the haUsadas to set
	 */
	public void setHaUsadas(double haUsadas) {
		HaUsadas = haUsadas;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	/**
	 * @return the geom
	 */
	public Geometry getGeom() {
		return geom;
	}
	
	

}
