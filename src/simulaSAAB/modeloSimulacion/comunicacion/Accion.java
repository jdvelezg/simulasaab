package simulaSAAB.modeloSimulacion.comunicacion;

public class Accion {
	
	private static int SecuenciaId;
		
	private final int id;
	
	private String verbo;
	
	/**
	 * Constructor
	 */
	public Accion(){
		id=SecuenciaId+1;
		SecuenciaId++;
	}
	/**
	 * Constructor
	 */
	public Accion(String verbo){
		id=SecuenciaId+1;
		SecuenciaId++;
		this.verbo 	= verbo;
		
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}	

	/**
	 * @return the verbo
	 */
	public String getVerbo() {
		return verbo;
	}


	/**
	 * @param verbo the verbo to set
	 */
	public void setVerbo(String verbo) {
		this.verbo = verbo;
	}

	

}
