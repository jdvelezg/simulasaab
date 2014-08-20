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
	
	public  List<Proposito> fijarPropositos(List<Producto> productos);	
	
	//public  SistemaActividadHumana escogerSistemaActividadHumana(List<Proposito> propositos,List<SistemaActividadHumana> actividades);
	
	class FijarSistemasActividadHumana{
		
		List<SistemaActividadHumana> Actividades;
		
		/**
		 * Segun los propositos, el ambiente y el agente decide cuales sistemas de actividad humana debería ejecutar buscando la mejor utilidad.
		 * @param propositos
		 * @param amb
		 * @param agente
		 */
		public void escogerSistemaActividadHumana(List<Proposito> propositos,AmbienteLocal amb, AgenteSaab agente){
			
			this.Actividades = new ArrayList<SistemaActividadHumana>();
			
			for(Proposito p: propositos){
				
				List<SistemaActividadHumana> act 	= amb.getActividadesViables(p);
				List<Experiencia> experiencia	 	= agente.getExperiencia(p);
				
				if(experiencia.size()==0){
					this.Actividades.add(act.get(0));
				}else{
					//Organiza el listado de experiencia segun e puntaje de utilidad
					Collections.sort(experiencia,new ExperenciaPuntajeComparator());
					//Agrega el de mayor puntaje de utilidad
					this.Actividades.add(experiencia.get(0).getActividadEjecutada());
				}
			}					
		}
		
		/**
		 * Devuelve las actividades agregadas al ejecutar el metodo escogerSistemaActividadHumana.
		 * Si el metodo no ha sido llamado, devuelve null.
		 * @return
		 */
		public List<SistemaActividadHumana> getActividades(){
			return Actividades;
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
