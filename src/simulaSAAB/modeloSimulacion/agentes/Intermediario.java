/**
 * 
 */
package simulaSAAB.modeloSimulacion.agentes;

import java.util.List;

import simulaSAAB.modeloSimulacion.Producto;
import simulaSAAB.modeloSimulacion.Terreno;
import simulaSAAB.modeloSimulacion.comunicacion.Item;
import simulaSAAB.modeloSimulacion.comunicacion.Objetivo;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;
import simulaSAAB.modeloSimulacion.comunicacion.Utilidad;
import simulaSAAB.modeloSimulacion.inteligencia.CerebroProductor;
import simulaSAAB.modeloSimulacion.tareas.SistemaActividadHumana;
import simulaSAAB.persistencia.AgenteConfigurado;

/**
 * @author dampher
 *
 */
public class Intermediario extends ActorDeAbastecimiento {
	
	private int AgentID;
	
	private String Nombre;
	
	private String Estado;
	
	private Objetivo Objetivo;
	
	private Item Dinero;

	private List<Item> Posesiones;
	
	//private CerebroIntermediario Cerebro;
	
	private Proposito PropositoVigente;
	
	private SistemaActividadHumana actividadVigente;
	
	/**
	 * Constructor
	 */
	public Intermediario(){
		
		AgenteConfigurado agt 	=new AgenteConfigurado("Intermediario");
		this.Nombre				=agt.getTipo();
		this.Objetivo 			=agt.getObjetivo();
		//this.Cerebro	=new CerebroIntermediario();
		
		this.estado = "IDLE";
		
	}

	/* (non-Javadoc)
	 * @see simulaSAAB.modeloSimulacion.agentes.AgenteSaab#sendMessage()
	 */
	@Override
	public void sendMessage() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see simulaSAAB.modeloSimulacion.agentes.AgenteSaab#receiveMessage()
	 */
	@Override
	public void receiveMessage() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see simulaSAAB.modeloSimulacion.agentes.ActorDeAbastecimiento#atribuirSignificadoAlMundoPercibido()
	 */
	@Override
	public List<Producto> atribuirSignificadoAlMundoPercibido() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see simulaSAAB.modeloSimulacion.agentes.ActorDeAbastecimiento#formarIntenciones(java.util.List)
	 */
	@Override
	public void formarIntenciones(List<Producto> productos) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see simulaSAAB.modeloSimulacion.agentes.ActorDeAbastecimiento#actuar()
	 */
	@Override
	public Utilidad actuar() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see simulaSAAB.modeloSimulacion.agentes.ActorDeAbastecimiento#juzgarMundoSegunEstandares(simulaSAAB.modeloSimulacion.comunicacion.Utilidad)
	 */
	@Override
	public void juzgarMundoSegunEstandares(Utilidad resultar) {
		// TODO Auto-generated method stub

	}

}
