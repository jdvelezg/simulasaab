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
import simulaSAAB.modeloSimulacion.Producto;
import simulaSAAB.modeloSimulacion.agentes.Intermediario;
import simulaSAAB.modeloSimulacion.comunicacion.Accion;
import simulaSAAB.modeloSimulacion.comunicacion.Item;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;
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
	public List<Proposito> fijarPropositos(List<Producto> productos){
		
		//Inicializa el proposito
		ArrayList<Proposito> propositos = new ArrayList<Proposito>();
		
		//Lista productos en orden
		productos = new ConfiguracionStatelessEJB("ASC").obtenerProductosConfigurados(productos);
		
		Object inter = this.intermediario;
		
		//Consulta contexto de intermediario
		Context<Object> context = ContextUtils.getContext(inter);
		
		
		for(Producto p: productos){
		
		if(context.getProjection(VariablesGlobales.RED_AGRORED)!= null){
			
			propositos.add(new Proposito(new Accion("Comprar"),new Item(p.getNombre(),"Producto"),"en la ubicaci�n de oferta con menor valor"));
		}
		else if (context.getProjection(VariablesGlobales.RED_NUTRIRED) != null){ 
		
				propositos.add(new Proposito(new Accion("Vender"),new Item(p.getNombre(),"Producto"),"en la ubicaci�n de demanda con mayor valor"));
			}
		
		}
		
		return propositos;
	}

	@Override
	public void evaluarExperiencia() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SistemaActividadHumana> recordarExperiencia(
			List<SistemaActividadHumana> act) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public SistemaActividadHumana escogerSistemaActividadHumana(
			List<Proposito> propositos, List<SistemaActividadHumana> actividades) {
		// TODO Auto-generated method stub
		return null;
	}

}
