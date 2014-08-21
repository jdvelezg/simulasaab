/**
 * 
 */
package simulaSAAB.modeloSimulacion.inteligencia;

import java.util.ArrayList;
import java.util.List;

import repast.simphony.space.projection.Projection;
import repast.simphony.util.ContextUtils;
import repast.simphony.context.Context;
import simulaSAAB.main.VariablesGlobales;
import simulaSAAB.modeloSimulacion.AmbienteLocal;
import simulaSAAB.modeloSimulacion.Producto;
import simulaSAAB.modeloSimulacion.agentes.AgenteSaab;
import simulaSAAB.modeloSimulacion.agentes.Intermediario;
import simulaSAAB.modeloSimulacion.comunicacion.Accion;
import simulaSAAB.modeloSimulacion.comunicacion.Item;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;
import simulaSAAB.modeloSimulacion.inteligencia.CerebroDeAprendizaje.EvaluarExperiencia;
import simulaSAAB.modeloSimulacion.inteligencia.CerebroDeDecision.FijarSistemasActividadHumana;
import simulaSAAB.modeloSimulacion.tareas.SistemaActividadHumana;
import simulaSAAB.persistencia.ConfiguracionStatelessEJB;

/**
 * @author dampher
 *
 */
public class CerebroIntermediario implements CerebroDeDecision, CerebroDeAprendizaje{
	
	private Intermediario intermediario;
	
	public CerebroIntermediario(Intermediario i){
		
		this.intermediario = i;
		
	}
	
	@Override
	public Proposito fijarProposito(List<Producto> productos){
		
		//Inicializa el proposito
		Proposito proposito = new Proposito();
		
		//Lista productos en orden
		//productos = new ConfiguracionStatelessEJB("ASC").obtenerProductosConfigurados(productos);
		
		Object inter = this.intermediario;
		
		//Consulta contexto de intermediario
		Context<Object> context = ContextUtils.getContext(inter);
		
		
		for(Producto p: productos){
		
			if(context.getProjection(VariablesGlobales.RED_AGRORED)!= null){		
				proposito.setAccion(new Accion("Comprar"));
				proposito.setPretencion(new Item(p.getNombre(),"Producto"));
				proposito.setComplemento("en la ubicacion de oferta con menor valor");
			}
			else if (context.getProjection(VariablesGlobales.RED_NUTRIRED) != null){
				proposito.setAccion(new Accion("Vender"));
				proposito.setPretencion(new Item(p.getNombre(),"Producto"));
				proposito.setComplemento("en la ubicacion de demanda con mayor valor");
			}else{
				proposito.setAccion(new Accion("Comprar"));
				proposito.setPretencion(new Item(p.getNombre(),"Producto"));
				proposito.setComplemento("en la tienda mas cercana");				
			}
		
		}
		
		return proposito;
	}

	@Override
	public SistemaActividadHumana escogerSistemaActividadHumana(Proposito proposito,List<SistemaActividadHumana> actividades) {
		
		return new FijarSistemasActividadHumana().escogerSistemaActividadHumana(proposito, actividades, this.intermediario);
	}	
	
	@Override
	public void evaluarExperiencia() {
		
		new EvaluarExperiencia().generarExperiencia(this.intermediario);
		
	}

}
