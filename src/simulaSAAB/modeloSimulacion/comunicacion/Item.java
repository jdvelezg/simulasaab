package simulaSAAB.modeloSimulacion.comunicacion;

public class Item {
	
	private int id;
	
	private String nombre;
	
	private String InstanceOf;
	
	private String UnidadDeMedida;
	
	/**
	 * Constructor
	 * @param nombre
	 * @param tipoObjeto
	 */
	public Item(String nombre, String tipoObjeto){
		
		this.nombre		=nombre;
		this.InstanceOf	=tipoObjeto;
		
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
	 * @return the instanceOf
	 */
	public String getInstanceOf() {
		return InstanceOf;
	}

	/**
	 * @param instanceOf the instanceOf to set
	 */
	public void setInstanceOf(String instanceOf) {
		InstanceOf = instanceOf;
	}

	/**
	 * @return the unidadDeMedida
	 */
	public String getUnidadDeMedida() {
		return UnidadDeMedida;
	}

	/**
	 * @param unidadDeMedida the unidadDeMedida to set
	 */
	public void setUnidadDeMedida(String unidadDeMedida) {
		UnidadDeMedida = unidadDeMedida;
	}
	
	

}
