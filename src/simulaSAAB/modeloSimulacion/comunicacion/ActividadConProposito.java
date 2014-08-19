package simulaSAAB.modeloSimulacion.comunicacion;

import simulaSAAB.modeloSimulacion.tareas.SistemaActividadHumana;

public class ActividadConProposito extends Accion {
	
	private static int consecutivo;
	
	private int id;
	
	private String nombre;
	
	private Proposito Proposito;	
			
	/**
	 * Constructor
	 * @param a
	 */
	public ActividadConProposito(SistemaActividadHumana a){
		
		this.id			= this.consecutivo++;		
		this.nombre 	= a.getEnunciado();
		this.Proposito	= a.getProposito();
	}
	
	

}
