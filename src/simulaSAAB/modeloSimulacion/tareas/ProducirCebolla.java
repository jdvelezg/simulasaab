package simulaSAAB.modeloSimulacion.tareas;

import simulaSAAB.modeloSimulacion.Terreno;
import simulaSAAB.modeloSimulacion.agentes.AgenteSaab;
import simulaSAAB.modeloSimulacion.agentes.Productor;
import simulaSAAB.modeloSimulacion.comunicacion.ActividadConProposito;

public class ProducirCebolla extends ProducirCebollaBulbo {
	
	private int paso;
	
	private String Estado;
	
	/**
	 * Constructor
	 * @param t:Terreno en que se ejecuta la tarea
	 */
	public ProducirCebolla(Terreno t) {		
		super(t);
		
		this.paso 	=0;
		this.Estado	="READY";
	}
	
	@Override
	public void secuenciaPrincipalDeAcciones(AgenteSaab actor) {
		
		if(this.Estado.compareToIgnoreCase("READY")==1){
			
			this.Estado	="RUNNING";
			this.paso	=1;
		}
		else{			
			
			switch(this.paso){
			case 1:
				
				this.paso++;				
				break;
			case 2:
				
				this.paso++;				
				break;
			default:
				this.Estado ="DONE";
			}
			
		}		


	}
	
	private void preparacionDelTerreno(Productor actor){
		
	}
	
	private void siembra(Productor actor){
		
	}
	
	private void laboresDeCultivo(Productor actor){
		
	}
	
	private void fertilizacion(Productor actor){
		
	}
	
	private void mantenimiento(Productor actor){
		
	}
	
	private void cosecha(Productor actor){
		
	}
	
	private void comercializacion(Productor actor){
		
	}
	

	@Override
	public String getEstado() {
		// TODO Auto-generated method stub
		return this.Estado;
	}

	@Override
	public String getEnunciado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActividadConProposito getConcepto() {
		// TODO Auto-generated method stub
		return null;
	}

}
