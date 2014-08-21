/**
 * 
 */
package simulaSAAB.modeloSimulacion.inteligencia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import simulaSAAB.modeloSimulacion.AmbienteLocal;
import simulaSAAB.modeloSimulacion.Producto;
import simulaSAAB.modeloSimulacion.Terreno;
import simulaSAAB.modeloSimulacion.agentes.AgenteSaab;
import simulaSAAB.modeloSimulacion.agentes.Productor;
import simulaSAAB.modeloSimulacion.comunicacion.Accion;
import simulaSAAB.modeloSimulacion.comunicacion.ConceptFactory;
import simulaSAAB.modeloSimulacion.comunicacion.Item;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;
import simulaSAAB.modeloSimulacion.tareas.SistemaActividadHumana;
import simulaSAAB.persistencia.ConfiguracionStatelessEJB;

/**
 * @author dampher
 *
 */
public class CerebroProductor implements CerebroDeDecision, CerebroDeAprendizaje {
	
	private Productor productor;
	
	public CerebroProductor(Productor p){
		
		productor = p;
	}

	/* Devuelve el proposito de produccion del agente, segun el listado de productos viables.
	 * En caso de no tener terrenos disponibles, devuelve null 
	 * @see simulaSAAB.modeloSimulacion.inteligencia.CerebroDeDecision#fijarPropositosDeProduccion()
	 */
	@Override
	public Proposito fijarProposito(List<Producto> productos) {
		
		//Inicializa el proposito
		Proposito proposito = new Proposito();
		
		//Obtiene el terreno que posee el productor
		List<Terreno> terrenos = this.productor.getTerrenosCultivables();
		
		//Obtiene los productos ordenados de mayor a menor utilidad
		//productos = new ConfiguracionStatelessEJB("ASC").obtenerProductosConfigurados(productos);
		
			
		for(Producto p: productos){
			
			double ingreso 	= 0;
			double costo 	= 0.01;
			double utilidad	= 0;
								
			for(Terreno t: terrenos){			
				
				if(t.haDisponibles()>0){ //si tiene hectareas disponibles	
					
					ingreso 	= p.getRendimientohectarea()*t.getHectareas()*p.getPrecioVenta();
					costo 		= t.getHectareas()*p.getCostoproduccionhectarea();
					utilidad 	= ingreso - costo;
					break;										
				}
			}
			
			//Si la utilidad es mayor al 10% del costo, escoge el producto como proposito de produccion
			if(utilidad/costo > 1.1){
				proposito.setAccion(new Accion("Producir"));
				proposito.setPretencion(new Item(p.getNombre(),"Producto"));
				proposito.setComplemento("en todos los terrenos disponibles");
				break;
			}						
		}
		return proposito;		
	}
	

	/* (non-Javadoc)
	 * @see simulaSAAB.modeloSimulacion.inteligencia.CerebroDeDecision#escogerSistemaActividadHumana()
	 */
	@Override
	public SistemaActividadHumana escogerSistemaActividadHumana(Proposito proposito,List<SistemaActividadHumana> actividades) {			
		
		return new FijarSistemasActividadHumana().escogerSistemaActividadHumana(proposito, actividades, this.productor);

	}


	@Override
	public void evaluarExperiencia() {
		
		new EvaluarExperiencia().generarExperiencia(this.productor);
		
	}



}
