package simulaSAAB.modeloSimulacion.comunicacion;


public class Proposito implements Concepto {
	
	private int id;	
	
	private Accion accion;
	
	private Item pretencion;
	
	private String complemento;
	
	/**
	 * Constructor
	 */
	public Proposito(){
		
	}
	
	/**
	 * Constructor
	 * @param accion
	 * @param pretencion
	 * @param complemento
	 */
	public Proposito(Accion accion, Item pretencion, String complemento){
		
		this.accion		=accion;
		this.pretencion =pretencion;
		this.complemento=complemento;
		
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
	 * @return the enunciado
	 */
	public String getEnunciado() {
		return this.accion.getVerbo()+" "+pretencion.getNombre()+" "+this.complemento;
	}	

	/**
	 * @return the accion
	 */
	public Accion getAccion() {
		return accion;
	}

	/**
	 * @param accion the accion to set
	 */
	public void setAccion(Accion accion) {
		this.accion = accion;
	}

	/**
	 * @return the pretencion
	 */
	public Item getPretencion() {
		return pretencion;
	}

	/**
	 * @param pretencion the pretencion to set
	 */
	public void setPretencion(Item pretencion) {
		this.pretencion = pretencion;
	}

	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @param complemento the complemento to set
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	

}
