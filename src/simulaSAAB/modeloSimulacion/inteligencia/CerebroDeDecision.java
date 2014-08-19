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
		
		public void escogerSistemaActividadHumana(List<Proposito> propositos,AmbienteLocal amb, AgenteSaab agente){
			
			this.Actividades = new ArrayList<SistemaActividadHumana>();
			
			for(Proposito p: propositos){
				
				List<SistemaActividadHumana> act 	= amb.getActividadesViables(p);
				List<Experiencia> experiencia	 	= agente.getExperiencia(p);
				
				if(experiencia.size()==0){
					this.Actividades.add(act.get(0));
				}else{
					Collections.sort(experiencia,new ExperenciaComparator());
					//this.Actividades.add(experiencia.) Obtiene la actividad con proposito en la ubicacion 0
				}
			}					
		}
		
	}

}

class ExperenciaComparator implements Comparator<Experiencia>{

	@Override
	public int compare(Experiencia arg0, Experiencia arg1) {
		// TODO Auto-generated method stub
		return Double.compare(arg0.getPuntajeUtilidad(), arg1.getPuntajeUtilidad());		
	}
	
}
