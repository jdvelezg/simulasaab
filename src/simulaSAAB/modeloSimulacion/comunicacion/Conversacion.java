package simulaSAAB.modeloSimulacion.comunicacion;

import simulaSAAB.modeloSimulacion.agentes.AgenteSaab;

public abstract class Conversacion {
	
	protected AgenteSaab emisor;
	
	protected AgenteSaab receptor;
	
	protected MensajeACL mensaje;
	
	
	/**
	 * Constructor
	 */
	public Conversacion(){
		
	}
	
	/**
	 * Constructor
	 * @param e Agente emisor inicial en la convesación
	 * @param r Agente receptor inicial en la conversación
	 */
	public Conversacion(AgenteSaab e, AgenteSaab r){
		
		this.emisor 	=e;
		this.receptor 	=r;
	}
	
	/**
	 * Protocolo de ejecución de la conversación
	 */
	public abstract void protocoloDeConversacion();


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
