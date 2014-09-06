package simulaSAAB.modeloSimulacion.comunicacion;

import simulaSAAB.modeloSimulacion.agentes.AgenteSaab;

public abstract class Conversacion {
	
	protected static int SecuenciaId;
	
	protected final int ConversacionId;
	
	protected AgenteSaab emisor;
	
	protected AgenteSaab receptor;
	
	protected MensajeACL mensaje;
	
	
	/**
	 * Constructor
	 */
	public Conversacion(){
		ConversacionId = SecuenciaId+1;
		SecuenciaId++;
	}
	
	/**
	 * Constructor
	 * @param e Agente emisor inicial en la convesación
	 * @param r Agente receptor inicial en la conversación
	 */
	public Conversacion(AgenteSaab e, AgenteSaab r){
		ConversacionId = SecuenciaId+1;
		SecuenciaId++;
		
		this.emisor 	=e;
		this.receptor 	=r;
	}
	
	/**
	 * Protocolo de ejecución de la conversación
	 */
	public abstract void protocoloDeConversacion();
	
	

	/**
	 * @return the conversacionId
	 */
	public int getConversacionId() {
		return ConversacionId;
	}

	public AgenteSaab getEmisor() {
		return emisor;
	}

	public void setEmisor(AgenteSaab emisor) {
		this.emisor = emisor;
	}

	public AgenteSaab getReceptor() {
		return receptor;
	}

	public void setReceptor(AgenteSaab receptor) {
		this.receptor = receptor;
	}

	public MensajeACL getMensaje() {
		return mensaje;
	}

	public void setMensaje(MensajeACL mensaje) {
		this.mensaje = mensaje;
	}
	

}
