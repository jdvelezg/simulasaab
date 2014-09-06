package simulaSAAB.modeloSimulacion.comunicacion;

import simulaSAAB.modeloSimulacion.agentes.AgenteSaab;

public class NegociarProducto extends Conversacion {
	
	private Oferta Oferta;
	
	private Demanda Demanda;
	
	/**
	 * Constructor
	 * @param e
	 * @param r
	 */
	public NegociarProducto(AgenteSaab e, AgenteSaab r){
		super(e,r);
	}
		
	/**
	 * Constructor
	 * @param e Agente emisor
	 * @param r Agente receptor
	 * @param o Oferta del emisor
	 * @param d Demanda del receptor
	 */
	public NegociarProducto(AgenteSaab e, AgenteSaab r, Oferta o, Demanda d){
		super();
		this.emisor 	= e;
		this.receptor	= r;
		this.Oferta		= o;
		this.Demanda	= d;
	}

	@Override
	public void protocoloDeConversacion() {
		// TODO Auto-generated method stub
		
		Preposicion PrepEmisor;
		MensajeACL ACLEmisor;
		MensajeACL Respuesta;
		
		try{//En caso que los parametros no hallan sido inicializados
			
			//crea preposicion comprar producto a precio
			PrepEmisor 	= new ComprarProductoAPrecio(Oferta.getProducto(),Oferta.getPrecio());
			
			//crea mensaje acl con preposicion para el emisor
			ACLEmisor 	= new MensajeACL();
			
			ACLEmisor.setSender(emisor);
			ACLEmisor.setReceiver(receptor);
			ACLEmisor.setProtocol(this.getClass().toString());
			ACLEmisor.setPerformative("propose");
			ACLEmisor.setReplyWith("accept-proposal");
			ACLEmisor.setContent(PrepEmisor);
					
			//envia mensaje a receptor // devuelve respuesta
			Respuesta = receptor.receiveMessage(ACLEmisor);
			
			if(Respuesta.getPerformative().equalsIgnoreCase("accept-proposal")){//si acepta->EJECUTA TRANSACCION
				
				
				
			}else if(Respuesta.getPerformative().equalsIgnoreCase("reject-proposal")){//si NOAcepta
				
				//receptor definir demanda
				
				//->negociarProducto
				
			}
			
			
			
			
		}catch(NullPointerException e){
			System.out.println("ERROR CONVERSACION:Parametros no inicializados? ");
		}
		
		

	}

	public Oferta getOferta() {
		return Oferta;
	}

	public void setOferta(Oferta oferta) {
		Oferta = oferta;
	}

	public Demanda getDemanda() {
		return Demanda;
	}

	public void setDemanda(Demanda demanda) {
		Demanda = demanda;
	}

}
