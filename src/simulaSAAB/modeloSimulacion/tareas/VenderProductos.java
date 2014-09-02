package simulaSAAB.modeloSimulacion.tareas;

import java.util.Iterator;
import java.util.List;

import repast.simphony.context.Context;
import repast.simphony.util.ContextUtils;
import repast.simphony.util.collections.IndexedIterable;
import simulaSAAB.contextos.GeografiaFija;
import simulaSAAB.modeloSimulacion.AmbienteLocal;
import simulaSAAB.modeloSimulacion.CentroUrbano;
import simulaSAAB.modeloSimulacion.agentes.AgenteSaab;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;

public abstract class VenderProductos implements SistemaActividadHumana {
	
	String enunciado;
	Proposito Proposito;
	String Estado;
	int paso;
	

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
			CentroUrbano target = null;
			
			//Devuelve centro urbano mas cercano
			for(CentroUrbano u : centros){
				
				partialdist =u.getGeometria().distance(actor.getGeometria());
				
				if(distance > partialdist)
					target = u;
				
			}
		}
				
				
				
				//Obtiene la red de oferta y agrega la oferta ligada al centro urbano.
				
				//espera x numero de ticks
				
					// if sin respuesta - Obtiene red de demandas
					
					// Busca demanda de mayor precio **1
					
					//vende: EVIA MENSAJE "VENDO"
					//sigue protocolo
					
					//mas producto? SI -> vuelve a **1
					//NO ->FIN
		
				//recibe mensaje: "compro"
				//ejecuta protocolo
				//FIN
		
		
		if(this.Estado.compareToIgnoreCase(EstadoActividad.READY.toString())==1){
			
			this.Estado	=EstadoActividad.RUNNING.toString();
			this.paso	=1;			
		}
		else if(this.Estado.compareToIgnoreCase(EstadoActividad.RUNNING.toString())==1){			
			
			switch(this.paso){
			case 1:
								
				actor.setEstado("Preparando");
				
				this.paso++;				
				break;
			case 2:
				
								
				
				this.paso++;				
				break;
			case 3:
								
				
				
				this.paso++;				
				break;
			case 4:				
				
				
				
				this.paso++;				
				break;
			case 5:
				
							
				
				this.paso++;				
				break;
			case 6:
				//ejecuta subsistema de actividad
				
				//verifica si el sistema termino
				
				//si termina suma un paso
				//this.paso++;				
				break;
			default:
				this.Estado ="DONE";
			}
			
		}else if(this.Estado.compareToIgnoreCase(EstadoActividad.DONE.toString())==1){
			
		}

	}

}
