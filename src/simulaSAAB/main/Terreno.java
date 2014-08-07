package simulaSAAB.main;

import com.vividsolutions.jts.geom.Coordinate;

public class Terreno {	
	
	private int Hectareas;
	private double HaUsadas;
	private String usoSuelo;
	private Coordinate coordenadas;
	private AmbienteLocal ambiente;
	
	
	/**
	 * Constructor
	 */
	public Terreno(){
		
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
	 * @param coordenadas the coordenadas to set
	 */
	public void setCoordenadas(Coordinate coordenadas) {
		this.coordenadas = coordenadas;
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

}
