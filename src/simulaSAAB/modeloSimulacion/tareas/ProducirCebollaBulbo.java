package simulaSAAB.modeloSimulacion.tareas;

import simulaSAAB.modeloSimulacion.Producto;
import simulaSAAB.modeloSimulacion.Terreno;
import simulaSAAB.modeloSimulacion.agentes.AgenteSaab;
import simulaSAAB.modeloSimulacion.comunicacion.Accion;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;
import simulaSAAB.persistencia.MPAConfigurado;
import simulaSAAB.persistencia.ProductoConfigurado;

public abstract class ProducirCebollaBulbo implements SistemaActividadHumana {
	
	private Proposito proposito;
	
	private double CostoEjecucion;
	
	private Terreno terreno;
	
	private Producto cebollaBulbo;	
	
	private String Estado;
	
	private int paso;
	
	
	/**
	 * Constructor
	 * @param t
	 */
	public ProducirCebollaBulbo(Terreno t){
		
		MPAConfigurado mpa 	=new MPAConfigurado("ProduccionCebollaBulbo");
		
		this.cebollaBulbo	=new Producto(new ProductoConfigurado("Cebolla de bulbo"));		
		this.proposito 		=mpa.getProposito();
		this.CostoEjecucion	=mpa.getCosto();
		this.terreno		=t;	
		
	}

	@Override
	public Proposito getProposito() {
		return this.proposito;
	}
	
	/**
	 * 
	 */
	@Override
	public void secuenciaPrincipalDeAcciones(AgenteSaab actor){
		if(this.Estado.compareToIgnoreCase(EstadoActividad.READY.toString())==1){
			
			this.Estado	=EstadoActividad.RUNNING.toString();
			this.paso	=1;			
		}
		else{			
			
			switch(this.paso){
			case 1:
				
				this.terreno.setEstado("Preparado");
				this.terreno.setHaUsadas(this.terreno.getHectareas());
				this.terreno.setUsoSuelo("Agricola");
				actor.setEstado("Preparando");
				
				this.paso++;				
				break;
			case 2:
				
				this.terreno.setEstado("Sembrado");
				actor.setEstado("Sembrando");
				
				this.paso++;				
				break;
			case 3:
								
				actor.setEstado("Cultivo");
				
				this.paso++;				
				break;
			case 4:				
				
				actor.setEstado("Control Cultivo");
				
				this.paso++;				
				break;
			case 5:
				
				
				
				this.paso++;				
				break;
			default:
				this.Estado ="DONE";
			}
			
		}	
	}

}
