/**
 * 
 */
package simulaSAAB.modeloSimulacion.inteligencia;

import java.util.ArrayList;
import java.util.List;

import simulaSAAB.main.Producto;
import simulaSAAB.main.Terreno;
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

	/* (non-Javadoc)
	 * @see simulaSAAB.modeloSimulacion.inteligencia.CerebroDeDecision#fijarPropositosDeProduccion()
	 */
	@Override
	public List<Proposito> fijarPropositos(List<Producto> productos) {
		
		//Inicializa el proposito
		ArrayList<Proposito> propositos = new ArrayList<Proposito>();
		
		//Obtiene el terreno que posee el productor
		Terreno t = new Terreno();
		
		//Obtiene los productos ordenados de mayor a menor utilidad
		productos = new ConfiguracionStatelessEJB("ASC").obtenerProductosConfigurados(productos);
		
			
		for(Producto p: productos){
			
			//si tiene hectareas disponibles
			if(t.haDisponibles()>0){
				
				//costo de producción	=p.getCostoProduccion();
				//precio de venta		=p.getPrecioVenta();
				//rendimiento por ha	=p.getRendimientoHa();
				
				double ingreso 	= p.getRendimientohectarea()*t.getHectareas()*p.getPrecioVenta();
				double costo 	= t.getHectareas()*p.getCostoproduccionhectarea();
				double utilidad = ingreso - costo;
				
				//Si la utilidad es mayor al 10% del costo
				if(utilidad/costo > 1.1){
					propositos.add(new Proposito(new Accion("Producir"),new Item(p.getNombre(),"Producto"),"en todos los terrenos disponibles"));
				}
			}
			
		}
		return propositos;		
	}
	

	/* (non-Javadoc)
	 * @see simulaSAAB.modeloSimulacion.inteligencia.CerebroDeDecision#escogerSistemaActividadHumana()
	 */
	//@Override
	public SistemaActividadHumana escogerSistemaActividadHumana(List<Proposito> propositos,List<SistemaActividadHumana> actividades) {
		
		List<SistemaActividadHumana> ejecutables = new ArrayList<SistemaActividadHumana>();
		
		// filtra las actividades q cumplen con alguno de los propositos
		for(SistemaActividadHumana a : actividades){
			
			for(Proposito p : propositos){
				//si corresponde el proposito
				if(p.equals(a.getProposito())){
					//Agrega la actividad al conjunto de ejecutables
					if(!ejecutables.contains(a)){
						ejecutables.add(a);
					}
					
				}
			}
		}
		//Obtiene las actividades con mayor puntaje de utilidad experimentado
		ejecutables = recordarExperiencia(ejecutables);
		
		//devuelve la de mayor puntaje de utilidad
		return ejecutables.get(0);

	}


	@Override
	public void evaluarExperiencia() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<SistemaActividadHumana> recordarExperiencia(List<SistemaActividadHumana> act) {
		// TODO Auto-generated method stub
		return null;
	}

}
