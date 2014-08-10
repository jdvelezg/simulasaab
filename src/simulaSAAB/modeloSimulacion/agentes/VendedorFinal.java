/**
 * 
 */
package simulaSAAB.modeloSimulacion.agentes;

import java.util.List;

import simulaSAAB.modeloSimulacion.Tienda;
import simulaSAAB.modeloSimulacion.comunicacion.Item;
import simulaSAAB.modeloSimulacion.comunicacion.Objetivo;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;
import simulaSAAB.modeloSimulacion.tareas.SistemaActividadHumana;
import simulaSAAB.persistencia.AgenteConfigurado;

/**
 * @author dampher
 *
 */
public class VendedorFinal extends Intermediario {
	
	private int AgentID;
	
	private String Nombre;
	
	private String Estado;
	
	private Objetivo Objetivo;
	
	private Item Dinero;

	private List<Tienda> tiendas;
	
	//private CerebroIntermediario Cerebro;
	
	private Proposito PropositoVigente;
	
	private SistemaActividadHumana actividadVigente;
	
	public VendedorFinal(){
		
		AgenteConfigurado agt 	=new AgenteConfigurado("VendedorFinal");
		this.Nombre				=agt.getTipo();
		this.Objetivo 			=agt.getObjetivo();
		//this.Cerebro	=new CerebroIntermediario();
		
		this.estado = "IDLE";
	}

}
