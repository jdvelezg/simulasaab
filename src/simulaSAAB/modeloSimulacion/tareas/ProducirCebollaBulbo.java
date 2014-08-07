package simulaSAAB.modeloSimulacion.tareas;

import simulaSAAB.main.Producto;
import simulaSAAB.main.Terreno;
import simulaSAAB.modeloSimulacion.agentes.AgenteSaab;
import simulaSAAB.modeloSimulacion.comunicacion.Accion;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;
import simulaSAAB.persistencia.MPAConfigurado;
import simulaSAAB.persistencia.ProductoConfigurado;

public abstract class ProducirCebollaBulbo implements SistemaActividadHumana {
	
	public Proposito proposito;
	
	public double CostoEjecucion;
	
	public Terreno terreno;
	
	public Producto cebollaBulbo;
	
	/**
	 * Constructor
	 * @param t
	 */
	public ProducirCebollaBulbo(Terreno t){
		
		MPAConfigurado mpa 	=new MPAConfigurado("ProduccionCebollaBulbo");
		Producto p 			=new Producto(new ProductoConfigurado("Cebolla de bulbo"));
		
		this.proposito 		=mpa.getProposito();
		this.CostoEjecucion	=mpa.getCosto();
		this.terreno		=t;
		
	}

	@Override
	public Proposito getProposito() {
		return this.proposito;
	}

	@Override
	public abstract void secuenciaPrincipalDeAcciones(AgenteSaab actor);

}
