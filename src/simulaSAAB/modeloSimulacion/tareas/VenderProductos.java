package simulaSAAB.modeloSimulacion.tareas;

import java.util.Iterator;
import java.util.List;

import repast.simphony.context.Context;
import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.space.graph.Network;
import repast.simphony.util.ContextUtils;
import repast.simphony.util.collections.IndexedIterable;
import simulaSAAB.contextos.GeografiaFija;
import simulaSAAB.main.VariablesGlobales;
import simulaSAAB.modeloSimulacion.AmbienteLocal;
import simulaSAAB.modeloSimulacion.comunicacion.Demanda;
import simulaSAAB.modeloSimulacion.comunicacion.Oferta;
import simulaSAAB.modeloSimulacion.CentroUrbano;
import simulaSAAB.modeloSimulacion.agentes.AgenteSaab;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;

public abstract class VenderProductos implements SistemaActividadHumana {
		
	public String enunciado;
	
	public Proposito Proposito;
	
	public String Estado;
	
	public int paso;
	
	public final double Tickinicial;
	
	public Oferta Oferta;
	
	public CentroUrbano CentroUrbano;
	
	/**
	 * Constructor
	 * @param of
	 */
	public VenderProductos(Oferta of){
		
		this.Oferta	= of;
		Tickinicial	= RunEnvironment.getInstance().getCurrentSchedule().getTickCount();
	}

	@Override
	public String getEnunciado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proposito getProposito() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEstado() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Envia un mensaje con abierto ofertando el producto en la ubicación en que se encuentra el agente
	 */
	public void exponerVentaProducto(){
		
	}

	@Override
	public void secuenciaPrincipalDeAcciones(AgenteSaab actor) {
		// TODO Auto-generated method stub	
		if(this.Estado.compareToIgnoreCase(EstadoActividad.READY.toString())==1){
			
			this.Estado	=EstadoActividad.RUNNING.toString();
			this.paso	=1;
			
		}
		else if(this.Estado.compareToIgnoreCase(EstadoActividad.RUNNING.toString())==1){			
			
			switch(this.paso){
			case 1:
								
				actor.setEstado("ofertando");
				
				//obtiene ambiente local
				AmbienteLocal amb=null;
				
				Context<Object> context 		= ContextUtils.getContext(actor);		
				IndexedIterable<Object> index 	= context.getObjects(AmbienteLocal.class);
				Iterator<Object> iter 			= index.iterator();
				
				while(iter.hasNext()){
					
					amb = (AmbienteLocal)iter.next();			
					if(amb.getGeometria().intersects(actor.getGeometria().getGeometryN(0))){
						break;
					}
				}				
						
				//obtiene lista de centros urbanos		
				if(amb!=null){
					
					List<CentroUrbano> centros = amb.getCentrosUrbanos();
					double distance 	= -1;
					double partialdist	= 0;					
					
					//Devuelve centro urbano mas cercano
					for(CentroUrbano u : centros){				
						partialdist =u.getGeometria().distance(actor.getGeometria());				
						if(distance > partialdist)
							CentroUrbano = u;				
					}
					
					//Obtiene la red de oferta y agrega la oferta ligada al centro urbano.
					if(CentroUrbano!=null){
						Network OfertaNetwork = (Network)ContextUtils.getParentContext(context).getSubContext(VariablesGlobales.CONTEXTO_OFERTA).getProjection(VariablesGlobales.RED_OFERTA);
						OfertaNetwork.addEdge(CentroUrbano, Oferta);
					}else{
						System.out.println("ERROR: IMPOSIBLE AGREGAR OFERTA; No se encontro centro urbano en el ambiente");
						this.Estado ="READY";
						break;
					}
					
				}else{
					//fallo
					System.out.println("ERROR: IMPOSIBLE AGREGAR OFERTA; No se encontro un ambiente local para el agente");
					this.Estado ="READY";
					break;
				}
				
				this.paso++;				
				break;				
			case 2:
								
				//espera x numero de ticks
				
				Double CurrentTick = RunEnvironment.getInstance().getCurrentSchedule().getTickCount();
				
				if(CurrentTick-Tickinicial>=10){
					this.paso++;
				}
				
				break;
			case 3:
				if(Oferta.getEstado().compareToIgnoreCase("vendida")==0){
					
					this.paso	= 0;
					this.Estado = "DONE";
					actor.setEstado("IDLE");
					break;
					
				}else{// if sin respuesta - busca en red las demandas
					
					this.paso++;
				}
												
				break;
			case 4:				
				
				// Busca demanda de mayor precio **1
				Context<Object> OfferContext = ContextUtils.getContext(Oferta);
				Network OfferNetwork 		 = (Network)OfferContext.getProjection(VariablesGlobales.RED_OFERTA);
				Iterable Demandas			 = OfferNetwork.getEdges(CentroUrbano);
				Iterator DemIter			 = Demandas.iterator();
				Demanda demanda				 = null;
				double tempPrecio			 =-1;
				
				while(DemIter.hasNext()){
					
					Demanda temp = (Demanda)DemIter.next();					
					if(temp.getPrecio()>tempPrecio)
						demanda = temp;
					
				}
				//vende: ENVIA MENSAJE "VENDO"
				demanda.getDemandante().sendMessage();
				
				this.paso++;				
				break;
			case 5:
				
				//espera x numero de ticks
				
				Double CurrentTick2 = RunEnvironment.getInstance().getCurrentSchedule().getTickCount();
				
				if(CurrentTick2-Tickinicial>=10){
					this.paso++;
				}
				
				break;
			case 6:

				//mas producto? SI -> vuelve a **1 (paso4)
				if(Oferta.getEstado().compareToIgnoreCase("vendida")==0){
					
					this.paso	= 0;
					this.Estado = "DONE";
					actor.setEstado("IDLE");
					break;
					
				}else{// if sin respuesta - busca en red las demandas
					
					this.paso=4;
				}
					
				break;
			default:
				this.Estado ="DONE";
			}
			
		}else if(this.Estado.compareToIgnoreCase(EstadoActividad.DONE.toString())==1){
			
		}

	}

}
