package simulaSAAB.modeloSimulacion.inteligencia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import simulaSAAB.modeloSimulacion.AmbienteLocal;
import simulaSAAB.modeloSimulacion.Producto;
import simulaSAAB.modeloSimulacion.agentes.AgenteSaab;
import simulaSAAB.modeloSimulacion.comunicacion.Experiencia;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;
import simulaSAAB.modeloSimulacion.tareas.SistemaActividadHumana;

public interface CerebroDeDecision extends Cerebro {
	
	public  Proposito fijarProposito(List<Producto> productos);	
	
	public  SistemaActividadHumana escogerSistemaActividadHumana(Proposito proposito,List<SistemaActividadHumana> actividades);
	
	class FijarSistemasActividadHumana{
		
		SistemaActividadHumana Actividad;
		
		/**
		 * Segun los propositos, el ambiente y el agente decide cuales sistemas de actividad humana debería ejecutar buscando la mejor utilidad.
		 * @param propositos
		 * @param amb
		 * @param agente
		 */
		public SistemaActividadHumana escogerSistemaActividadHumana(Proposito p,List<SistemaActividadHumana> act, AgenteSaab agente){
						
			List<Experiencia> experiencia = agente.getExperiencia(p);
				
			if(experiencia.size()==0){
				//Si no tiene experiencia devuelve la primera actividad de la lista
				this.Actividad = act.get(0);
			}else{
				//Organiza el listado de experiencia segun el puntaje de utilidad
				Collections.sort(experiencia,new ExperenciaPuntajeComparator());
				//Escoge la de mayor puntaje de utilidad
				this.Actividad = experiencia.get(0).getActividadEjecutada();
				}
			
			return Actividad;
		}		
		
	}

}


class ExperenciaPuntajeComparator implements Comparator<Experiencia>{

	@Override
	public int compare(Experiencia arg0, Experiencia arg1) {
		// TODO Auto-generated method stub
		return Double.compare(arg0.getPuntajeUtilidad(), arg1.getPuntajeUtilidad());		
	}
	
}
