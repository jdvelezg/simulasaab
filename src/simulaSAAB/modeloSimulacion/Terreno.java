package simulaSAAB.modeloSimulacion;

import repast.simphony.random.RandomHelper;

import com.vividsolutions.jts.geom.Coordinate;

public class Terreno {	
	
	private int Hectareas;
	
	private double HaUsadas;
	
	private String usoSuelo;	
	
	private AmbienteLocal ambiente;	
	
	private final Coordinate coordenadas;
	
	private String Estado;
	
	/**
	 * Constructor
	 */
	public Terreno(Coordinate c){
		this.coordenadas = c;
	}
	
	/**
	 * Devuelve la cantidad de productos producidos en el terreno.
	 * Usa el rendimiento promedio por hectarea del producto y genera una cantidad aleatoria
	 * que supera el promedio hasta en un 50%.
	 * @param p El producto a cosechar.
	 * @return La cantidad de producto en su unidad de medida.
	 */
	public double cosechar(Producto p){		
		
		return (p.getRendimientohectarea()*RandomHelper.nextDoubleFromTo(0, 1.5))*this.HaUsadas;
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
	public Coordinate getCoordenadas() {
		return coordenadas;
	}
	

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

	public Terreno(int hectareas, Coordinate cords){		
		this.Hectareas		= hectareas;
		this.coordenadas	= cords;		
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
	
	

}
