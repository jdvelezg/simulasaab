package simulaSAAB.persistencia;


public class RegionConfigurada {
	
	private int id;
	
	private String nombre;
	
	private String TipoEntorno;
	
	private int AnilloSAAB;
	
	private String Coordenadas;

	private String Clima;
	
	private String PisoTermico;
	
	/**
	 * Constructor
	 * @param nombre
	 */
	public RegionConfigurada(String nombre){
		
		this.nombre		=nombre;
		
		switch(nombre){
		
		case "caqueza":
			
			this.id				=1;
			this.TipoEntorno	="rural";
			this.AnilloSAAB		=2;
			this.Coordenadas	="";
			this.Clima			="frio";
			this.PisoTermico	="2400";
			
			break;
		case "chipaque":
			
			this.id				=2;
			this.TipoEntorno	="rural";
			this.AnilloSAAB		=2;
			this.Coordenadas	="";
			this.Clima			="frio";
			this.PisoTermico	="2400";
			
			break;
		case "choachi":
			
			this.id				=3;
			this.TipoEntorno	="rural";
			this.AnilloSAAB		=2;
			this.Coordenadas	="";
			this.Clima			="frio";
			this.PisoTermico	="2400";
			
			break;			
		case "fomeque":
			
			this.id				=4;
			this.TipoEntorno	="rural";
			this.AnilloSAAB		=2;
			this.Coordenadas	="";
			this.Clima			="frio";
			this.PisoTermico	="2400";
			
			break;
		case "fusagasuga":
			
			this.id				=5;
			this.TipoEntorno	="rural";
			this.AnilloSAAB		=2;
			this.Coordenadas	="";
			this.Clima			="frio";
			this.PisoTermico	="2400";
			
			break;
		case "pasca":
			
			this.id				=6;
			this.TipoEntorno	="rural";
			this.AnilloSAAB		=2;
			this.Coordenadas	="";
			this.Clima			="frio";
			this.PisoTermico	="2400";
			
			break;
		case "ubaque":
			
			this.id				=7;
			this.TipoEntorno	="rural";
			this.AnilloSAAB		=2;
			this.Coordenadas	="";
			this.Clima			="frio";
			this.PisoTermico	="2400";
			
			break;
		case "une":
			
			this.id				=8;
			this.TipoEntorno	="rural";
			this.AnilloSAAB		=2;
			this.Coordenadas	="";
			this.Clima			="frio";
			this.PisoTermico	="2400";
			
			break;
		case "mosquera":
			
			this.id				=9;
			this.TipoEntorno	="rural";
			this.AnilloSAAB		=1;
			this.Coordenadas	="";
			this.Clima			="frio";
			this.PisoTermico	="2400";
			
			break;
		case "la calera":
			
			this.id				=10;
			this.TipoEntorno	="rural";
			this.AnilloSAAB		=1;
			this.Coordenadas	="";
			this.Clima			="frio";
			this.PisoTermico	="2400";
			
			break;
		case "Bogota":
			
			this.id				=11;
			this.TipoEntorno	="Urbano";
			this.AnilloSAAB		=1;
			this.Coordenadas	="";
			this.Clima			="frio";
			this.PisoTermico	="2600";
			
			break;
		}
		
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
	 * @return the tipoEntorno
	 */
	public String getTipoEntorno() {
		return TipoEntorno;
	}

	/**
	 * @param tipoEntorno the tipoEntorno to set
	 */
	public void setTipoEntorno(String tipoEntorno) {
		TipoEntorno = tipoEntorno;
	}

	/**
	 * @return the anilloSAAB
	 */
	public int getAnilloSAAB() {
		return AnilloSAAB;
	}

	/**
	 * @param anilloSAAB the anilloSAAB to set
	 */
	public void setAnilloSAAB(int anilloSAAB) {
		AnilloSAAB = anilloSAAB;
	}

	/**
	 * @return the coordenadas
	 */
	public String getCoordenadas() {
		return Coordenadas;
	}

	/**
	 * @param coordenadas the coordenadas to set
	 */
	public void setCoordenadas(String coordenadas) {
		Coordenadas = coordenadas;
	}

	/**
	 * @return the clima
	 */
	public String getClima() {
		return Clima;
	}

	/**
	 * @param clima the clima to set
	 */
	public void setClima(String clima) {
		Clima = clima;
	}

	/**
	 * @return the pisoTermico
	 */
	public String getPisoTermico() {
		return PisoTermico;
	}

	/**
	 * @param pisoTermico the pisoTermico to set
	 */
	public void setPisoTermico(String pisoTermico) {
		PisoTermico = pisoTermico;
	}
	

}
