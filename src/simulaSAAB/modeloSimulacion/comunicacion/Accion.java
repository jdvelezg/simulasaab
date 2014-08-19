package simulaSAAB.modeloSimulacion.comunicacion;

public class Accion {
	
	private static int consecutivo;
	
	private int id;
	
	private String verbo;
	
	/**
	 * Constructor
	 */
	public Accion(){
		id=consecutivo++;
	}
	/**
	 * Constructor
	 */
	public Accion(String verbo){
		id=consecutivo++;
		this.verbo 	= verbo;
		
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
