package simulaSAAB.modeloSimulacion.comunicacion;

public class Accion {
	
	private int id;
	
	private String verbo;
	
	/**
	 * Constructor
	 */
	public Accion(String verbo){
		
		this.verbo = verbo;
		
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
