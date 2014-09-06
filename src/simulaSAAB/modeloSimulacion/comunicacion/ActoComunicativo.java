/**
 * 
 */
package simulaSAAB.modeloSimulacion.comunicacion;

/**
 * @author dampher
 *
 */
public abstract class ActoComunicativo {
	
	protected static int id;
	
	protected MensajeACL Mensaje;
	
	/**
	 * Constructor
	 */
	public ActoComunicativo(){
		
	}
	
	/**
	 * Constructor
	 * @param m
	 */
	public ActoComunicativo(MensajeACL m){
		
		this.Mensaje = m;
	}

	/**
	 * @return the mensaje
	 */
	public MensajeACL getMensaje() {
		return Mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(MensajeACL mensaje) {
		Mensaje = mensaje;
	}
	

}

class AcceptProposal extends ActoComunicativo{	
	public AcceptProposal(MensajeACL m){
		super(m);
	}
	
}

class CallForProposal extends ActoComunicativo{
	public CallForProposal(MensajeACL m){
		super(m);
	}
}

class Inform extends ActoComunicativo{
	public Inform(MensajeACL m){
		super(m);
	}
}

class NotUnderstood extends ActoComunicativo{
	public NotUnderstood(MensajeACL m){
		super(m);
	}
}

class Propose extends ActoComunicativo{
	public Propose(MensajeACL m){
		super(m);
	}
}

class RejectProposal extends ActoComunicativo{
	public RejectProposal(MensajeACL m){
		super(m);
	}
}